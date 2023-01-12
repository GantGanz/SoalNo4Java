package com.example.profile.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profile.dao.ProfileDao;
import com.example.profile.dto.ProfileDto;
import com.example.profile.dto.ProfilesDto;
import com.example.profile.model.Profile;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileDao profileDao;
	
//	Menggunakan dto agar sekalian menampilkan jumlah baris yang ada
	public ProfilesDto getAll() {
		ProfilesDto profilesDto = new ProfilesDto();
		List<Profile> profiles = profileDao.getAll();
		List<ProfileDto> profileDtos = new ArrayList<>();
		int size = 0;
		for(int i = 0; i < profiles.size(); i++) {
			ProfileDto profileDto = new ProfileDto();
			profileDto.setId(profiles.get(i).getId());
			profileDto.setFirstName(profiles.get(i).getFirstName());
			profileDto.setLastName(profiles.get(i).getLastName());
			profileDto.setAddress(profiles.get(i).getAddress());
			profileDto.setBirthday(profiles.get(i).getBirthday());
			profileDto.setEmail(profiles.get(i).getEmail());
			profileDto.setCity(profiles.get(i).getCity());
			profileDto.setCountry(profiles.get(i).getCountry());
			
			profileDtos.add(profileDto);
			size++;
		}
		profilesDto.setData(profileDtos);
		profilesDto.setSize(size);
		return profilesDto;
	}

	public ProfileDto getById(Long id) {
		ProfileDto profileDto = new ProfileDto();
		Profile profile = profileDao.getById(id);
		profileDto.setId(profile.getId());
		profileDto.setFirstName(profile.getFirstName());
		profileDto.setLastName(profile.getLastName());
		profileDto.setAddress(profile.getAddress());
		profileDto.setBirthday(profile.getBirthday());
		profileDto.setEmail(profile.getEmail());
		profileDto.setCity(profile.getCity());
		profileDto.setCountry(profile.getCountry());
		
		return profileDto;
	}
	
	@Transactional
	public Profile insert(Profile data) {
		return profileDao.insert(data);
	}
}
