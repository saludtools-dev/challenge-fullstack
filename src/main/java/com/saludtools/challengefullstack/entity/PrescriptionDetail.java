package com.saludtools.challengefullstack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="prescriptiondetail")
public class PrescriptionDetail {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "iddetail", columnDefinition = "VARCHAR(36)")
	private String idDetail;
		
	@Column(name = "idprescription", columnDefinition = "VARCHAR(36)")
	private String idPrescription;
	
	@Column(name = "idmedicine", columnDefinition = "VARCHAR(36)")
	private String idMedicine;

	public String getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(String idDetail) {
		this.idDetail = idDetail;
	}

	public String getIdPrescription() {
		return idPrescription;
	}

	public void setIdPrescription(String idPrescription) {
		this.idPrescription = idPrescription;
	}

	public String getIdMedicine() {
		return idMedicine;
	}

	public void setIdMedicine(String idMedicine) {
		this.idMedicine = idMedicine;
	}
	
	

}
