package net.fajarachmad.common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CommonEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author r.fajarachmad@gmail.com
	 * 
	 */
	@NotEmpty
	@Column(name="CreatedBy")
	private String createdBy;
	
	@NotNull
	@Column(name="CreationDate")
	private Date creationDate;
	
	@NotEmpty
	@Column(name="LastUpdatedBy")
	private String lastUpdatedBy;
	
	@NotNull
	@Column(name="LastUpdateDate")
	private Date lastUpdateDate;
	
	@NotNull
	@Column(name="RecordStatus")
	private int recordStatus;
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public int getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}
	
	

}
