package com.dataeconomy.datamigration.models.metastore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "entityfiletypeschedulexref", schema = "metastore")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name="entityfiletypeschedulexref")
public class EntityFileTypeScheduleXref  implements AbstractModel{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "entityfiletypeschedid", nullable = false)
	@NotNull
	@Id
	@JsonProperty("EntityFileTypeSchedID")
	private Integer  entityFileTypeSchedID;
	
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;
	
	@JsonProperty("ScheduleFequencyType")
	private String scheduleFequencyType;
	
	@JsonProperty("SchFrequencyValue")
	private Integer schFrequencyValue;
	
	@JsonProperty("ScheduleOffsetType")
	private String  scheduleOffsetType;
	
	@JsonProperty("ScheduleOffsetValue")
	private  Integer scheduleOffsetValue;
	
	@JsonProperty("FileDirection")
	private String fileDirection;
	
	@JsonProperty("Active")
    private String active;
    
    @Column(name = "releasenum", nullable = false)
    @JsonProperty("ReleaseNum")
	private Integer releaseNo;
    

	
	public Integer getEntityFileTypeSchedID() {
		return entityFileTypeSchedID;
	}
	public void setEntityFileTypeSchedID(Integer entityFileTypeSchedID) {
		this.entityFileTypeSchedID = entityFileTypeSchedID;
	}
	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}
	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}
	public String getScheduleFequencyType() {
		return scheduleFequencyType;
	}
	public void setScheduleFequencyType(String scheduleFequencyType) {
		this.scheduleFequencyType = scheduleFequencyType;
	}
	public Integer getSchFrequencyValue() {
		return schFrequencyValue;
	}
	public void setSchFrequencyValue(Integer schFrequencyValue) {
		this.schFrequencyValue = schFrequencyValue;
	}
	public String getScheduleOffsetType() {
		return scheduleOffsetType;
	}
	public void setScheduleOffsetType(String scheduleOffsetType) {
		this.scheduleOffsetType = scheduleOffsetType;
	}
	public Integer getScheduleOffsetValue() {
		return scheduleOffsetValue;
	}
	public void setScheduleOffsetValue(Integer scheduleOffsetValue) {
		this.scheduleOffsetValue = scheduleOffsetValue;
	}
	public String getFileDirection() {
		return fileDirection;
	}
	public void setFileDirection(String fileDirection) {
		this.fileDirection = fileDirection;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getReleaseNo() {
		return releaseNo;
	}
	public void setReleaseNo(Integer releaseNo) {
		this.releaseNo = releaseNo;
	}
	
	
		    		  
}
