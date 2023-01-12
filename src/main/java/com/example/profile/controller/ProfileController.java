package com.example.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.profile.dto.ProfileDto;
import com.example.profile.dto.ProfilesDto;
import com.example.profile.model.Profile;
import com.example.profile.service.ProfileService;

@RestController
@RequestMapping("profiles")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@GetMapping("{id}")
	public ProfileDto getById(@PathVariable Long id) {
		return profileService.getById(id);
	}
	
	@GetMapping
	public ProfilesDto getAll() {
		return profileService.getAll();
	}
	
//	Tidak menggunakan dto untuk mempersingkat waktu
//	Seharusnya menggunakan dto untuk melakukan validasi juga, dengan anotasi @Validated disini, dan @NotNull,dll di tiap kolom dto nya
	@PostMapping
	public Profile insert(@RequestBody Profile data) {
		return profileService.insert(data);
	}
}
