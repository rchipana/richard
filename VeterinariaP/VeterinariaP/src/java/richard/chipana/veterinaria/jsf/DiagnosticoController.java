package richard.chipana.veterinaria.jsf;

import richard.chipana.veterinaria.bean.Diagnostico;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.DiagnosticoFacade;

import java.io.Serializable;
import java.util.List;
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
import javax.inject.Inject;
import javax.inject.Named;
import richard.chipana.veterinaria.bean.Asociado;
import richard.chipana.veterinaria.bean.HistoriaClinica;
import richard.chipana.veterinaria.bean.Mascota;
import richard.chipana.veterinaria.facade.AsociadoFacade;
import richard.chipana.veterinaria.facade.HistoriaClinicaFacade;
import richard.chipana.veterinaria.facade.MascotaFacade;

@Named
@SessionScoped
public class DiagnosticoController implements Serializable {

    // @Inject
    EmpleadoController empleadoController;
    @EJB
    private richard.chipana.veterinaria.facade.AsociadoFacade asociadoFacade;
    @EJB
    private richard.chipana.veterinaria.facade.MascotaFacade mascotaFacade;

    @EJB
    private richard.chipana.veterinaria.facade.HistoriaClinicaFacade historiaClinicaFacade;

    @EJB
    private richard.chipana.veterinaria.facade.DiagnosticoFacade ejbFacade;
    private List<Diagnostico> items = null;
    private Diagnostico selected;
    private List<Mascota> list_Mascota;
    private List<Asociado> list_Asociado;
    private Asociado asociado = null;
    private Mascota mascota = null;
    private List<HistoriaClinica> list_HistoriaClinica = null;
    private HistoriaClinica historiaClinica = null;

    public DiagnosticoController() {
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<HistoriaClinica> getList_HistoriaClinica() {
        return list_HistoriaClinica;
    }

    public void setList_HistoriaClinica(List<HistoriaClinica> list_HistoriaClinica) {
        this.list_HistoriaClinica = list_HistoriaClinica;
    }

    public Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public List<Mascota> getList_Mascota() {
        return list_Mascota;
    }

    public void setList_Mascota(List<Mascota> list_Mascota) {
        this.list_Mascota = list_Mascota;
    }

    public List<Asociado> getList_Asociado() {
        list_Asociado = asociadoFacade.findAll();
        return list_Asociado;
    }

    public void setList_Asociado(List<Asociado> list_Asociado) {
        this.list_Asociado = list_Asociado;
    }

    public Diagnostico getSelected() {
        return selected;
    }

    public void setSelected(Diagnostico selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DiagnosticoFacade getFacade() {
        return ejbFacade;
    }

    public Diagnostico prepareCreate() {
        selected = new Diagnostico();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setIdHistoriaClinica(historiaClinica);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DiagnosticoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.

        }

        selected = new Diagnostico();
        asociado = null;
        mascota = null;
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DiagnosticoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DiagnosticoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Diagnostico> getItems() {
        if (items == null) {
            items = getFacade().findAll();
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

    public List<Diagnostico> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Diagnostico> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Diagnostico.class)
    public static class DiagnosticoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DiagnosticoController controller = (DiagnosticoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "diagnosticoController");
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
            if (object instanceof Diagnostico) {
                Diagnostico o = (Diagnostico) object;
                return getStringKey(o.getIdDiagnostico());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Diagnostico.class.getName()});
                return null;
            }
        }

    }

    public void listar_mascotas_AscD() {
        if (asociado != null) {
            list_Mascota = mascotaFacade.list_mascota_Asociado(asociado);
        } else if (asociado == null) {
            list_Mascota = null;

        }

    }

    public void list_Historia_Clinica() {
        historiaClinica = historiaClinicaFacade.list_HistoriaClinicas(asociado, mascota).get(0);
        if (historiaClinica != null) {
            selected.setPeso(historiaClinica.getPeso());
            selected.setTalla(historiaClinica.getTalla());
            selected.setMucosas(historiaClinica.getMucosas());
            selected.setAtendidoPor(empleadoController.nombreUsuario());
        } else {
            System.out.println("fallllooo");

        }
    }

}
