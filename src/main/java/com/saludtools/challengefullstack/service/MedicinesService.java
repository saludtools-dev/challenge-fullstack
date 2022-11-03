package com.saludtools.challengefullstack.service;

import java.util.List;

import com.saludtools.challengefullstack.commons.GenericService;
import com.saludtools.challengefullstack.dto.MedicinesDto;
import com.saludtools.challengefullstack.entity.Medicines;

public interface MedicinesService extends GenericService<Medicines, String>{

	List<MedicinesDto> findAll();
	
	MedicinesDto findByid(String id);
	
	MedicinesDto save(MedicinesDto medicinesDto);
	
	void delete(MedicinesDto medicinesDto);
}
