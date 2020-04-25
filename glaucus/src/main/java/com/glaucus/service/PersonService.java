package com.glaucus.service;

import com.glaucus.model.Person;

public interface PersonService {

	public long save(Person person);

	public Person get(long id);

	public void update(long id, Person person);

	public void delete(long id);

}
