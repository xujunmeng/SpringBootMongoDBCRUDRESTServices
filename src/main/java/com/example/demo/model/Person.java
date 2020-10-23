package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "t_temp_person")
public class Person {
	@Id
	String id;
	String firstName;
	String lastName;
	int    age;
	
	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName  = lastName;
		this.age       = age;
		
	}
}
