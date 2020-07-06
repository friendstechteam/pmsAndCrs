package com.pms.propertyService.services;

import java.util.List;

import com.pms.propertyService.models.Property;

public interface IPropertyService {
	public Property saveProperty(Property property);
	public Property updateProperty(Property property);
	public List<Property> getAllProperties();
	public List<Property> searchProperties(Property property);
	public Property getPropertyById(String id);
	public boolean deletePropertyById(String id);
	
}
