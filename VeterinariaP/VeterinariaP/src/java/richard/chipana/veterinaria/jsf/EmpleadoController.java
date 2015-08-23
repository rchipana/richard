package richard.chipana.veterinaria.jsf;

import richard.chipana.veterinaria.bean.Empleado;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.EmpleadoFacade;

import java.io.Serializable;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import richard.chipana.veterinaria.bean.Horario;
import richard.chipana.veterinaria.bean.TipoEmpleado;

@Named
@SessionScoped
public class EmpleadoController implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.TipoEmpleadoFacade tipoEmpleadoFacade;
    @EJB
    private richard.chipana.veterinaria.facade.HorarioFacade horarioFacade;
    @EJB
    private richard.chipana.veterinaria.facade.EmpleadoFacade ejbFacade;
    private List<Empleado> items = null;
    private Empleado selected;
    private List<Horario> list_horario = null;
    private String base64EncryptedString = "";
    private List<TipoEmpleado> tipoEmpleadoList = null;
    private Empleado empleado = null;
    private String dni = null;
    private String clave = null;
    private String nombreUsuario = null;
    private String filtro = null;
    private boolean permi = false;

    public boolean isPermi() {
        return permi;
    }

    public void setPermi(boolean permi) {
        this.permi = permi;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<TipoEmpleado> getTipoEmpleadoList() {
        tipoEmpleadoList = tipoEmpleadoFacade.findAll();
        return tipoEmpleadoList;
    }

    public void setTipoEmpleadoList(List<TipoEmpleado> tipoEmpleadoList) {
        this.tipoEmpleadoList = tipoEmpleadoList;
    }

    public String getBase64EncryptedString() {
        return base64EncryptedString;
    }

    public void setBase64EncryptedString(String base64EncryptedString) {
        this.base64EncryptedString = base64EncryptedString;
    }

    public List<Horario> getList_horario() {
        list_horario = horarioFacade.findAll();
        return list_horario;
    }

    public void setList_horario(List<Horario> list_horario) {
        this.list_horario = list_horario;
    }

    public EmpleadoController() {
    }

    public Empleado getSelected() {
        return selected;
    }

    public void setSelected(Empleado selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmpleadoFacade getFacade() {
        return ejbFacade;
    }

    public Empleado prepareCreate() {
        selected = new Empleado();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        byte[] bytesEncoded = Base64.encodeBase64(selected.getPassword().getBytes());
        base64EncryptedString = new String(bytesEncoded);
        if (!ejbFacade.validarDni(selected.getDni()).isEmpty()) {
            JsfUtil.addErrorMessage("El numero de DNI ya existe");
            return;
        }

        if (!ejbFacade.validarPass(base64EncryptedString).isEmpty()) {
            JsfUtil.addErrorMessage("Password ya fue usada pruebe con otra Por Favor");
            return;
        }
        selected.setPassword(base64EncryptedString);
        selected.setEstadoEmp(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        prepareCreate();

    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadoUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        selected = new Empleado();
    }

    public void destroy() {
        selected.setEstadoEmp(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadoUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void destroyActivar() {
        selected.setEstadoEmp(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmpleadoUpdated"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Empleado> getItems() {
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

    public List<Empleado> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Empleado> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Empleado.class)
    public static class EmpleadoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpleadoController controller = (EmpleadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empleadoController");
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
            if (object instanceof Empleado) {
                Empleado o = (Empleado) object;
                return getStringKey(o.getIdEmpleado());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empleado.class.getName()});
                return null;
            }
        }

    }

    /**
     *
     * @param numero
     * @param pass
     * @return
     * @throws java.lang.Exception
     */
    public String login() throws Exception {
        byte[] bytesEncoded = Base64.encodeBase64(clave.getBytes());
        base64EncryptedString = new String(bytesEncoded);
        if (ejbFacade.loginEmpleado(dni, base64EncryptedString).isEmpty()) {
            JsfUtil.addErrorMessage("Usuario o Contraseña no Validos");
            return null;
        } else {
            empleado = ejbFacade.loginEmpleado(dni, base64EncryptedString).get(0);
            if (empleado != null) {
            if (empleado.getIdTipoEmpleado().getDescripTipoEmp().equals("ADMINISTRADOR")) {
                setPermi(true);

            } else {
                setPermi(false);
            }
        } else {
            System.out.println("no hay empleado");
        }
            // guarda la sesion para validar que este logueado al ingresar a la pagina con el url
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", empleado);
            nombreUsuario();
            return "inicio.xhtml";
        }
    }

    /**
     *
     * @return
     *
     */
    public void permisos() {

        if (empleado != null) {
            if (empleado.getIdTipoEmpleado().getDescripTipoEmp().equals("ADMINISTRADOR")) {
                setPermi(true);

            } else {
                setPermi(false);
            }
        } else {
            System.out.println("no hay empleado");
        }

    }

    public String nombreUsuario() {
        if (empleado != null) {
            nombreUsuario = empleado.getNombreCompleto();
        }
        return nombreUsuario;
    }

    public String listadoEmleado() {
        return "/empleado/List";

    }

    public String hacerLogout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        //req.getSession().removeAttribute("seguridad_usuario");
        externalContext.invalidateSession();
        empleado = null;
        //Forzar que no se ejecute ajax //
        //return "/faces/login.xhtml?faces-redirect=true";
        return "/faces/login.xhtml?faces-redirect=true";
    }

    public void buscarLike() {
        items = ejbFacade.selectLike(filtro);
        filtro = null;

    }
}
