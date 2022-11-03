package com.saludtools.challengefullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="prescriptions")
public class Prescriptions {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idprescription", columnDefinition = "VARCHAR(36)")
	private String idPrescription;
	
	@Column(name = "prescriptiondate", columnDefinition = "DATE")
	private Date prescriptionDate;
	
	@Column(name = "iduser", columnDefinition = "VARCHAR(36)")
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
