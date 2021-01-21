package com.optiim.homework.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.optiim.homework.models.Basvuran;

import org.apache.logging.log4j.LogManager;

public class RpaService {
	
    private static Logger logger = LogManager.getLogger(RpaService.class);
    
	public List<Basvuran> compareAndCreateResultList(List<Basvuran> basvuranFirstList, List<Basvuran> basvuranSecondList) {
		List<Basvuran> resultList = new ArrayList<>();

		basvuranFirstList.forEach(basvuru1 -> {
			basvuranSecondList.forEach(basvuru2 -> {
				if (compareAndCheckLists(basvuru1, basvuru2)) {
					basvuru2.setDurum(basvuru1.getDurum());
					resultList.add(basvuru2);
				}
				
			});
		});
		
		return resultList;
	}
	
	private boolean compareAndCheckLists(Basvuran basvuran1, Basvuran basvuran2) {
		if (basvuran1.getAd().equals(basvuran2.getAd()) && basvuran1.getSoyad().equals(basvuran2.getSoyad())) {
			
			if (basvuran1.getMail() != null || basvuran1.getTelefon() != 0 || basvuran2.getMail() != null || basvuran2.getTelefon() != 0) {
				
				if ((basvuran1.getMail() != null && basvuran2.getMail() != null) 
						&& basvuran1.getMail().equals(basvuran2.getMail())) {
					return true;
				} else if ((basvuran1.getTelefon() != 0 && basvuran2.getTelefon() != 0) 
						&& basvuran1.getTelefon() == basvuran2.getTelefon()) {
					return true;
				} else {
					logger.info("Olumsuz: Mail veya telefon eslemedi");
					return false;
				}
			} else {
				logger.info("Olumsuz: Mail ve Telefon gibi iletişim bilgileri eksik");
				return false;
			}
		} else {
			logger.info("Olumsuz: isim, soyisimler eslemedi");
			return false;
		}
	}

}