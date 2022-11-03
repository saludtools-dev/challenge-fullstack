package com.saludtools.challengefullstack.service;

import java.util.List;

import com.saludtools.challengefullstack.commons.GenericService;
import com.saludtools.challengefullstack.dto.PrescriptionDetailDto;
import com.saludtools.challengefullstack.entity.PrescriptionDetail;

public interface PrescriptionDetailService extends GenericService<PrescriptionDetail, String>{

	List<PrescriptionDetailDto> findAll();
	
	PrescriptionDetailDto findByid(String id);
	
	PrescriptionDetailDto save(PrescriptionDetailDto prescriptionDetailDto);
	
	void delete(PrescriptionDetailDto prescriptionDetailDto);

}
