package com.exitroom.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAConector {

	private EntityManager em;

	public JPAConector() {
		var entityManagerFactory = Persistence.createEntityManagerFactory("mariadb");
		em = entityManagerFactory.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}

}
