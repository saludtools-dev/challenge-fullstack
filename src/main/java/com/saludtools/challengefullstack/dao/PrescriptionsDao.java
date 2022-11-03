package com.saludtools.challengefullstack.dao;

import org.springframework.data.repository.CrudRepository;
import com.saludtools.challengefullstack.entity.Prescriptions;

public interface PrescriptionsDao extends CrudRepository<Prescriptions, String>{

}
