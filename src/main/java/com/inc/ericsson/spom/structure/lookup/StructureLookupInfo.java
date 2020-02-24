package com.inc.ericsson.spom.structure.lookup;

import java.util.List;

public class StructureLookupInfo {
	private List<StructureLookupObj> dataF;
	private List<String> columnNames;

	StructureLookupInfo() {

	}

	StructureLookupInfo(List<StructureLookupObj> dataF, List<String> columnNames) {
		this.dataF = dataF;
		this.columnNames = columnNames;
	}

	public List<StructureLookupObj> getDataF() {
		return dataF;
	}

	public void setDataF(List<StructureLookupObj> dataF) {
		this.dataF = dataF;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

}
