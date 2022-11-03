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

import com.saludtools.challengefullstack.dto.PrescriptionsDto;
import com.saludtools.challengefullstack.jdbc.PrescriptionsJdbc;
import com.saludtools.challengefullstack.service.PrescriptionsService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/prescriptions")
public class PrescriptionsRest {
	
	@Autowired
	private PrescriptionsService prescriptionsService;
	
	@GetMapping(value = "/all")
	public List<PrescriptionsDto> getAll(){
		return prescriptionsService.findAll();
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<PrescriptionsDto> get(@PathVariable String id){
		
		return new ResponseEntity<PrescriptionsDto>(prescriptionsService.findByid(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<PrescriptionsDto> save(@RequestBody PrescriptionsDto prescriptionsDto){
		PrescriptionsDto obj = prescriptionsService.save(prescriptionsDto);
		return new ResponseEntity<PrescriptionsDto>(obj, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<PrescriptionsDto> delete(@PathVariable String id){
		PrescriptionsDto prescriptionsDto = prescriptionsService.findByid(id);
		if(prescriptionsDto != null) {
			prescriptionsService.delete(prescriptionsDto);
		}else {
			return new ResponseEntity<PrescriptionsDto>(prescriptionsDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PrescriptionsDto>(prescriptionsDto, HttpStatus.OK);
		
	}
	

}
