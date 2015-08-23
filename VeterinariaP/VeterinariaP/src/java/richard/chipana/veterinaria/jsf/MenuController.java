/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package richard.chipana.veterinaria.jsf;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import richard.chipana.veterinaria.bean.Empleado;
import richard.chipana.veterinaria.bean.Menu;

/**
 *
 * @author rchipana
 */
@Named
@ViewScoped
public class MenuController implements Serializable {

    @EJB
    private richard.chipana.veterinaria.facade.MenuFacade menuFacade;
    private List<Menu> list_Menu = null;
    private MenuModel menuModel;

    public List<Menu> getList_Menu() {
        return list_Menu;
    }

    public void setList_Menu(List<Menu> list_Menu) {
        this.list_Menu = list_Menu;
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    @PostConstruct
    public void init() {
        this.listarMenus();
    }

    public void listarMenus() {
        list_Menu = menuFacade.findAll();
        menuModel = new DefaultMenuModel();

    }

    @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
    public void establecerPermisos() {
        Empleado empleado = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado");
        for (Menu list_item : list_Menu) {
            if (list_item.getTipo().equals("S") && list_item.getIdTipoEmpleado().equals(empleado.getIdTipoEmpleado())) {
                DefaultSubMenu prime_subMenu = new DefaultSubMenu(list_item.getNombre());
                for (Menu list_item2 : list_Menu) {
                    Menu subMenu = list_item2.getCodigoSubMenu();
                    if (subMenu != null) {
                        if (subMenu.getCodigoMenu() == list_item.getCodigoMenu()) {
                            DefaultMenuItem item = new DefaultMenuItem(list_item.getNombre());
                            prime_subMenu.addElement(item);
                        }
                    } else {
                        System.out.println("sub nenu es null");
                    }
                }

                menuModel.addElement(prime_subMenu);
            } else {
                if (list_item.getCodigoSubMenu() == null && list_item.getIdTipoEmpleado().equals(empleado.getIdTipoEmpleado())) {
                    DefaultMenuItem item = new DefaultMenuItem(list_item.getNombre());
                    menuModel.addElement(item);
                }

            }
        }
    }
}
