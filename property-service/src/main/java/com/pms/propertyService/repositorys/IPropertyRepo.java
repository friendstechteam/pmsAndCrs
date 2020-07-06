package com.pms.propertyService.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.pms.propertyService.models.Property;

public interface IPropertyRepo extends MongoRepository<Property, String>, QuerydslPredicateExecutor<Property> {

}
