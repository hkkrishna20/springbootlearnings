package com.cgi.timesheet.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.monitorjbl.xlsx.StreamingReader;


@ComponentScan(basePackages = "com")
@RestController
public class SaveExcelSheetToDatabaseRest {





	public void readFungiCAZymesExcel() throws IOException, InvalidFormatException {
		// File file = new File(filePath + "\\" + fileName);
		String path = System.getProperty("user.dir") + "/RankingFungi_CAZymes.xlsx";
		System.out.println(path);
		File file = new File(path);
		try (Workbook wb = StreamingReader.builder().open(file);) {
			DataFormatter df = new DataFormatter();
			List<List<Cell>> obj = new ArrayList<>();
			for (Row r : wb.getSheetAt(0)) {
				List<Cell> o = new ArrayList<>();
				for (Cell c : r) {
					o.add(c);
				}
				obj.add(o);
			}
			System.out.println(obj.size());
		
		}
		// File file = new File(path);

		// File file = new File("/Final_CAZymes.xlsx");
		// FileInputStream inputStream = new FileInputStream(file);
		DataFormatter df = new DataFormatter();
		List<String> sheetNames = new ArrayList<String>();
		OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());
		XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheetNames.add(wb.getSheetName(i));
			System.out.println(i + " ->" + wb.getSheetName(i));
		}

		Sheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row0 = sheet.getRow(1);
		int maxColumns = 0;
		for (int j = 0; j < row0.getLastCellNum(); j++) {
			if (row0.getCell(j) != null) {
				String value = "";
				value = df.formatCellValue(row0.getCell(j));
				if (value.trim().isEmpty()) {
					maxColumns = j;
				}
			}
		}

		System.out.println(maxColumns + " " + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String genomeCode = "";
			String name = "";
			String published = "";
			String assemblyLength = "";
			String genes = "";

			if (null != sheet.getRow(i)) {
				Row row = sheet.getRow(i);
				row0 = sheet.getRow(1);
				for (int j = 0; j < maxColumns; j++) {
					String value = "";
					try {
						if (row.getCell(j) != null) {
							value = df.formatCellValue(row.getCell(j));
						}
						if ((!value.trim().isEmpty()) && value != null) {
							value = value.trim();
							String cellName = getCellName(row0.getCell(j));
							cellName = cellName.replaceAll("2", "");
							if (j == 0) {
								genomeCode = value;
							}
							if (j == 1) {

								name = value;
							}
							if (j == 2) {

								published = value;
							}
							if (j == 3) {

								assemblyLength = value;
							}
							if (j == 4) {

								genes = value;
							}
						}
					} catch (Exception e) {
						String cellName = getCellName(row0.getCell(j));
						System.out.println("<Exception Block>");
						System.out.println(cellName + "    " + value);
						System.out.println(value);
						System.out.println("</Exception Block>");
						value = "" + value;
						if (j == 0) {

							genomeCode = value;
						}
						if (j == 1) {

							name = value;
						}
						if (j == 2) {

							published = value;
						}
						if (j == 3) {

							assemblyLength = value;
						}
						if (j == 4) {

							genes = value;
						}
					}

				}
			/*	finall.setGenes(genes);
				finall.setAssemblylength(assemblyLength);
				finall.setGenomecode(genomeCode);
				finall.setName(name);
				finall.setPublished(published);
				FungiCAZymesService.add(finall);*/
				System.out.println();
			} else {
				System.out.println(i);

			}

		}
	}

	@RequestMapping(value = "saveFungiRankSheet", method = RequestMethod.GET)
	public ResponseEntity<?> insertFungi(UriComponentsBuilder ucBuilder) throws IOException, InvalidFormatException {
		readFungiCAZymesExcel();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	private static String getCellName(Cell cell) {
		return "" + CellReference.convertNumToColString(cell.getColumnIndex()) + (cell.getRowIndex() + 1);
	}

}