package net.fajarachmad.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import net.fajarachmad.common.model.CommonEntity;

@Entity
@Table(name="Registration", schema="Central")
public class Registration extends CommonEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="RegistrationGUID")
	@NotNull
	private String registrationGUID;
	
	@Column(name="TenantName")
	@NotBlank
	private String tenantName;
	
	@Column(name="Email")
	@Email
	@NotBlank
	private String email;
	
	@Column(name="Username")
	@NotBlank
	private String username;
	
	@Column(name="Password")
	@NotBlank
	private String password;
	
	@Transient
	private String tenantGUID;

	public String getRegistrationGUID() {
		return registrationGUID;
	}

	public void setRegistrationGUID(String registrationGUID) {
		this.registrationGUID = registrationGUID;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTenantGUID() {
		return tenantGUID;
	}

	public void setTenantGUID(String tenantGUID) {
		this.tenantGUID = tenantGUID;
	}
	
	
	
}
