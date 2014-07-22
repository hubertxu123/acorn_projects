package com.chinadrtv.uam.model.auth.res;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.chinadrtv.uam.model.auth.MenuGroupMenu;
import com.chinadrtv.uam.model.auth.Resource;

@Entity
@Table(name = "UAM_RESOURCE_MENU", schema = "ACOAPP_UAM")
@PrimaryKeyJoinColumn(name = "ID")
public class ResMenu extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4771307639651256414L;

	@Column(name = "menu_url", length = 255, nullable = false)
	private String menuUrl;
	
	@OneToMany(mappedBy = "menu")
	private Set<MenuGroupMenu> menuGroupMenus = new LinkedHashSet<MenuGroupMenu>();

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Set<MenuGroupMenu> getMenuGroupMenus() {
        return menuGroupMenus;
    }

    public void setMenuGroupMenus(Set<MenuGroupMenu> menuGroupMenus) {
        this.menuGroupMenus = menuGroupMenus;
    }
}
