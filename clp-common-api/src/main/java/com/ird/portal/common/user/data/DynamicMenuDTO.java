package com.ird.portal.common.user.data;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tim
 */
public class DynamicMenuDTO {

    private List<Module> moduleList = new LinkedList<>();

    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    public static class Module extends ModuleDTO {

        private List<Menu> menuList = new LinkedList<>();

        public List<Menu> getMenuList() {
            return menuList;
        }

        public void setMenuList(List<Menu> menuList) {
            this.menuList = menuList;
        }
    }

    public static class Menu extends FuncDTO {

        private List<FuncDTO> funcList = new LinkedList<>();

        public List<FuncDTO> getFuncList() {
            return funcList;
        }

    }

}
