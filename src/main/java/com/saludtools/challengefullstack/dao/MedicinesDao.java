package com.saludtools.challengefullstack.dao;

import org.springframework.data.repository.CrudRepository;
import com.saludtools.challengefullstack.entity.Medicines;

public interface MedicinesDao extends CrudRepository<Medicines, String>{

}
