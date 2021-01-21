package com.optiim.homework.models;

public class Basvuran {

	private String ad;
	private String soyad;
	private String dogumt;
	private String mail;
	private long telefon;
	private String durum;
	private String dogumyeri;
	private String calisma;
	private String uni;
	

	public Basvuran(String ad, String soyad, String dogumt, String mail, long telefon, String durum, String dogumyeri,
			String calisma, String uni) {
		this.ad = ad;
		this.soyad = soyad;
		this.dogumt = dogumt;
		this.mail = mail;
		this.telefon = telefon;
		this.durum = durum;
		this.setDogumyeri(dogumyeri);
		this.setCalisma(calisma);
		this.setUni(uni);
	}




	public Basvuran() {
	}





	@Override
	public String toString() {
		return "Basvuran [ad=" + ad + ", soyad=" + soyad + ", dogumt=" + dogumt + ", mail=" + mail + ", telefon="
				+ telefon + ", durum=" + durum + ", dogumyeri=" + dogumyeri + ", calisma=" + calisma + ", uni=" + uni
				+ "]";
	}



	public String getAd() {
		return ad;
	}




	public void setAd(String ad) {
		this.ad = ad;
	}




	public String getSoyad() {
		return soyad;
	}




	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}




	public String getDogumt() {
		return dogumt;
	}




	public void setDogumt(String dogumt) {
		this.dogumt = dogumt;
	}




	public String getMail() {
		return mail;
	}




	public void setMail(String mail) {
		this.mail = mail;
	}




	public long getTelefon() {
		return telefon;
	}




	public void setTelefon(long d) {
		this.telefon = d;
	}




	public String getDurum() {
		return durum;
	}




	public void setDurum(String durum) {
		this.durum = durum;
	}




	public String getDogumyeri() {
		return dogumyeri;
	}




	public void setDogumyeri(String dogumyeri) {
		this.dogumyeri = dogumyeri;
	}




	public String getCalisma() {
		return calisma;
	}




	public void setCalisma(String calisma) {
		this.calisma = calisma;
	}




	public String getUni() {
		return uni;
	}




	public void setUni(String uni) {
		this.uni = uni;
	}


	
}
