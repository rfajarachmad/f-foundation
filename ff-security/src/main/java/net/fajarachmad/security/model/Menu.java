package net.fajarachmad.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import net.fajarachmad.common.model.CommonEntity;

@Entity
@Table(name="Menu", schema="Central")
public class Menu extends CommonEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="MenuGUID")
	@NotNull
	private String menuGUID;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Path")
	private String path;

	public String getMenuGUID() {
		return menuGUID;
	}

	public void setMenuGUID(String menuGUID) {
		this.menuGUID = menuGUID;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
