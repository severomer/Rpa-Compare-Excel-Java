package com.optiim.homework.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.optiim.homework.models.Basvuran;


public class RpaDAO {

	public static final String FIRST_EXCEL_FILE_PATH = "./InputData/Excel1.xlsx";
	public static final String SECOND_EXCEL_FILE_PATH = "./InputData/Excel2.xlsx";
	    
	public List<Basvuran> readFirstFile() throws IOException, InvalidFormatException {

		List<Basvuran> basvuranlarList = new ArrayList<>();

		// Excel dosyasindan ( .xlsx) bir workbook olustur
		Workbook workbook = WorkbookFactory.create(new File(FIRST_EXCEL_FILE_PATH));

		// Sifir indexindeki calisma kagidini -sheet- al
		Sheet sheet = workbook.getSheetAt(0);

		// Baslik satirini atlayarak, satirlari for loop ile al
		// System.out.println("\n\n Birinci Basvuranlar     \n");
		int counter = 0;
		for (Row row : sheet) {

			if (counter == 0) {
				counter++;
				continue;
			}

			Basvuran basvuran = new Basvuran();

			// input Ad
			Cell cell = row.getCell(0);
			basvuran.setAd(cell.getRichStringCellValue().getString());

			// input Soyad
			cell = row.getCell(1);
			basvuran.setSoyad(cell.getRichStringCellValue().getString());

			// input Dogum Tarihi - numeric olarak almada hata veriyor - input sekli
			// non-numeric
			cell = row.getCell(2);
			basvuran.setDogumt(cell.getRichStringCellValue().getString());

			// input mail
			cell = row.getCell(3);
			if (!(cell == null))
				basvuran.setMail(cell.getRichStringCellValue().getString());

			// input telefon
			cell = row.getCell(4);
			if (!(cell == null))
				basvuran.setTelefon((long) cell.getNumericCellValue());

			// input mail
			cell = row.getCell(5);
			if (!(cell == null))
				basvuran.setDurum(cell.getRichStringCellValue().getString());

			// herbir satiri ile basvuran nesnesi oluturup Basvuranlar arraylistine at
			basvuranlarList.add(basvuran);
		}

		// Workbooku kapa
		workbook.close();

		// System.out.println("Basvuranlar:  " + basvuranlarList);

		return basvuranlarList;
	}

	public List<Basvuran> readSecondFile() throws IOException, InvalidFormatException {

		List<Basvuran> basvuranlarList = new ArrayList<>();

		// Excel dosyasindan ( .xlsx) bir workbook olustur
		Workbook workbook = WorkbookFactory.create(new File(SECOND_EXCEL_FILE_PATH));

		// Sifir indexindeki calisma kagidini -sheet- al
		Sheet sheet = workbook.getSheetAt(0);

		// Baslik satirini atlayarak, satirlari for loop ile al
		// System.out.println("\n\n İkinci Basvuranlar   \n");
		int counter = 0;
		for (Row row : sheet) {

			if (counter == 0) {
				counter++;
				continue;
			}

			Basvuran basvuran = new Basvuran();

			// input Ad
			Cell cell = row.getCell(0);
			basvuran.setAd(cell.getRichStringCellValue().getString());

			// input Soyad
			cell = row.getCell(1);
			basvuran.setSoyad(cell.getRichStringCellValue().getString());

			// input Dogum Tarihi
			cell = row.getCell(2);
			basvuran.setDogumt(cell.getRichStringCellValue().getString());

			// input Dogum Yeri
			cell = row.getCell(3);
			if (!(cell == null))
				basvuran.setDogumyeri(cell.getRichStringCellValue().getString());

			// input mail
			cell = row.getCell(4);
			if (!(cell == null))
				basvuran.setMail(cell.getRichStringCellValue().getString());

			// input telefon
			cell = row.getCell(5);
			if (!(cell == null))
				basvuran.setTelefon((long) cell.getNumericCellValue());

			// input calisma
			cell = row.getCell(6);
			if (!(cell == null))
				basvuran.setCalisma(cell.getRichStringCellValue().getString());

			// input uni
			cell = row.getCell(7);
			if (!(cell == null))
				basvuran.setUni(cell.getRichStringCellValue().getString());

			// herbir satiri ile basvuran nesnesi oluturup Basvuranlar arraylistine at
			basvuranlarList.add(basvuran);
		}

		// Workbooku kapa
		workbook.close();

		// System.out.println("Basvuranlar2:  " + basvuranlarList);

		return basvuranlarList;
	}

	public void writeResultToFile(List<Basvuran> resultList) throws IOException, InvalidFormatException {

		String[] columns = { "AD", "SOYAD", "DOĞUM TARİHİ", "DOĞUM YERİ", "MAİL", "TELEFON", "DURUM", "ÇALIŞMA DURUMU",
				"ÜNİVERSİTE" };

		// Workbook olustur
		Workbook workbook = new XSSFWorkbook();

		// Sheet olustur
		Sheet sheet = workbook.createSheet("Rapor");

		// ilk satiri olustur
		Row headerRow = sheet.createRow(0);

		// ilk satir hucrelerini olustur ve sutunlari hucrelere yaz
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
		}

		// diger satirlari olustur ve hucreleri sonuc listesinden alarak yaz
		int rowNum = 1;
		for (Basvuran sonuc : resultList) {
			
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(sonuc.getAd());

			row.createCell(1).setCellValue(sonuc.getSoyad());

			row.createCell(2).setCellValue(sonuc.getDogumt());

			row.createCell(3).setCellValue(sonuc.getDogumyeri());

			row.createCell(4).setCellValue(sonuc.getMail());

			row.createCell(5).setCellValue(sonuc.getTelefon());

			row.createCell(6).setCellValue(sonuc.getDurum());

			row.createCell(7).setCellValue(sonuc.getCalisma());

			row.createCell(8).setCellValue(sonuc.getUni());
		}

		// tum kolonlari icerigi gore ayarla
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Ciktiyi dosyaya yaz
		FileOutputStream fileOut = new FileOutputStream("./Report/Rapor.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		workbook.close();
	}
}
