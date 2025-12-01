package com.tarun.DigitalLibarary.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.DigitalLibarary.request.StudentCreationRequest;
import com.tarun.DigitalLibarary.response.StudentCreationResponse;
import com.tarun.DigitalLibarary.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentContoller {

	@Autowired
	StudentService studentService;

	@PostMapping("/create/student")
	public ResponseEntity<StudentCreationResponse> createStudent(
			@Valid @RequestBody StudentCreationRequest studentCreationRequest) {
		if (Objects.isNull(studentCreationRequest)) {
			System.out.println("Object can't be null");
			return null;
		}
		StudentCreationResponse studentCreationResponse = studentService.createStudent(studentCreationRequest);
		return new ResponseEntity<>(studentCreationResponse, HttpStatus.OK);
	}
}
