package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORY database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
/**
 * 
 * @author ejelgoz
 *
 */
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CATEGORY")
	private long idCategory;

	private String name;

	//bi-directional many-to-one association to ReadinessRecord
	@OneToMany(mappedBy="category")
	private List<ReadinessRecord> readinessRecords;

	public Category() {
	}

	public long getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReadinessRecord> getReadinessRecords() {
		return this.readinessRecords;
	}

	public void setReadinessRecords(List<ReadinessRecord> readinessRecords) {
		this.readinessRecords = readinessRecords;
	}

	public ReadinessRecord addReadinessRecord(ReadinessRecord readinessRecord) {
		getReadinessRecords().add(readinessRecord);
		readinessRecord.setCategory(this);

		return readinessRecord;
	}

	public ReadinessRecord removeReadinessRecord(ReadinessRecord readinessRecord) {
		getReadinessRecords().remove(readinessRecord);
		readinessRecord.setCategory(null);

		return readinessRecord;
	}

}