package com.glaucus.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.model.Person;
import com.glaucus.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	private PersonService personService;

	/*---Add new person---*/
	@PostMapping("/person")
	public ResponseEntity<?> save(@RequestBody Person person) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		person.setModifiedDate(formatter.format(date));
		if(StringUtils.isEmpty(person.getFullName())) {
			return ResponseEntity.badRequest().body("full name required");
		}else if (StringUtils.isEmpty(person.getEmail())) {
			return ResponseEntity.badRequest().body("email required");
		}else if (StringUtils.isEmpty(person.getNumber())) {
			return ResponseEntity.badRequest().body("number required");
		}
		long id = personService.save(person);
		return ResponseEntity.ok().body("New Person has been saved with ID:" + id);
	}
	
	 /*---Get a person by id---*/
	   @GetMapping("/person/{id}")
	   public ResponseEntity<Person> get(@PathVariable("id") long id) {
	      Person person = personService.get(id);
	      return ResponseEntity.ok().body(person);
	   }
	   
	   /*---Update a person by id---*/
	   @PutMapping("/person/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Person person) {
		   personService.update(id, person);
	      return ResponseEntity.ok().body("Person has been updated successfully.");
	   }
	   
	   /*---Delete a person by id---*/
	   @DeleteMapping("/person/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
		   personService.delete(id);
	      return ResponseEntity.ok().body("Person has been deleted successfully.");
	   }

}
