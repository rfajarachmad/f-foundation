package net.fajarachmad.security.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import net.fajarachmad.common.model.CommonEntity;

@Entity
@Table(name="Role", schema="Central")
public class Role extends CommonEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="RoleGUID")
	@NotNull
	private String roleGUID;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="IsInitialRole")
	private boolean initialRole;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="RoleMenu", 
	joinColumns={ @JoinColumn(name="RoleGUID")},
	inverseJoinColumns={ @JoinColumn(name="MenuGUID")})
	private Set<Menu> menus;
	
	public String getRoleGUID() {
		return roleGUID;
	}

	public void setRoleGUID(String roleGUID) {
		this.roleGUID = roleGUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInitialRole() {
		return initialRole;
	}

	public void setInitialRole(boolean initialRole) {
		this.initialRole = initialRole;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	
	
}
