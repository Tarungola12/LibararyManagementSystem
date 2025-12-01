package com.tarun.DigitalLibarary.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreationResponse {
	
	private String id;
	private String name;
	private String email;
	private String status;
	private String description;
	private String message;

}
