package com.pms.propertyService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.propertyService.models.Property;
import com.pms.propertyService.repositorys.IPropertyRepo;
import com.querydsl.core.BooleanBuilder;

@Service
public class PropertyService implements IPropertyService {

	@Autowired
	private IPropertyRepo propertyRepo;
	
	@Override
	public Property saveProperty(Property property) {
		return propertyRepo.insert(property);
	}

	@Override
	public Property updateProperty(Property property) {
		return propertyRepo.save(property);
	}

	@Override
	public List<Property> getAllProperties() {
		return propertyRepo.findAll();
	}

	@Override
	public List<Property> searchProperties(Property property) {
		List<Property> list = new ArrayList<Property>();
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		
		propertyRepo.findAll(booleanBuilder.getValue()).iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Property getPropertyById(String id) {
		return propertyRepo.findById(id).get();
	}

	@Override
	public boolean deletePropertyById(String id) {
		try {
			propertyRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
