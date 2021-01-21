package com.optiim.homework.main;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.optiim.homework.dao.RpaDAO;
import com.optiim.homework.models.Basvuran;
import com.optiim.homework.service.RpaService;

public class StartRpa {
    
	public static void main(String[] args) throws IOException, InvalidFormatException {

		RpaService rpaService = new RpaService();
		RpaDAO rpaDAO = new RpaDAO();

		List<Basvuran> basvuranFirstList = rpaDAO.readFirstFile();
		// System.out.println("Birinci Basvuranlar: " + basvuranFirstList);

		List<Basvuran> basvuranSecondList = rpaDAO.readSecondFile();
		// System.out.println("İkinci Basvuranlar: " + basvuranSecondList);

		List<Basvuran> resultList = rpaService.compareAndCreateResultList(basvuranFirstList, basvuranSecondList);

		rpaDAO.writeResultToFile(resultList);
		
	}
}
