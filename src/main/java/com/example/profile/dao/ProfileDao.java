package com.example.profile.dao;

import java.util.List;

import com.example.profile.model.Profile;

public class ProfileDao extends BaseDao{
	
	public List<Profile> getAll() {
		String sql = "SELECT * FROM PROFILE";
		return em.createNativeQuery(sql, Profile.class).getResultList();
	}
	
	public Profile getById(Long id) {
		return em.find(Profile.class, id);
	}
	
	public Profile insert(Profile data) {
		em.persist(data);
		return data;
	}
	
//	Tidak jadi menambahkan update karena tidak ada direquirement
	public Profile update(Profile data) {
		return em.merge(data);
	}
}
