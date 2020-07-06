package com.pms.propertyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.propertyService.models.Property;
import com.pms.propertyService.services.IPropertyService;


@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private IPropertyService propertyService;
	
	@GetMapping("/{id}")
	private Property getPropertyById(@PathVariable("id") String id){
		return propertyService.getPropertyById(id);
	}

	@GetMapping
	private List<Property> getAllProperties(){
		return propertyService.getAllProperties();
	}

	@GetMapping("/search")
	private List<Property> searchProperties(@RequestParam(name="search") Property property){
		return propertyService.getAllProperties();
	}

	@DeleteMapping("/{id}")
	private boolean deleteProperty(@PathVariable("id") String id){
		return propertyService.deletePropertyById(id);
	}
	
	@PutMapping(path = "/save", consumes = "application/json", produces = "application/json")
	private Property updateProperty(@RequestBody Property property){
		return propertyService.updateProperty(property);
	}
	
	@PostMapping(path = "/insert", consumes = "application/json", produces = "application/json")
	private Property saveProperty(@RequestBody Property property){
		return propertyService.saveProperty(property);
	}
}
