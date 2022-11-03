package com.saludtools.challengefullstack.dto;

public class MedicinesDto {
	
	private String idMedicine;
	
	private String nameMed;
	
	private Integer minAge;
	
	private Integer maxAge;
	
	private String gender;

	public String getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(String idMedicine) {
		this.idMedicine = idMedicine;
	}

	public String getNameMed() {
		return nameMed;
	}

	public void setNameMed(String nameMed) {
		this.nameMed = nameMed;
	}

	public Integer getMinAge() {
		return minAge;
	}

	public void setMinAge(Integer minAge) {
		this.minAge = minAge;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(Integer maxAge) {
		this.maxAge = maxAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
