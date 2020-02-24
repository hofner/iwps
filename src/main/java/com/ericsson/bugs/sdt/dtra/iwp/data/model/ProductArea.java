package com.ericsson.bugs.sdt.dtra.iwp.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the SETTING database table.
 * 
 */
@Entity
@Table(name="PRODUCT_AREA")
@NamedQuery(name="ProductArea.findAll", query="SELECT pr FROM ProductArea pr")
/**
 * 
 * @author ejuaolg
 *
 */
public class ProductArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="PRODUCT_CODE_NAME")
	private String productCodeName;
	
	@Column(name="PRODUCT_AREA")
	private String productArea;
	
	@Column(name="PRODUCT_AREA_NAME")
	private String productAreaName;
	
		
	public ProductArea() {
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductCodeName() {
		return productCodeName;
	}


	public void setProductCodeName(String productCodeName) {
		this.productCodeName = productCodeName;
	}


	public String getProductArea() {
		return productArea;
	}


	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}


	public String getProductAreaName() {
		return productAreaName;
	}


	public void setProductAreaName(String productAreaName) {
		this.productAreaName = productAreaName;
	}

}