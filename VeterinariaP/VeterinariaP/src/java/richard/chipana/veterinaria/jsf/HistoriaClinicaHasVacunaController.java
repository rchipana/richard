package richard.chipana.veterinaria.jsf;

import richard.chipana.veterinaria.bean.HistoriaClinicaHasVacuna;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.HistoriaClinicaHasVacunaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "historiaClinicaHasVacunaController")
@SessionScoped
public class HistoriaClinicaHasVacunaController implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.HistoriaClinicaHasVacunaFacade ejbFacade;
    private List<HistoriaClinicaHasVacuna> items = null;
    private HistoriaClinicaHasVacuna selected;

    public HistoriaClinicaHasVacunaController() {
    }

    public HistoriaClinicaHasVacuna getSelected() {
        return selected;
    }

    public void setSelected(HistoriaClinicaHasVacuna selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private HistoriaClinicaHasVacunaFacade getFacade() {
        return ejbFacade;
    }

    public HistoriaClinicaHasVacuna prepareCreate() {
        selected = new HistoriaClinicaHasVacuna();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaHasVacunaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaHasVacunaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HistoriaClinicaHasVacunaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HistoriaClinicaHasVacuna> getItems() {
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

    public List<HistoriaClinicaHasVacuna> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HistoriaClinicaHasVacuna> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HistoriaClinicaHasVacuna.class)
    public static class HistoriaClinicaHasVacunaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HistoriaClinicaHasVacunaController controller = (HistoriaClinicaHasVacunaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "historiaClinicaHasVacunaController");
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
            if (object instanceof HistoriaClinicaHasVacuna) {
                HistoriaClinicaHasVacuna o = (HistoriaClinicaHasVacuna) object;
                return getStringKey(o.getIdHistoriaClinicahasVacuna());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HistoriaClinicaHasVacuna.class.getName()});
                return null;
            }
        }

    }

}
