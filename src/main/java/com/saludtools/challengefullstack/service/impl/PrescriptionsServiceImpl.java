package com.saludtools.challengefullstack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.saludtools.challengefullstack.commons.impl.GenericServiceImpl;
import com.saludtools.challengefullstack.dao.PrescriptionsDao;
import com.saludtools.challengefullstack.dto.PrescriptionsDto;
import com.saludtools.challengefullstack.entity.Prescriptions;
import com.saludtools.challengefullstack.jdbc.PrescriptionsJdbc;
import com.saludtools.challengefullstack.service.PrescriptionsService;
import com.saludtools.challengefullstack.utils.MHelpers;

@Service
public class PrescriptionsServiceImpl extends GenericServiceImpl<Prescriptions, String> implements PrescriptionsService{

	@Autowired 
	PrescriptionsDao prescriptionsDao;
	
	@Autowired
    private PrescriptionsJdbc prescriptionsJdbc;
	
	@Override
	public CrudRepository<Prescriptions, String> getDao() {
		return prescriptionsDao;
	}
	
	@Override
	public List<PrescriptionsDto> findAll() {
		
		List<PrescriptionsDto> listaPrescriptionsDto = new ArrayList<>();
		
		Iterable<Prescriptions> prescriptionsIt = this.prescriptionsDao.findAll();
		
		for(Prescriptions prescriptions: prescriptionsIt) {
			PrescriptionsDto prescriptionsDto = new PrescriptionsDto();
			prescriptionsDto = MHelpers.modelMapper().map(prescriptions, PrescriptionsDto.class);
			listaPrescriptionsDto.add(prescriptionsDto);
		}
		
		return listaPrescriptionsDto;
	}

	@Override
	public PrescriptionsDto findByid(String id) {
		Optional<Prescriptions> prescriptions = this.prescriptionsDao.findById(id);
		PrescriptionsDto prescriptionsDto = MHelpers.modelMapper().map(prescriptions.get(), PrescriptionsDto.class);
		
		return prescriptionsDto;
	}

	@Override
	public PrescriptionsDto save(PrescriptionsDto prescriptionsDto) {
		
		List<Integer> cantPres = prescriptionsJdbc.getMedPorMes(prescriptionsDto.getIdUser(), prescriptionsDto.getPrescriptionDate());
		
		if ( cantPres.get(0) < 3) {
			Prescriptions prescriptions = new Prescriptions();
			prescriptions = MHelpers.modelMapper().map(prescriptionsDto, Prescriptions.class);
			prescriptions =  this.prescriptionsDao.save(prescriptions);
			prescriptionsDto = MHelpers.modelMapper().map(prescriptions, PrescriptionsDto.class);			
		}
		
		
		return prescriptionsDto;
	}

	@Override
	public void delete(PrescriptionsDto prescriptionsDto) {
		Prescriptions prescriptions = new Prescriptions();
		prescriptions = MHelpers.modelMapper().map(prescriptionsDto, Prescriptions.class);
		this.prescriptionsDao.delete(prescriptions);
		
	}


}