package com.glaucus.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.glaucus.model.Person;

@Repository
public class PersonDaoImp implements PersonDao {
	
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 @Override
		public long save(Person person) {
			sessionFactory.getCurrentSession().save(person);
		    return person.getId();
		}

	@Override
	public Person get(long id) {
		 return sessionFactory.getCurrentSession().get(Person.class, id);
	}

	@Override
	public void update(long id, Person person) {
	  Session session = sessionFactory.getCurrentSession();
	  Person personUpdate = session.byId(Person.class).load(id);
	  personUpdate.setFullName(person.getFullName());
	  personUpdate.setEmail(person.getEmail());
	  personUpdate.setNumber(person.getNumber());
	  personUpdate.setCreationDate(person.getCreationDate());
	  personUpdate.setModifiedDate(person.getModifiedDate());
      session.flush();
		
	}

	@Override
	public void delete(long id) {
		Person person = sessionFactory.getCurrentSession().byId(Person.class).load(id);
	    sessionFactory.getCurrentSession().delete(person);
	}



	



}
