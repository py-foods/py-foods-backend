package com.py.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.py.util.JpaUtils;

@Transactional
public class RepositoryHelper {

	@PersistenceContext
	private EntityManager em;

	public void intialize(Object entity, int depth) {
		JpaUtils.initialize(em, entity, depth);
	}
}
