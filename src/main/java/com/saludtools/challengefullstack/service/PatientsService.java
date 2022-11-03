package com.saludtools.challengefullstack.service;

import java.util.List;

import com.saludtools.challengefullstack.commons.GenericService;
import com.saludtools.challengefullstack.dto.PatientsDto;
import com.saludtools.challengefullstack.entity.Patients;

public interface PatientsService extends GenericService<Patients, String>{

	List<PatientsDto> findAll();
	
	PatientsDto findByid(String id);
	
	PatientsDto save(PatientsDto patientsDto);
	
	void delete(PatientsDto patientsDto);
}
