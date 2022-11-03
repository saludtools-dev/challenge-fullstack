package com.saludtools.challengefullstack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.saludtools.challengefullstack.commons.impl.GenericServiceImpl;
import com.saludtools.challengefullstack.dao.MedicinesDao;
import com.saludtools.challengefullstack.dto.MedicinesDto;
import com.saludtools.challengefullstack.entity.Medicines;
import com.saludtools.challengefullstack.service.MedicinesService;
import com.saludtools.challengefullstack.utils.MHelpers;

@Service
public class MedicinesServiceImpl extends GenericServiceImpl<Medicines, String> implements MedicinesService{

	@Autowired 
	MedicinesDao medicinesDao;
	
	@Override
	public CrudRepository<Medicines, String> getDao() {
		return medicinesDao;
	}
	
	@Override
	public List<MedicinesDto> findAll() {
		
		List<MedicinesDto> listaMedicinesDto = new ArrayList<>();
		
		Iterable<Medicines> medicinesIt = this.medicinesDao.findAll();
		
		for(Medicines medicines: medicinesIt) {
			MedicinesDto medicinesDto = new MedicinesDto();
			medicinesDto = MHelpers.modelMapper().map(medicines, MedicinesDto.class);
			listaMedicinesDto.add(medicinesDto);
		}
		
		return listaMedicinesDto;
	}

	@Override
	public MedicinesDto findByid(String id) {
		Optional<Medicines> medicines = this.medicinesDao.findById(id);
		MedicinesDto medicinesDto = MHelpers.modelMapper().map(medicines.get(), MedicinesDto.class);
		
		return medicinesDto;
	}

	@Override
	public MedicinesDto save(MedicinesDto medicinesDto) {
		Medicines medicines = new Medicines();
		medicines = MHelpers.modelMapper().map(medicinesDto, Medicines.class);
		medicines =  this.medicinesDao.save(medicines);
		medicinesDto = MHelpers.modelMapper().map(medicines, MedicinesDto.class);
		
		return medicinesDto;
	}

	@Override
	public void delete(MedicinesDto medicinesDto) {
		Medicines medicines = new Medicines();
		medicines = MHelpers.modelMapper().map(medicinesDto, Medicines.class);
		this.medicinesDao.delete(medicines);
		
	}


}