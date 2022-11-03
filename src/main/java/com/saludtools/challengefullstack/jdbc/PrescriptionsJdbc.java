package com.saludtools.challengefullstack.jdbc;

import java.util.Date;
import java.util.List;

public interface PrescriptionsJdbc {

	public List<Integer> getMedPorMes(String idUser, Date prescriptionDate);
	
	
}
