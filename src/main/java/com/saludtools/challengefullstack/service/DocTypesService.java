package com.saludtools.challengefullstack.service;

import java.util.List;

import com.saludtools.challengefullstack.commons.GenericService;
import com.saludtools.challengefullstack.dto.DocTypesDto;
import com.saludtools.challengefullstack.entity.DocTypes;

public interface DocTypesService extends GenericService<DocTypes, String>{

	List<DocTypesDto> findAll();
	
	DocTypesDto findByid(String id);
	
	DocTypesDto save(DocTypesDto docTypesDto);
	
	void delete(DocTypesDto docTypesDto);
}
