package com.pms.profileService.services;

import java.util.List;

import com.pms.profileService.models.Profile;


public interface IProfileService {
	public Profile saveProfile(Profile profile);
	public Profile updateProfile(Profile profile);
	public List<Profile> getAllProfiles();
	public List<Profile> searchProfiles(Profile profile);
	public Profile getProfileById(String id);
	public boolean deleteProfileById(String id);
}
