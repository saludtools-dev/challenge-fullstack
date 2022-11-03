package com.saludtools.challengefullstack.service;

import java.util.List;

import com.saludtools.challengefullstack.commons.GenericService;
import com.saludtools.challengefullstack.dto.PrescriptionsDto;
import com.saludtools.challengefullstack.entity.Prescriptions;

public interface PrescriptionsService extends GenericService<Prescriptions, String>{

	List<PrescriptionsDto> findAll();
	
	PrescriptionsDto findByid(String id);
	
	PrescriptionsDto save(PrescriptionsDto prescriptionsDto);
	
	void delete(PrescriptionsDto prescriptionsDto);
}