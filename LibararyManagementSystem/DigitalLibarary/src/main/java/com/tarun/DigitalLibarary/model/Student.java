package com.tarun.DigitalLibarary.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private int id;
	private String name;
	private String email;
	private Address address;
	private String dob;
	private String mobileNo;
	List<Book> issuedBooks;
	private StudentStatus studentStatus;
	Date createdOn;
	Date updatedOn;
	
}
