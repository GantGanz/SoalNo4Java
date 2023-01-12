package com.example.profile.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//	Agar tidak perlu mengulang-ulang menulis entity manager
public abstract class BaseDao {
	
	@PersistenceContext
	public EntityManager em;
}
