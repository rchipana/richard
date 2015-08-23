package richard.chipana.veterinaria.jsf;

//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.PageSize;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;
import richard.chipana.veterinaria.bean.Asociado;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.AsociadoFacade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import org.apache.commons.codec.binary.Base64;
import richard.chipana.veterinaria.bean.Distrito;

@Named
@SessionScoped
public class AsociadoController implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.DistritoFacade distritoFacade;
    @EJB
    private richard.chipana.veterinaria.facade.AsociadoFacade ejbFacade;
    private List<Asociado> items = null;
    private Asociado selected;
    private String base64EncryptedString = "";
    private List<Distrito> list_Distrito = null;
    private String filtro = null;
    private String passsDecode = null;

    public AsociadoController() {
    }

    public String getPasssDecode() {
        return passsDecode;
    }

    public void setPasssDecode(String passsDecode) {
        this.passsDecode = passsDecode;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public List<Distrito> getList_Distrito() {
        list_Distrito = distritoFacade.findAll();
        return list_Distrito;
    }

    public void setList_Distrito(List<Distrito> list_Distrito) {
        this.list_Distrito = list_Distrito;
    }

    public Asociado getSelected() {
        return selected;
    }

    public void setSelected(Asociado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AsociadoFacade getFacade() {
        return ejbFacade;
    }

    public Asociado prepareCreate() {
        selected = new Asociado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        byte[] bytesEncoded = Base64.encodeBase64(selected.getPassword().getBytes());
        base64EncryptedString = new String(bytesEncoded);

        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
        System.out.println("Decoded value is " + new String(valueDecoded));
        passsDecode = new String(valueDecoded).toLowerCase();

        if (!ejbFacade.validarDni(selected.getDni()).isEmpty()) {
            JsfUtil.addErrorMessage("El numero de DNI ya existe");
            return;
        }

        if (!ejbFacade.validarPass(base64EncryptedString).isEmpty()) {
            JsfUtil.addErrorMessage("Password ya fue usada pruebe con otra Por Favor");
            return;
        }
        selected.setPassword(base64EncryptedString);
        selected.setEstadoAsc(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AsociadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        enviarCorreo();
        prepareCreate();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AsociadoUpdated"));
    }

    public void destroy() {
        selected.setEstadoAsc(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AsociadoUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void destroyActivar() {
        selected.setEstadoAsc(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AsociadoUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Asociado> getItems() {
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

    public List<Asociado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Asociado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Asociado.class)
    public static class AsociadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AsociadoController controller = (AsociadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "asociadoController");
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
            if (object instanceof Asociado) {
                Asociado o = (Asociado) object;
                return getStringKey(o.getIdAsociado());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Asociado.class.getName()});
                return null;
            }
        }

    }

    /**
     *
     */
    public void buscarLike() {
        items = ejbFacade.selectLike(filtro);
        filtro = null;

    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
        //pdf.setHtmlStyleClass(filtro);
        // pdf.setHtmlStyleClass(filtro);

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "icons" + File.separator + "pdf.png";

        pdf.add(Image.getInstance(logo));

    }

    public void enviarCorreo() {
        String servidorSMTP = "smtp.gmail.com";
        String puerto = "587";
        String usuario = "sonidochipana@gmail.com";
        String password = "uwnizrmzikksjjma";

        String destino = selected.getEmail();
        String asunto = "Clave y Contraseña!";
        String mensaje = "Usuario:" + selected.getDni() + " Contraseña:" + passsDecode;

        Properties props = new Properties();

        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", servidorSMTP);
        props.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(props, null);

        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    destino));
            message.setSubject(asunto);
            message.setSentDate(new Date());
            message.setText(mensaje);

            Transport tr = session.getTransport("smtp");
            tr.connect(servidorSMTP, usuario, password);
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
