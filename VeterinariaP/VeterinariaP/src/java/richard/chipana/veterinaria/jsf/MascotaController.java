package richard.chipana.veterinaria.jsf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import richard.chipana.veterinaria.bean.Mascota;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.MascotaFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import richard.chipana.veterinaria.bean.Asociado;
import richard.chipana.veterinaria.bean.Pelaje;
@Named
@SessionScoped
public class MascotaController  implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.PelajeFacade pelajeFacade;
    @EJB
    private richard.chipana.veterinaria.facade.AsociadoFacade asociadoFacade;
    @EJB
    private richard.chipana.veterinaria.facade.MascotaFacade ejbFacade;
    private List<Mascota> items = null;
    private Mascota selected;
    private Asociado asociado = null;
    private List<Asociado> list_asociado = null;
    private List<Pelaje> list_Especie = null;
    private final String  pathUploadFoto = "C:/Documents and Settings/RICHARD/Escritorio/richi/";

    //variables para imagen
    private UploadedFile fotoFile;
    private boolean disabledFoto = false;
    private List<Map> lstFotoMaps = new ArrayList<>();
    private byte[] fotoByte;
    private StreamedContent fotoImg;
    private boolean visibleLicCond = false;
    private String filtro = null;
    private int uno = 1;
     private int cero = 0;

    public MascotaController() {
    }

    
    
    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public int getCero() {
        return cero;
    }

    public void setCero(int cero) {
        this.cero = cero;
    }

    
    
    
    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    
    
    
    public List<Pelaje> getList_Especie() {
        list_Especie = pelajeFacade.findAll();
        return list_Especie;
    }

    public void setList_Especie(List<Pelaje> list_Especie) {
        this.list_Especie = list_Especie;
    }

    public List<Asociado> getList_asociado() {
        list_asociado = asociadoFacade.findAll();
        return list_asociado;
    }

    public void setList_asociado(List<Asociado> list_asociado) {
        this.list_asociado = list_asociado;
    }

    public Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }

    public boolean isVisibleLicCond() {
        return visibleLicCond;
    }

    public void setVisibleLicCond(boolean visibleLicCond) {
        this.visibleLicCond = visibleLicCond;
    }

    public StreamedContent getFotoImg() {
        return fotoImg;
    }

    public void setFotoImg(StreamedContent fotoImg) {
        this.fotoImg = fotoImg;
    }

    public byte[] getFotoByte() {
        return fotoByte;
    }

    public void setFotoByte(byte[] fotoByte) {
        this.fotoByte = fotoByte;
    }

    public List<Map> getLstFotoMaps() {
        return lstFotoMaps;
    }

    public void setLstFotoMaps(List<Map> lstFotoMaps) {
        this.lstFotoMaps = lstFotoMaps;
    }

    public boolean isDisabledFoto() {
        return disabledFoto;
    }

    public void setDisabledFoto(boolean disabledFoto) {
        this.disabledFoto = disabledFoto;
    }

    public UploadedFile getFotoFile() {
        return fotoFile;
    }

    public void setFotoFile(UploadedFile fotoFile) {
        this.fotoFile = fotoFile;
    }

    public Mascota getSelected() {
        System.out.println("metodo Mascota getSelected");
        return selected;
    }

    public void setSelected(Mascota selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MascotaFacade getFacade() {
        return ejbFacade;
    }

    public Mascota prepareCreate() {
        selected = new Mascota();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        String fileName = fotoFile.getFileName();
        selected.setRuta("Rch" + "_" + UUID.randomUUID().toString().substring(0, 7) + fileName.substring(fileName.lastIndexOf('.'), fileName.length()));
       // selected.setIdAsociado(asociado);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MascotaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }

        // SUBIR LA FOTO
        uploadFoto(fotoFile, selected.getRuta());
        System.out.println("foto subida");
        selected = new Mascota();
    }

    public void update() {
        if (fotoFile != null) {
            String fileName = fotoFile.getFileName();
            selected.setRuta("Rch" + "_" + UUID.randomUUID().toString().substring(0, 7) + fileName.substring(fileName.lastIndexOf('.'), fileName.length()));
        }
        if (asociado != null) {
            selected.setIdAsociado(asociado);
        }

        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MascotaUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }

        // SUBIR LA FOTO
        uploadFoto(fotoFile, selected.getRuta());
        System.out.println("foto subida");
        selected = new Mascota();
    }

    public void destroy() {
        selected.setEstadoMas(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MascotaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void destroyActi() {
        selected.setEstadoMas(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MascotaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    

    public List<Mascota> getItems() {
        if (items == null) {
            items = ejbFacade.selectLike(filtro);
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Mascota> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Mascota> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Mascota.class)
    public static class MascotaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MascotaController controller = (MascotaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mascotaController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Mascota) {
                Mascota o = (Mascota) object;
                return getStringKey(o.getIdMascota());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Mascota.class.getName()});
                return null;
            }
        }

    }

    public void handleFileUpload(FileUploadEvent event) {
        System.out.println("handler foto");
        try {
            lstFotoMaps = new ArrayList<>();
            fotoFile = event.getFile();
            if (verificarJPG(fotoFile)) {
                System.out.println("--------->>>>>" + event.getFile().getFileName());
                fotoByte = IOUtils.toByteArray(fotoFile.getInputstream());
                fotoImg = new DefaultStreamedContent(fotoFile.getInputstream());
                System.out.println("Mensaje de Generado");
            } else {
                fotoFile = null;
                System.out.println("El archivo que trató de ingresar no es un archivo JPG/JPEG original, comuníquese con el administrador del sistema");
            }

        } catch (Exception e) {
            System.out.println("Mensaje de Error");

        }

    }

    public boolean verificarJPG(UploadedFile uf) {
        try {
            InputStream i = uf.getInputstream();
            byte[] id = new byte[4];
            if (i.read(id) == 4) {
                if (((id[0] & 0xFF) == 0xFF) && ((id[1] & 0xFF) == 0xD8) && ((id[2] & 0xFF) == 0xFF) && ((id[3] & 0xFF) == 0xE0)) {
                    return true;
                }
            }

        } catch (Exception ex) {
            System.out.println("Error:NeDocumentoController:verificarPDF:" + ex.getMessage());
        }
        return false;
    }

    public void removeFile() {
        try {
            fotoFile = null;
            fotoImg = null;
        } catch (Exception e) {
            System.out.println("Mensaje de Error");
            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("FileUploadErrorOccured"));
        }
    }

    /**
     * *
     * metodos par subir fotos
     *
     * @param file
     * @param newfilename
     * @return
     */
    public boolean uploadFoto(UploadedFile file, String newfilename) {
        System.out.println("SUBIENDO FOTO");
        boolean res = false;
        try {
            res = copyFileUploadFoto(newfilename, file.getInputstream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }
    }

    public boolean copyFileUploadFoto(String fileName, InputStream in) {
        System.out.println("COPIANDO FOTO");
        boolean res = false;
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(pathUploadFoto + fileName));
            int read = 0;

            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            res = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return res;
        }

    }

    /**
     * ver foto de la ruta
     */
    public StreamedContent FotoDownload(String fileName) {
        try {
            StreamedContent fotoFile;
            InputStream stream = new FileInputStream(pathUploadFoto + fileName);
            //InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(pathAppDownload + fileName);
            fotoFile = new DefaultStreamedContent(stream, "image/jpeg", fileName);
            return fotoFile;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return null;
    }

    /**
     * mostrar la foto en el formulario
     */
    public void verFoto() {
        System.out.println("entro al metodo ver foto");
        fotoImg = FotoDownload(selected.getRuta());

    }
    
    public void buscarLike() {
        items = ejbFacade.selectLike(filtro);
        filtro = null;
        
    }

}
