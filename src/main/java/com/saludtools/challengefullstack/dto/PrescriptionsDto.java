package com.saludtools.challengefullstack.dto;

import java.util.Date;

public class PrescriptionsDto {
	
	private String idPrescription;
	
	private Date prescriptionDate;
	
	private String idUser;
	
	public String getIdPrescription() {
		return idPrescription;
	}

	public void setIdPrescription(String idPrescription) {
		this.idPrescription = idPrescription;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}
	

}
