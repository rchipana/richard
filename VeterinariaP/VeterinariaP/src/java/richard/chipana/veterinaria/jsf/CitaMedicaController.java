package richard.chipana.veterinaria.jsf;

import java.awt.event.ActionEvent;
import richard.chipana.veterinaria.bean.CitaMedica;
import richard.chipana.veterinaria.jsf.util.JsfUtil;
import richard.chipana.veterinaria.jsf.util.JsfUtil.PersistAction;
import richard.chipana.veterinaria.facade.CitaMedicaFacade;

import java.io.Serializable;
import java.sql.Time;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import richard.chipana.veterinaria.bean.Asociado;
import richard.chipana.veterinaria.bean.Empleado;
import richard.chipana.veterinaria.bean.Mascota;
import richard.chipana.veterinaria.facade.AsociadoFacade;
import richard.chipana.veterinaria.facade.EmpleadoFacade;
import richard.chipana.veterinaria.facade.MascotaFacade;

@Named
@SessionScoped
public class CitaMedicaController implements Serializable {

//    @Inject
//    AsociadoFacade asociadoFacade;
//
//    @Inject
//    MascotaFacade mascotaFacade;
//
//    @Inject
//    EmpleadoFacade empleadoFacade;
//
    @EJB
    private richard.chipana.veterinaria.facade.CitaMedicaFacade ejbFacade;

    @EJB
    private richard.chipana.veterinaria.facade.AsociadoFacade asociadoFacade;

    @EJB
    private richard.chipana.veterinaria.facade.MascotaFacade mascotaFacade;

    @EJB
    private richard.chipana.veterinaria.facade.EmpleadoFacade empleadoFacade;

    private List<CitaMedica> items2 = null;
    private List<CitaMedica> items = null;
    private CitaMedica selected;
    private List<Asociado> list_Asociado = null;
    private List<Mascota> list_Mascota = null;
    private List<Empleado> list_Empleado = null;

    // variables par el ScheduleModel
    private ScheduleModel eventModel;
    // private ScheduleEvent event;
    private Asociado asociado = null;
    private Empleado empleado = new Empleado();
    private Mascota mascota = null;
    private boolean calendar = false;
    private boolean list = false;
    private String filtro = null;
    private Date minDate = new Date();
    private Date minHora = null;
    private CitaMedica citaMedica = null;
    //public String params = null;

    //  Calendar calendario = new GregorianCalendar();
    //private CitaMedica citaMedica = new CitaMedica();
//    public CitaMedica getCitaMedica() {
//        return citaMedica;
//    }
//
//    public void setCitaMedica(CitaMedica citaMedica) {
//        this.citaMedica = citaMedica;
//    }
//    public int getMinHour() {
//        if (minDate.after(Calendar.getInstance().getTime())) {
//            return 0;
//        } else {
//            return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
//        }
//    }
    @PostConstruct
    public void fecha() {
        minDate = new Date(minDate.getYear(), minDate.getMonth(), minDate.getDate() + 1);

        // minDate = new Date(minDate.getYear(), minDate.getMonth(),minDate.get);
        //return minDate;
    }

    public List<CitaMedica> getItems2() {
        return items2;
    }

    public void setItems2(List<CitaMedica> items2) {
        this.items2 = items2;
    }

