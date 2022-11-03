package com.saludtools.challengefullstack.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludtools.challengefullstack.dto.PrescriptionDetailDto;
import com.saludtools.challengefullstack.service.PrescriptionDetailService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/detail")
public class PrescriptionDetailRest {
	
	@Autowired
	private PrescriptionDetailService prescriptionDetailService;
	
	@GetMapping(value = "/all")
	public List<PrescriptionDetailDto> getAll(){
		return prescriptionDetailService.findAll();
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<PrescriptionDetailDto> get(@PathVariable String id){
		
		return new ResponseEntity<PrescriptionDetailDto>(prescriptionDetailService.findByid(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<PrescriptionDetailDto> save(@RequestBody PrescriptionDetailDto prescriptionDetailDto){
		PrescriptionDetailDto obj = prescriptionDetailService.save(prescriptionDetailDto);
		return new ResponseEntity<PrescriptionDetailDto>(obj, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<PrescriptionDetailDto> delete(@PathVariable String id){
		PrescriptionDetailDto prescriptionDetailDto = prescriptionDetailService.findByid(id);
		if(prescriptionDetailDto != null) {
			prescriptionDetailService.delete(prescriptionDetailDto);
		}else {
			return new ResponseEntity<PrescriptionDetailDto>(prescriptionDetailDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PrescriptionDetailDto>(prescriptionDetailDto, HttpStatus.OK);
		
	}

}
