package com.saludtools.challengefullstack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="medicines")
public class Medicines {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idmedicine", columnDefinition = "VARCHAR(36)")
	private String idMedicine;
	
	@Column(name = "namemed", columnDefinition = "VARCHAR(100)")
	private String nameMed;
	
	@Column(name = "minage", columnDefinition = "INTEGER")
	private Integer minAge;
	
	@Column(name = "maxage", columnDefinition = "INTEGER")
	private Integer maxAge;
	
	@Column(name = "gender", columnDefinition = "VARCHAR(10)")
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
