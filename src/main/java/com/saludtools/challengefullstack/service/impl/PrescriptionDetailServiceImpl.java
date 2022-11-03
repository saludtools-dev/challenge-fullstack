package com.saludtools.challengefullstack.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.saludtools.challengefullstack.commons.impl.GenericServiceImpl;
import com.saludtools.challengefullstack.dao.PrescriptionDetailDao;
import com.saludtools.challengefullstack.dto.PrescriptionDetailDto;
import com.saludtools.challengefullstack.entity.PrescriptionDetail;
import com.saludtools.challengefullstack.service.PrescriptionDetailService;
import com.saludtools.challengefullstack.utils.MHelpers;

@Service
public class PrescriptionDetailServiceImpl extends GenericServiceImpl<PrescriptionDetail, String> implements PrescriptionDetailService{

	@Autowired 
	PrescriptionDetailDao prescriptionDetailDao;
	
	@Override
	public CrudRepository<PrescriptionDetail, String> getDao() {
		return prescriptionDetailDao;
	}
	
	@Override
	public List<PrescriptionDetailDto> findAll() {
		
		List<PrescriptionDetailDto> listaPrescriptionDetailDto = new ArrayList<>();
		
		Iterable<PrescriptionDetail> prescriptionDetailIt = this.prescriptionDetailDao.findAll();
		
		for(PrescriptionDetail prescriptionDetail: prescriptionDetailIt) {
			PrescriptionDetailDto prescriptionDetailDto = new PrescriptionDetailDto();
			prescriptionDetailDto = MHelpers.modelMapper().map(prescriptionDetail, PrescriptionDetailDto.class);
			listaPrescriptionDetailDto.add(prescriptionDetailDto);
		}
		
		return listaPrescriptionDetailDto;
	}

	@Override
	public PrescriptionDetailDto findByid(String id) {
		Optional<PrescriptionDetail> prescriptionDetail = this.prescriptionDetailDao.findById(id);
		PrescriptionDetailDto prescriptionDetailDto = MHelpers.modelMapper().map(prescriptionDetail.get(), PrescriptionDetailDto.class);
		
		return prescriptionDetailDto;
	}

	@Override
	public PrescriptionDetailDto save(PrescriptionDetailDto prescriptionDetailDto) {
		
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail = MHelpers.modelMapper().map(prescriptionDetailDto, PrescriptionDetail.class);
		prescriptionDetail =  this.prescriptionDetailDao.save(prescriptionDetail);
		prescriptionDetailDto = MHelpers.modelMapper().map(prescriptionDetail, PrescriptionDetailDto.class);
		
		return prescriptionDetailDto;
	}

	@Override
	public void delete(PrescriptionDetailDto prescriptionDetailDto) {
		PrescriptionDetail prescriptionDetail = new PrescriptionDetail();
		prescriptionDetail = MHelpers.modelMapper().map(prescriptionDetailDto, PrescriptionDetail.class);
		this.prescriptionDetailDao.delete(prescriptionDetail);
		
	}

}
