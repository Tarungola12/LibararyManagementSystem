package com.tarun.DigitalLibarary.repository;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.tarun.DigitalLibarary.model.Address;
import com.tarun.DigitalLibarary.model.Student;

@Repository
public class StudentRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    private SimpleJdbcInsert jdbcInsert;
   
    public StudentRepository() {
    	
	}
    
    @Autowired
	 StudentRepository(DataSource dataSource){
	        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Student").usingGeneratedKeyColumns("id");
	 }
	
	public int createStundetInDatabase(Student student) {
		
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name",student.getName());
        mapSqlParameterSource.addValue("email",student.getEmail());
        mapSqlParameterSource.addValue("dob",student.getDob());
        mapSqlParameterSource.addValue("mobile",student.getMobileNo());
        mapSqlParameterSource.addValue("status", student.getStudentStatus());
        mapSqlParameterSource.addValue("createdOn", new Date());
        mapSqlParameterSource.addValue("updatedOn", new Date());
        
        Number number = jdbcInsert.executeAndReturnKey(mapSqlParameterSource);
        int studentId = number.intValue();
        Address address = student.getAddress();
        int row =  jdbcTemplate.update("INSERT INTO Address (studentId, street, city,pincode) VALUES (?,?,?,?)", studentId,address.getStreet(),address.getCity(),address.getPincode());
        System.out.println("dataBase Layer is saved data successfully");
        return row;
	}
	
	
}
