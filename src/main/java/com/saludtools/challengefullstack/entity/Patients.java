package com.saludtools.challengefullstack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="patients")
public class Patients {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "iduser", columnDefinition = "VARCHAR(36)")
	private String idUser;
	
	@Column(name = "name", columnDefinition = "VARCHAR(100)")
	private String name;
	
	@Column(name = "lastname", columnDefinition = "VARCHAR(100)")
	private String lastName;
	
	@Column(name = "email", columnDefinition = "VARCHAR(100)")
	private String email;
	
	@Column(name = "phone", columnDefinition = "VARCHAR(20)")
	private String phone;
	
	@Column(name = "iddoctype", columnDefinition = "VARCHAR(36)")
	private String idDocType;
	
	@Column(name = "doc", columnDefinition = "VARCHAR(20)")
	private String doc;
	
	@Column(name = "gender", columnDefinition = "VARCHAR(10)")
	private String gender;
	
	@Column(name = "birthdate", columnDefinition = "DATE")
	private Date birthDate;

	

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdDocType() {
		return idDocType;
	}

	public void setIdDocType(String idDocType) {
		this.idDocType = idDocType;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	

}
