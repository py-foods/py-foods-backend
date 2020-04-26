package com.py.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class RepositoryHelper {

	@PersistenceContext
	private EntityManager em;
}