    public CitaMedica getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitaMedica citaMedica) {
        this.citaMedica = citaMedica;
    }

    public Date getMinHora() {
        return minHora;
    }

    public void setMinHora(Date minHora) {
        this.minHora = minHora;
    }

    public Date getMinDate() {
        //minDate = new Date(minDate.getYear(), minDate.getMonth(), minDate.getDate() + 1);

        return minDate;

    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isCalendar() {
        return calendar;
    }

    public void setCalendar(boolean calendar) {
        this.calendar = calendar;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
//

    public Asociado getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociado asociado) {
        this.asociado = asociado;
    }
//    public ScheduleEvent getEvent() {
//        return event;
//    }
//
//    public void setEvent(ScheduleEvent event) {
//        this.event = event;
//    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public List<Empleado> getList_Empleado() {
        list_Empleado = empleadoFacade.listEmplxTipo();
        return list_Empleado;
    }

    public void setList_Empleado(List<Empleado> list_Empleado) {
        this.list_Empleado = list_Empleado;
    }

    public CitaMedicaController() {
    }

    public List<Asociado> getList_Asociado() {
        list_Asociado = asociadoFacade.findAll();
        return list_Asociado;
    }

    public void setList_Asociado(List<Asociado> list_Asociado) {
        this.list_Asociado = list_Asociado;
    }

    public List<Mascota> getList_Mascota() {
//        if (mascotaFacade.list_mascota_Asociado(selected.getIdAsociado()).isEmpty()) {
//            list_Mascota = mascotaFacade.findAll();
//        } else {
//            list_Mascota = mascotaFacade.list_mascota_Asociado(selected.getIdAsociado());
//        }
        return list_Mascota;
    }

    public void setList_Mascota(List<Mascota> list_Mascota) {
        this.list_Mascota = list_Mascota;
    }

    public CitaMedica getSelected() {

        return selected;
    }

    public void setSelected(CitaMedica selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CitaMedicaFacade getFacade() {
        return ejbFacade;
    }

    public CitaMedica prepareCreate() {
        selected = new CitaMedica();
        initializeEmbeddableKey();
        return selected;
    }

    /**
     * params
     */
    public String paramsResult() {
        String params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("action");
        return params;
    }

    /**
     * VALIDAR HORARIO DE CITA
     *
     * @return
     */
    public boolean validarHorario() {
        boolean flag = true;
        if (empleado == null) {
            JsfUtil.addErrorMessage("Por favor Elige un Medico");
            flag = false;
        }

//        FacesContext fc = FacesContext.getCurrentInstance();
//        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//        String tipobusqueda = params.get("paramBsq");
        Date fechaHoraIni = selected.getFechaInicio();
        Date hora = selected.getHoraIni();
        fechaHoraIni.setHours(hora.getHours());
        selected.setFechaInicio(fechaHoraIni);
//        if (tipobusqueda.equals("1")) {
        //empleado = selected.getIdEmpleado();
        if (selected.getIdCitamedica() != null) {
            citaMedica = ejbFacade.find(this.selected.getIdCitamedica());
            if (citaMedica.getFechaInicio().equals(selected.getFechaInicio())) {
                flag = true;
            } else {
                for (CitaMedica item2 : empleado.getCitaMedicaList()) {
                    if (selected.getFechaInicio().equals(item2.getFechaInicio())) {
                        flag = false;
                    }
                    System.out.println("cita" + citaMedica.getIdCitamedica());
                }
            }
        }
        if (selected == null) {
            for (CitaMedica item1 : empleado.getCitaMedicaList()) {
                if (selected.getFechaInicio().equals(item1.getFechaInicio())) {
                    flag = false;
                    break;

                }
            }
        }
        return flag;

    }

    public void create() {
        try {
            if (!validarHorario()) {
                JsfUtil.addErrorMessage("El horario de la Cita esta Ocupado");
                asociado = null;
                mascota = null;
                inicializar();
                return;
            } else {
                int horaFin = selected.getHoraIni().getHours() + 1;
                int horaSecon = selected.getFechaInicio().getSeconds();
                Date fechaHoraIni = selected.getFechaInicio();
                Date fechaHoraFin = new Date(selected.getFechaInicio().getYear(), selected.getFechaInicio().getMonth(), selected.getFechaInicio().getDate(), horaFin, horaSecon);
                Date hora = selected.getHoraIni();
                fechaHoraIni.setHours(hora.getHours());
                selected.setFechaInicio(fechaHoraIni);
                selected.setFechaFin(fechaHoraFin);
                selected.setEstadoCita("1");
                selected.setEstadoCit(1);
                selected.setIdMascota(mascota);
                selected.setIdEmpleado(empleado);
                selected.setIdAsociado(asociado);
                persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CitaMedicaCreated"));
                if (!JsfUtil.isValidationFailed()) {
                    //items = ejbFacade.ListCiMedico(empleado);
                    inicializar();
                    asociado = null;
                    mascota = null;

                    // Invalidate list of items to trigger re-query.
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update() {
        try {
            if (!validarHorario()) {
                JsfUtil.addErrorMessage("El horario de la Cita esta Ocupado");
                selected = new CitaMedica();
                inicializar();
                return;
            } else {
                int horaFin = selected.getHoraIni().getHours() + 1;
                int horaSecon = selected.getFechaInicio().getSeconds();
                Date fechaHoraIni = selected.getFechaInicio();
                Date fechaHoraFin = new Date(selected.getFechaInicio().getYear(), selected.getFechaInicio().getMonth(), selected.getFechaInicio().getDate(), horaFin, horaSecon);
                Date hora = selected.getHoraIni();
                // Date fin = fechaHoraFin;
                fechaHoraIni.setHours(hora.getHours());
                selected.setFechaInicio(fechaHoraIni);
                selected.setFechaFin(fechaHoraFin);
                selected.setIdAsociado(asociado);
                persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CitaMedicaUpdated"));
                if (!JsfUtil.isValidationFailed()) {
                    items = ejbFacade.ListCiMedico(empleado);
                    inicializar();
                    // Invalidate list of items to trigger re-query.
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CitaMedicaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null;

// Remove selection
            items = ejbFacade.ListCiMedico(empleado);
            inicializar();
            // RequestContext.getCurrentInstance().update(":CitaMedicaListForm:datalist");

            // Invalidate list of items to trigger re-query.
        }
    }

    public List<CitaMedica> getItems() {
//        if (items == null) {
//            items = getFacade().findAll();
//        }
        return items;
    }

    public void lisAsocPot() {
        items2 = ejbFacade.selectLike(filtro);
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

    public List<CitaMedica> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CitaMedica> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CitaMedica.class)
    public static class CitaMedicaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CitaMedicaController controller = (CitaMedicaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "citaMedicaController");
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
            if (object instanceof CitaMedica) {
                CitaMedica o = (CitaMedica) object;
                return getStringKey(o.getIdCitamedica());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CitaMedica.class.getName()});
                return null;
            }
        }

    }

    /**
     * metodos propios
     *
     * @param asociado
     */
    public void listar_mascotas_Asc() {
        if (selected.getIdAsociado() != null) {
            list_Mascota = mascotaFacade.list_mascota_Asociado(selected.getIdAsociado());
        } else {
            System.out.println("--ingreso ---->>>>>" + selected.getIdAsociado());
        }
    }

    //@PostConstruct
    public void inicializar() {

        eventModel = new DefaultScheduleModel();
        try {
            items = ejbFacade.ListCiMedico(empleado);
            for (CitaMedica item : items) {
                DefaultScheduleEvent event = new DefaultScheduleEvent();
                event.setEndDate(item.getFechaFin());
                event.setStartDate(item.getFechaInicio());
                event.setDescription(item.getIdAsociado().getNombreCompletoS());
                event.setData(item.getIdCitamedica());
                event.setTitle(item.getIdAsociado().getNombreCompletoS());

                //event.setAllDay(true);
                event.setEditable(false);
                eventModel.addEvent(event);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cuandoSelecciono(SelectEvent event1) {
        ScheduleEvent scheduleEvent = (ScheduleEvent) event1.getObject();
        for (CitaMedica item : items) {
            if (scheduleEvent.getData() == item.getIdCitamedica()) {
                selected = item;
                break;
            }

        }
    }

    public void nuevoRegistro(SelectEvent event2) {
//        CitaMedica cm = (CitaMedica) event.getObject();
//        selected = cm;
        System.out.println("nuevo registro" + event2.toString());

////        list_Asociado = null;
////        list_Empleado = null;
////        list_Mascota = null;
        // list_Asociado = asociadoFacade.findAll();
        // list_Empleado = empleadoFacade.findAll();
        //list_Mascota = mascotaFacade.findAll();
        ScheduleEvent scheduleEvent = new DefaultScheduleEvent("", (Date) event2.getObject(), (Date) event2.getObject());
        selected = new CitaMedica();

//        eventModel.addEvent(scheduleEvent);
        System.out.println("selected-------" + selected);
        selected.setFechaInicio((scheduleEvent.getStartDate()));
        selected.setFechaFin((scheduleEvent.getEndDate()));

        // selected.setIdAsociado();
        //selected.setDescripcion(scheduleEvent.getDescription());
        // selected.setIdAsociado(asociado);
    }

    public void gurdarCita() {

        System.out.println("imfreso al metodo guirfar cita " + selected);

        if (selected.getIdCitamedica() == null) {

            try {
//                selected.setIdAsociado(asociado);
//                selected.setIdMascota(mascota);
//                selected.setIdEmpleado(empleado);
                ejbFacade.create(selected);
                inicializar();
            } catch (Exception e) {
                System.out.println("error de `persistencia");
            }
            selected = new CitaMedica();

        } else {
            try {
                ejbFacade.edit(selected);

                inicializar();
            } catch (Exception e) {
                System.out.println("error al actializar la cita ");
            }
        }
    }

    public void limparModelo() {
        eventModel.getEvents().clear();
    }

    public void VerEdit(CitaMedica citaMedica) {
        if (citaMedica != null) {
            selected = citaMedica;

        }

    }

    public void renderCalendar() {
        if (empleado == null) {
            setCalendar(false);
            setList(false);
            items = null;
        } else if (empleado != null) {
            items = ejbFacade.ListCiMedico(empleado);
            inicializar();
            setCalendar(true);
            setList(true);
        }
    }

    @SuppressWarnings("null")
    public void changeMascotas() {

        if (asociado == null) {
            list_Mascota = null;
        } else if (asociado != null) {
            list_Mascota = mascotaFacade.list_mascota_Asociado(asociado);
        }

    }

    public void recupCita(CitaMedica medica) {
        selected = medica;
        asociado = medica.getIdAsociado();
        list_Mascota = mascotaFacade.list_mascota_Asociado(asociado);

    }

    public void reiniciar() {
        selected = new CitaMedica();
        list_Asociado = null;
        list_Mascota = null;
    }

    public void listaCitaxAsoc() {
        items = ejbFacade.selectLike(filtro);
        empleado = null;
        //setList(true);
        if (!items.isEmpty()) {
            if (empleado == null) {
                calendar = false;
            }

        }
        filtro = null;

    }

//    public void onDateSelect(SelectEvent selectEvent) {
//        selected = new CitaMedica();
//        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
//
//    }
//
//    public void addEvent(ActionEvent actionEvent) {
//        if (event.getId() == null) {
//            eventModel.addEvent(event);
//        } else {
//            eventModel.updateEvent(event);
//        }
//
//        event = new DefaultScheduleEvent();
//    }
}
