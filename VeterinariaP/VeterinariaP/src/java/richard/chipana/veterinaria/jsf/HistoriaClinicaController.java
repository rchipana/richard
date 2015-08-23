package richard.chipana.veterinaria.jsf;

import richard.chipana.veterinaria.bean.HistoriaClinica;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.HistoriaClinicaFacade;

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
import richard.chipana.veterinaria.bean.Mascota;
import richard.chipana.veterinaria.facade.AsociadoFacade;
import richard.chipana.veterinaria.facade.MascotaFacade;

@Named
@SessionScoped

public class HistoriaClinicaController implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.MascotaFacade mascotaFacade;

    @EJB
    private richard.chipana.veterinaria.facade.AsociadoFacade asociadoFacade;

    @EJB
    private richard.chipana.veterinaria.facade.HistoriaClinicaFacade ejbFacade;
    private List<HistoriaClinica> items = null;
    private HistoriaClinica selected;
    private List<Asociado> lis_Asociado = null;
    private List<Mascota> list_Mascota = null;

    public HistoriaClinicaController() {
    }

    public List<Asociado> getLis_Asociado() {
        lis_Asociado = asociadoFacade.findAll();
        return lis_Asociado;
    }

    public void setLis_Asociado(List<Asociado> lis_Asociado) {
        this.lis_Asociado = lis_Asociado;
    }

    public List<Mascota> getList_Mascota() {
        if (mascotaFacade.list_mascota_Asociado(selected.getIdAsociado()).isEmpty()) {
            list_Mascota = mascotaFacade.findAll();
        } else {
            list_Mascota = mascotaFacade.list_mascota_Asociado(selected.getIdAsociado());
        }
        return list_Mascota;
    }

    public void setList_Mascota(List<Mascota> list_Mascota) {
        this.list_Mascota = list_Mascota;
    }

    public HistoriaClinica getSelected() {
        return selected;
    }

    public void setSelected(HistoriaClinica selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HistoriaClinicaFacade getFacade() {
        return ejbFacade;
    }

    public HistoriaClinica prepareCreate() {
        selected = new HistoriaClinica();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = new HistoriaClinica();

    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = new HistoriaClinica();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HistoriaClinica> getItems() {
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

    public List<HistoriaClinica> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HistoriaClinica> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HistoriaClinica.class)
    public static class HistoriaClinicaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HistoriaClinicaController controller = (HistoriaClinicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "historiaClinicaController");
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
            if (object instanceof HistoriaClinica) {
                HistoriaClinica o = (HistoriaClinica) object;
                return getStringKey(o.getIdHistoriaClinica());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HistoriaClinica.class.getName()});
                return null;
            }
        }

    }

    public void listar_mascotas_AscH() {
        if (selected.getIdAsociado() != null) {
            list_Mascota = mascotaFacade.list_mascota_Asociado(selected.getIdAsociado());
        } else {
            System.out.println("--ingreso ---->>>>>" + selected.getIdAsociado());
        }
    }

}
