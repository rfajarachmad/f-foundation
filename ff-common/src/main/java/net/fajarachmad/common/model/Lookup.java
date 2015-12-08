package net.fajarachmad.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Lookup", schema="Central")
public class Lookup extends CommonEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name="LookupGUID")
	@NotNull
	private String lookupGUID;
	
	@Max(50)
	@NotBlank
	@Column(name="Type")
	private String type;
	
	@Max(50)
	@NotBlank
	@Column(name="Code")
	private String code;
	
	@Max(100)
	@NotBlank
	@Column(name="Name")
	private String name;
	
	@Max(50)
	@Column(name="Val1")
	private String val1;
	
	@Max(50)
	@Column(name="Val2")
	private String val2;
	
	@Max(50)
	@Column(name="Val3")
	private String val3;
	
	@Max(50)
	@Column(name="Val4")
	private String val4;
	
	@Max(50)
	@Column(name="Val5")
	private String val5;
	
	
	public String getLookupGUID() {
		return lookupGUID;
	}
	public void setLookupGUID(String lookupGUID) {
		this.lookupGUID = lookupGUID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getVal1() {
		return val1;
	}
	public void setVal1(String val1) {
		this.val1 = val1;
	}
	public String getVal2() {
		return val2;
	}
	public void setVal2(String val2) {
		this.val2 = val2;
	}
	public String getVal3() {
		return val3;
	}
	public void setVal3(String val3) {
		this.val3 = val3;
	}
	public String getVal4() {
		return val4;
	}
	public void setVal4(String val4) {
		this.val4 = val4;
	}
	public String getVal5() {
		return val5;
	}
	public void setVal5(String val5) {
		this.val5 = val5;
	}
	
	
	

}
