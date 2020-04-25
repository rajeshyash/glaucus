package com.glaucus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glaucus.dao.PersonDao;
import com.glaucus.model.Person;

@Service
@Transactional
public class BookServiceImp implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Transactional
	@Override
	public long save(Person person) {
		 return personDao.save(person);
	}

	@Override
	public Person get(long id) {
		return personDao.get(id);
	}
	
	@Transactional
	@Override
	public void update(long id, Person person) {
		personDao.update(id, person);
	}

	@Transactional
	@Override
	public void delete(long id) {
		personDao.delete(id);
		
	}

}
