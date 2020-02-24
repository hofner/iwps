package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the IWP_ID_ERROR database table.
 * 
 */
//@Entity
//@Table(name="IWP_ID_ERROR")
//@NamedQuery(name="IwpIdError.findAll", query="SELECT i FROM IwpIdError i")
/**
 * 
 * @author ejelgoz
 *
 */
public class IwpIdError implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal description;

	@Column(name="GANTT_XML")
	private BigDecimal ganttXml;

	private BigDecimal instruction;

	@Column(name="IWP_ID")
	private String iwpId;

	private BigDecimal onepager;

	private BigDecimal total;

	public IwpIdError() {
	}

	public BigDecimal getDescription() {
		return this.description;
	}

	public void setDescription(BigDecimal description) {
		this.description = description;
	}

	public BigDecimal getGanttXml() {
		return this.ganttXml;
	}

	public void setGanttXml(BigDecimal ganttXml) {
		this.ganttXml = ganttXml;
	}

	public BigDecimal getInstruction() {
		return this.instruction;
	}

	public void setInstruction(BigDecimal instruction) {
		this.instruction = instruction;
	}

	public String getIwpId() {
		return this.iwpId;
	}

	public void setIwpId(String iwpId) {
		this.iwpId = iwpId;
	}

	public BigDecimal getOnepager() {
		return this.onepager;
	}

	public void setOnepager(BigDecimal onepager) {
		this.onepager = onepager;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}