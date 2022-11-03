package com.saludtools.challengefullstack.jdbc.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.saludtools.challengefullstack.jdbc.PrescriptionsJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PrescriptionsJdbcImpl implements PrescriptionsJdbc{
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${saludtools.sql.medPorMes}")
    private String medPorMes;
	
	@Override
	public List<Integer> getMedPorMes(String idUser, Date prescriptionDate) {
		
		Date fecIni;
		Date fecFin;
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(prescriptionDate);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		fecIni = calendar.getTime();
		
		calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		fecFin = calendar.getTime();
		
		String sentencia = this.medPorMes;
        SqlParameterSource params = new MapSqlParameterSource().addValue("IDUSER", idUser)
        													   .addValue("FECINI", fecIni)
        													   .addValue("FECFIN", fecFin);
        
        return this.jdbcTemplate.query(sentencia,params, new RowMapper<Integer>()
        {
            /**
             * Recorrer lista y mapear objeto
             * @throws SQLException 
             */
           @Override
           public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
        	   Integer cantidad = rs.getInt(1);
        	   return cantidad;
           }
        });
	}

	
}
