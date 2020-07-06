package com.pms.profileService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Profile {
	@Id
	private String id;
	private String firstName;
	private String lastName;
}
