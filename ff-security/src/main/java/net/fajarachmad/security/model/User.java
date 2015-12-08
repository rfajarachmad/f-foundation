package net.fajarachmad.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	
}
