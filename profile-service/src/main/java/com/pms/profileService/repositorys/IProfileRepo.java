package com.pms.profileService.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.pms.profileService.models.Profile;

public interface IProfileRepo extends MongoRepository<Profile, String>, QuerydslPredicateExecutor<Profile> {

}
