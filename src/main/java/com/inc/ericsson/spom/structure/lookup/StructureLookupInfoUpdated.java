package com.inc.ericsson.spom.structure.lookup;

import java.util.List;

public class StructureLookupInfoUpdated {
	private List<StructureLookupObjUpdated> dataF;
	private List<String> columnNames;

	public StructureLookupInfoUpdated() {
		super();
	}

	public StructureLookupInfoUpdated getData(String questions, List<String> data) {
		// TODO Auto-generated method stub
		return null;
	}

	public StructureLookupInfoUpdated(List<StructureLookupObjUpdated> dataF, List<String> columnNames) {
		this.dataF = dataF;
		this.columnNames = columnNames;
	}

	public List<StructureLookupObjUpdated> getDataF() {
		return dataF;
	}

	public void setDataF(List<StructureLookupObjUpdated> dataF) {
		this.dataF = dataF;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}
}
