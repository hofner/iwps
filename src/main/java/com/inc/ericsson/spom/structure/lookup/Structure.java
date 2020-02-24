package com.inc.ericsson.spom.structure.lookup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpActivityCast;
import com.ericsson.bugs.sdt.dtra.iwp.data.model.IwpCast;

public class Structure {

	

	public StructureLookupInfoUpdated getDataF(List<IwpCast> listIwps) {
		List<StructureLookupObjUpdated> dataF = new ArrayList<StructureLookupObjUpdated>();
		List<String> columnNames = new ArrayList<String>();

		for (IwpCast iwp : listIwps) {
			for (IwpActivityCast activity : iwp.getIwpActivityClear()) {
				StructureLookupObjUpdated o = new StructureLookupObjUpdated(iwp.getIwpId(), activity.getActivityName(),
						activity.getActivitySubdomain(), iwp.getIwpServiceActivityArea(), iwp.getIwpDeliveryOrigin(),
						activity.getJobRole());
				dataF.add(o);
			}
		}
		columnNames.add("IWP_ID");
		columnNames.add("NAME");
		columnNames.add("COMPETENCE_SUB_DOMAIN");
		columnNames.add("SERVICE_AREA");
		columnNames.add("GSC");
		columnNames.add("JOBROLE");
		StructureLookupInfoUpdated structureLookUpInfo = new StructureLookupInfoUpdated(dataF, columnNames);

		return structureLookUpInfo;

	}

	public String generateFile(StructureLookupInfo structureLookUpInfo,
			StructureLookupInfoUpdated structureLookUpInfoUpdated) {

		int rIndex = 1, xIndex = 1, k = 1, l = 1;

		List<String> columnNamesSPD = structureLookUpInfo.getColumnNames();
		List<String> columnNamesSPOM = structureLookUpInfoUpdated.getColumnNames();

		List<StructureLookupObj> structureLookUpList = structureLookUpInfo.getDataF();

		List<StructureLookupObjUpdated> structureLookUpListUpdated = structureLookUpInfoUpdated.getDataF();

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(Util.excelSheetFileName.value);
		HSSFSheet sheet2 = wb.createSheet(Util.excelSheetFileName2.value);

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);

		HSSFRow rowN = sheet2.createRow(0);
		HSSFCell cellN = rowN.createCell(0);

		createRows(columnNamesSPD, k, cell, row);
		createRows(columnNamesSPOM, l, cellN, rowN);

		for (StructureLookupObj o : structureLookUpList) {

			HSSFRow row2 = sheet.createRow(rIndex);

			for (int c = 0; c < columnNamesSPD.size(); c++) {
				HSSFCell cell2 = row2.createCell(c);

				switch (c) {

				case 0:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getCompetenceSubDomain());
					break;
				case 1:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getServiceArea());
					break;
				case 2:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getGsc());
					break;
				case 3:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getJobRole());
					break;

				}
			}
			rIndex++;
		}

		for (StructureLookupObjUpdated o : structureLookUpListUpdated) {

			HSSFRow row2 = sheet2.createRow(xIndex);

			for (int c = 0; c < columnNamesSPOM.size(); c++) {
				HSSFCell cell2 = row2.createCell(c);

				switch (c) {

				case 0:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getIwpId());
					break;

				case 1:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getName());
					break;

				case 2:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getCompetenceSubDomain());
					break;

				case 3:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getServiceArea());
					break;

				case 4:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getGsc());
					break;

				case 5:
					wb.getSheetAt(0).autoSizeColumn(c);
					cell2.setCellValue(o.getJobRole());
					break;

				}

			}
			xIndex++;
		}

		// WRITE ROUTINE
		StringBuilder stringBuilderPath = new StringBuilder();
		String pattern = Util.datePattern.value;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new java.util.Date());
		stringBuilderPath.append(Util.driveLetter.value).append(Util.backSlash.value).append(Util.cast.value)
				.append(Util.backSlash.value).append(Util.iwpFilePath.value).append(Util.backSlash.value)
				.append(Util.excelFileName.value).append(date).append(Util.excelExtension.value);
		String result = "";
		try {
			FileOutputStream fileOut = new FileOutputStream(stringBuilderPath.toString());
			wb.write(fileOut);
			// wb.close();
			fileOut.flush();
			fileOut.close();
			Path path = FileSystems.getDefault().getPath(stringBuilderPath.toString());

			result = stringBuilderPath.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;

	}

	public void createRows(List<String> list, int index, HSSFCell cell, HSSFRow row) {

		for (String s : list) {
			cell.setCellValue(s);
			cell = row.createCell(index);
			index++;
		}
	}

	public StructureLookupInfo getData(List<IwpCast> listIwps) {

		List<StructureLookupObj> dataF = new ArrayList<StructureLookupObj>();
		List<String> columnNames = new ArrayList<String>();
		LinkedHashMap<String, Object[]> mapstruct = new LinkedHashMap<String, Object[]>();
		for (IwpCast iwp : listIwps) {
			for (IwpActivityCast activity : iwp.getIwpActivityClear()) {
				mapstruct.put(
						activity.getActivitySubdomain() + "\\" + iwp.getIwpServiceActivityArea() + "\\"
								+ iwp.getIwpDeliveryOrigin() + "\\" + activity.getJobRole(),
						new Object[] { iwp, activity });

			}
		}

		for (Iterator<String> iterator = mapstruct.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			Object[] objects = mapstruct.get(key);
			IwpCast iwp = (IwpCast) objects[0];
			IwpActivityCast activity = (IwpActivityCast) objects[1];
			StructureLookupObj o = new StructureLookupObj(activity.getActivitySubdomain(),
					iwp.getIwpServiceActivityArea(), iwp.getIwpDeliveryOrigin(), activity.getJobRole());
			dataF.add(o);

		}
		columnNames.add("COMPETENCE_SUB_DOMAIN");
		columnNames.add("SERVICE_AREA");
		columnNames.add("GSC");
		columnNames.add("JOBROLE");

		StructureLookupInfo structureLookUpInfo = new StructureLookupInfo(dataF, columnNames);

		return structureLookUpInfo;

	}

	public enum Util {

		DEV("DEV"), ipOrHostDEV("localhost"), schemaDEV("orcl"), port("1521"), baseJDBCConnectionString(
				"jdbc:oracle:thin:@"), slash("/"), colon(":"), schemaUser("dtra"), comma(","), questionMark(
						"?"), schemaPasswordDev("dtra"), driveLetter(System.getenv("SystemDrive")), backSlash(
								File.separator + File.separator), iwpFilePath("structureLookup"), iwpLoadFileName(
										"iwpsNew.txt"), excelSheetFileName("SPDLookup"), excelSheetFileName2(
												"SPOM Reference"), datePattern("YYYYMMddHHmmss"), excelFileName(
														"SPDLookUPStructure-"), excelExtension(".xls"), cast("cast");

		private String value;

		private Util(String value) {
			this.value = value;
		}
	}

}