package com.dataeconomy.datamigration.models.metastore;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.dataeconomy.framework.util.DateUtils;
import com.dataeconomy.framework.util.LocalDateDeserializer;
import com.dataeconomy.framework.util.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "entityfiletypestepchunk", schema = "metastore")
@JsonRootName("entityFileTypeStepChunk")
@org.hibernate.annotations.DynamicInsert
@org.hibernate.annotations.DynamicUpdate
@XmlRootElement(name = "entityfiletypestepchunk")
public class EntityFileTypeStepChunk implements AbstractModel {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	@JsonProperty("Key")
	private EntityFileTypeStepChunkKey entityFileTypeStepChunkKey;

	@Column(name = "entityfiletypeid", insertable = false, updatable = false)
	@JsonProperty("EntityFileTypeID")
	private Integer entityFileTypeID;

	@Column(name = "stepid", insertable = false, updatable = false)
	@JsonProperty("StepID")
	private Integer stepID;

	@JsonProperty("ChunkNTile")
	@Column(name = "chunkntile")
	private String chunkNTile;

	@JsonProperty("ChunkOver")
	@Column(name = "chunkover")
	private String chunkOver;

	@JsonProperty("EffectiveDate")
	@Column(name = "effectivedate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(pattern = DateUtils.SIMPLE_DATE_FORMAT)
	private LocalDate effectiveDate;

	@JsonProperty("Active")
	@Column(name = "active")
	private String active;

	@Column(name = "releasenum", nullable = false)
	@JsonProperty("ReleaseNum")
	private Integer releaseNo;

	@Transient
	@JsonIgnore
	private boolean addMode;

	public EntityFileTypeStepChunk(boolean addMode, LocalDate effectiveDate, Integer releaseNo) {
		this.addMode = addMode;
		this.effectiveDate = effectiveDate;
		this.releaseNo = releaseNo;
	}

	public EntityFileTypeStepChunk() {

	}

	// getters and setters

	public EntityFileTypeStepChunkKey getEntityFileTypeStepChunkKey() {
		return entityFileTypeStepChunkKey;
	}

	public void setEntityFileTypeStepChunkKey(EntityFileTypeStepChunkKey entityFileTypeStepChunkKey) {
		this.entityFileTypeStepChunkKey = entityFileTypeStepChunkKey;
	}

	public Integer getEntityFileTypeID() {
		return entityFileTypeID;
	}

	public void setEntityFileTypeID(Integer entityFileTypeID) {
		this.entityFileTypeID = entityFileTypeID;
	}

	public Integer getStepID() {
		return stepID;
	}

	public void setStepID(Integer stepID) {
		this.stepID = stepID;
	}

	public String getChunkNTile() {
		return chunkNTile;
	}

	public void setChunkNTile(String chunkNTile) {
		this.chunkNTile = chunkNTile;
	}

	public String getChunkOver() {
		return chunkOver;
	}

	public void setChunkOver(String chunkOver) {
		this.chunkOver = chunkOver;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
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

	@XmlTransient
	public boolean isAddMode() {
		return addMode;
	}

	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entityFileTypeStepChunkKey == null) ? 0 : entityFileTypeStepChunkKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityFileTypeStepChunk other = (EntityFileTypeStepChunk) obj;
		if (entityFileTypeStepChunkKey == null) {
			if (other.entityFileTypeStepChunkKey != null)
				return false;
		} else if (!entityFileTypeStepChunkKey.equals(other.entityFileTypeStepChunkKey))
			return false;
		return true;
	}

}
