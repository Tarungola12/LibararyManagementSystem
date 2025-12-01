package com.tarun.DigitalLibarary.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor	
public class Author {
	private int id;
	private String name;
	private String email;
	private String mobileNo;
	List<Book> books;
	
}
