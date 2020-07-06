package com.pms.profileService.controller;

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

import com.pms.profileService.models.Profile;
import com.pms.profileService.services.IProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private IProfileService profileService;
	
	@GetMapping("/{id}")
	private Profile getProfileById(@PathVariable("id") String id){
		return profileService.getProfileById(id);
	}

	@GetMapping
	private List<Profile> getAllProfiles(){
		return profileService.getAllProfiles();
	}

	@GetMapping("/search")
	private List<Profile> searchProfiles(@RequestParam(name="search") Profile profile){
		return profileService.getAllProfiles();
	}

	@DeleteMapping("/{id}")
	private boolean deleteProfile(@PathVariable("id") String id){
		return profileService.deleteProfileById(id);
	}
	
	@PutMapping(path = "/save", consumes = "application/json", produces = "application/json")
	private Profile updateProfile(@RequestBody Profile profile){
		return profileService.updateProfile(profile);
	}
	
	@PostMapping(path = "/insert", consumes = "application/json", produces = "application/json")
	private Profile saveProfile(@RequestBody Profile profile){
		return profileService.saveProfile(profile);
	}
}
