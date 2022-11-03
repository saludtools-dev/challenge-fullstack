package com.saludtools.challengefullstack.dao;

import org.springframework.data.repository.CrudRepository;
import com.saludtools.challengefullstack.entity.Patients;

public interface PatientsDao extends CrudRepository<Patients, String>{

}
