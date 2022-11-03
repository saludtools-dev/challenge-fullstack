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

import com.saludtools.challengefullstack.dto.MedicinesDto;
import com.saludtools.challengefullstack.service.MedicinesService;

@RestController
@CrossOrigin({"*"})
@RequestMapping(value = "/medicines")
public class MedicinesRest {
	
	@Autowired
	private MedicinesService medicinesService;
	
	@GetMapping(value = "/all")
	public List<MedicinesDto> getAll(){
		return medicinesService.findAll();
		
	}
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<MedicinesDto> get(@PathVariable String id){
		
		return new ResponseEntity<MedicinesDto>(medicinesService.findByid(id), HttpStatus.OK);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<MedicinesDto> save(@RequestBody MedicinesDto medicinesDto){
		MedicinesDto obj = medicinesService.save(medicinesDto);
		return new ResponseEntity<MedicinesDto>(obj, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<MedicinesDto> delete(@PathVariable String id){
		MedicinesDto medicinesDto = medicinesService.findByid(id);
		if(medicinesDto != null) {
			medicinesService.delete(medicinesDto);
		}else {
			return new ResponseEntity<MedicinesDto>(medicinesDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<MedicinesDto>(medicinesDto, HttpStatus.OK);
		
	}

}
