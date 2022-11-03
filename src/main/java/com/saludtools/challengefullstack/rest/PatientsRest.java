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

import com.saludtools.challengefullstack.dto.PatientsDto;
import com.saludtools.challengefullstack.service.PatientsService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/patients")
public class PatientsRest {

	@Autowired
	private PatientsService patientsService;
	
	@GetMapping(value = "/all")
	public List<PatientsDto> getAll(){
		return patientsService.findAll();
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<PatientsDto> get(@PathVariable String id){
		
		return new ResponseEntity<PatientsDto>(patientsService.findByid(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<PatientsDto> save(@RequestBody PatientsDto patientsDto){
		PatientsDto obj = patientsService.save(patientsDto);
		return new ResponseEntity<PatientsDto>(obj, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<PatientsDto> delete(@PathVariable String id){
		PatientsDto patientsDto = patientsService.findByid(id);
		if(patientsDto != null) {
			patientsService.delete(patientsDto);
		}else {
			return new ResponseEntity<PatientsDto>(patientsDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PatientsDto>(patientsDto, HttpStatus.OK);
		
	}
}
