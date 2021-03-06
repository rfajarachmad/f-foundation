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
@Table(name="Tenant", schema="Central")
public class Tenant extends CommonEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="TenantGUID")
	@NotNull
	private String tenantGUID;
	
	@Column(name="Code")
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="DbHostname")
	private String dbHostname;
	
	@Column(name="DbUsername")
	private String dbUsername;
	
	@Column(name="DbPassword")
	private String dbPassword;

	public String getTenantGUID() {
		return tenantGUID;
	}

	public void setTenantGUID(String tenantGUID) {
		this.tenantGUID = tenantGUID;
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

	public String getDbHostname() {
		return dbHostname;
	}

	public void setDbHostname(String dbHostname) {
		this.dbHostname = dbHostname;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	
	
	
}
