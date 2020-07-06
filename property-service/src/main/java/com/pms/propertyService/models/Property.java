package com.pms.propertyService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Property {

	@Id
	private String id;
	private String propertyName;
	
}
