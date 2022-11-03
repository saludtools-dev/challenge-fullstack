package com.saludtools.challengefullstack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.saludtools.challengefullstack.commons.impl.GenericServiceImpl;
import com.saludtools.challengefullstack.dao.PatientsDao;
import com.saludtools.challengefullstack.dto.PatientsDto;
import com.saludtools.challengefullstack.entity.Patients;
import com.saludtools.challengefullstack.service.PatientsService;
import com.saludtools.challengefullstack.utils.MHelpers;

@Service
public class PatientsServiceImpl extends GenericServiceImpl<Patients, String> implements PatientsService{

	@Autowired 
	PatientsDao patientsDao;
	
	@Override
	public CrudRepository<Patients, String> getDao() {
		return patientsDao;
	}
	
	@Override
	public List<PatientsDto> findAll() {
		
		List<PatientsDto> listaPatientsDto = new ArrayList<>();
		
		Iterable<Patients> patientsIt = this.patientsDao.findAll();
		
		for(Patients patients: patientsIt) {
			PatientsDto patientsDto = new PatientsDto();
			patientsDto = MHelpers.modelMapper().map(patients, PatientsDto.class);
			patientsDto.setAge(patientsDto.getBirthDate());
			listaPatientsDto.add(patientsDto);
		}
		
		return listaPatientsDto;
	}

	@Override
	public PatientsDto findByid(String id) {
		Optional<Patients> patients = this.patientsDao.findById(id);
		PatientsDto patientsDto = MHelpers.modelMapper().map(patients.get(), PatientsDto.class);
		
		return patientsDto;
	}

	@Override
	public PatientsDto save(PatientsDto patientsDto) {
		Patients patients = new Patients();
		patients = MHelpers.modelMapper().map(patientsDto, Patients.class);
		patients =  this.patientsDao.save(patients);
		patientsDto = MHelpers.modelMapper().map(patients, PatientsDto.class);
		
		return patientsDto;
	}

	@Override
	public void delete(PatientsDto patientsDto) {
		Patients patients = new Patients();
		patients = MHelpers.modelMapper().map(patientsDto, Patients.class);
		this.patientsDao.delete(patients);
		
	}


}