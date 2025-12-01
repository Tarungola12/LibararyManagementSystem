package com.tarun.DigitalLibarary.request;

import com.tarun.DigitalLibarary.model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreationRequest {

		@NotNull
		String name;
		@NotNull
		String email;
		@NotNull
		String mobileNo;
		@NotNull
		Address address;
		@NotNull
		String dob;
		

}
