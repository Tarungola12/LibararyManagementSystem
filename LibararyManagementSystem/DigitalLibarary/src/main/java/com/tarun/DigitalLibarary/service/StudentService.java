package com.tarun.DigitalLibarary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarun.DigitalLibarary.model.Address;
import com.tarun.DigitalLibarary.model.Student;
import com.tarun.DigitalLibarary.model.StudentStatus;
import com.tarun.DigitalLibarary.repository.StudentRepository;
import com.tarun.DigitalLibarary.request.StudentCreationRequest;
import com.tarun.DigitalLibarary.response.StudentCreationResponse;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public StudentCreationResponse createStudent(StudentCreationRequest studentCreationRequest) {
		String name = studentCreationRequest.getName();
		String mobileNo = studentCreationRequest.getMobileNo();
		String email = studentCreationRequest.getEmail();
		String dob = studentCreationRequest.getDob();
		Address address = studentCreationRequest.getAddress();

		Student student = Student.builder().address(address).dob(dob).name(name).email(email).mobileNo(mobileNo)
				.build();
		student.setStudentStatus(StudentStatus.ACTIVE);
		int row = 0;
		try {
			row = studentRepository.createStundetInDatabase(student);
		} catch (Exception e) {
			System.out.println("Exception occurs in database : " + e.getMessage());
			row = 0;
		}
		StudentCreationResponse studentCreationResponse = new StudentCreationResponse();
		studentCreationResponse.setName(name);
		studentCreationResponse.setEmail(email);
		if (row == 0) {
			studentCreationResponse = new StudentCreationResponse();
			studentCreationResponse.setStatus("FAILED");
			studentCreationResponse.setMessage("Data Not Insrted");
			return studentCreationResponse;
		}else {
			studentCreationResponse.setStatus("SUCCESS");
			studentCreationResponse.setMessage("Data Inserted successfully");
			studentCreationResponse.setDescription("Discription is : yours data is inserted...");
			return studentCreationResponse;
		}
	}

}
