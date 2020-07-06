package com.pms.profileService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.profileService.models.Profile;
import com.pms.profileService.repositorys.IProfileRepo;
import com.querydsl.core.BooleanBuilder;

@Service
public class ProfileService implements IProfileService {

	@Autowired
	private IProfileRepo profileRepo;

	@Override
	public Profile saveProfile(Profile profile) {
		return profileRepo.insert(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return profileRepo.save(profile);
	}

	@Override
	public List<Profile> getAllProfiles() {
		return profileRepo.findAll();
	}

	@Override
	public List<Profile> searchProfiles(Profile profile) {
		List<Profile> list = new ArrayList<Profile>();
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if(profile.getFirstName() != null) {
			//booleanBuilder.and(QProfile);
		}
		profileRepo.findAll(booleanBuilder.getValue()).iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Profile getProfileById(String id) {
		return profileRepo.findById(id).get();
	}

	@Override
	public boolean deleteProfileById(String id) {
		try {
			profileRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
