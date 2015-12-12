package net.fajarachmad.security.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import net.fajarachmad.common.model.CommonEntity;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author r.fajarachmad@gmail.com
 *
 */
@Entity
@Table(name="User", schema="Central")
public class User extends CommonEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="UserGUID")
	@NotNull
	private String userGUID;
	
	@NotNull
	@Max(value=50)
	@Column(name="Username")
	private String username;
	
	@NotNull
	@Max(value=100)
	@Column(name="Password")
	private String password;
	
	@Column(name="SourceGUID")
	private String sourceGUID;
	
	@Column(name="SourceTypeId")
	private Integer sourceTypeId;
	
	@ManyToOne
	@JoinColumn(name="TenantGUID")
	private Tenant Tenant;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="UserRole", 
		joinColumns={ @JoinColumn(name="UserGUID")}, 
		inverseJoinColumns={ @JoinColumn(name="RoleGUID")})
	private List<Role> roles;
	
	
	public String getUserGUID() {
		return userGUID;
	}
	public void setUserGUID(String userGUID) {
		this.userGUID = userGUID;
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
	public String getSourceGUID() {
		return sourceGUID;
	}
	public void setSourceGUID(String sourceGUID) {
		this.sourceGUID = sourceGUID;
	}
	public Integer getSourceTypeId() {
		return sourceTypeId;
	}
	public void setSourceTypeId(Integer sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Tenant getTenant() {
		return Tenant;
	}
	public void setTenant(Tenant tenant) {
		Tenant = tenant;
	}
	
	
	
	
}
