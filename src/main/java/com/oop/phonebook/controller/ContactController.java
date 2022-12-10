package com.oop.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oop.phonebook.entities.Contact;
import com.oop.phonebook.repositories.ContactRepository;
import com.oop.phonebook.services.ContactServices;

@RestController

public class ContactController {
	@Autowired
	ContactServices contactService;
	
	// Save Method
	
	@PostMapping("/contacts")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		Contact contact1 = contactService.saveContact(contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(contact1);
		
	}
	
	//Get All Method
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContact() {
		List<Contact> contactAll = contactService.getAllContact();
		return ResponseEntity.ok(contactAll);
	}
	
	// Get Particuler Contact
	
	@GetMapping("/contacts/{contactId}")
	public ResponseEntity<Contact> getContactById(@PathVariable("contactId") String contactId) {
		Contact contact = contactService.getContactById(contactId);
		return ResponseEntity.ok(contact);
	}
	
	// Update Method
	@PutMapping("/contacts/{contactId}")
	public ResponseEntity<Contact> updateContact(@RequestBody Contact contact,@PathVariable("contactId") String contactId) {
		Contact updateContact = contactService.updateContact(contact, contactId);
		return ResponseEntity.ok(updateContact);
	}
	
	
	//Delete Method
	
	@DeleteMapping("/contacts/{contactId}")
	public String deleteContactById(@PathVariable("contactId") String contactId) {
		String msg = contactService.deleteById(contactId);
		return msg;
	}
	
	

}