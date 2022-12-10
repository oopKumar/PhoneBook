package com.oop.phonebook.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.phonebook.entities.Contact;
import com.oop.phonebook.repositories.ContactRepository;
import com.oop.phonebook.services.ContactServices;

@Service
public class ContactServicesImpl  implements ContactServices{
	
	@Autowired 
	ContactRepository contactRepository;
	
//Save Method
	@Override
	public Contact saveContact(Contact contact) {
		String contactId = UUID .randomUUID().toString();
		contact.setContactId(contactId);
		return contactRepository.save(contact);
	}

//GetAll Method	
	@Override
	public List<Contact> getAllContact() {
		
		return contactRepository.findAll();
	}

//GetById Method 
	@Override
	public Contact getContactById(String contactId) {
		
		return contactRepository.findById(contactId).orElseThrow(()->new com.oop.phonebook.exceptions.ResourceNotFoundException("User with given id is not found on server "+contactId));
	}

//DeleteById Method	
	@Override
	public String deleteById(String contactId) {
		
	contactRepository.deleteById(contactId);
	
	return "Contact Deleted Successfully";

	}
	
//UpdaetById` Method
	
	public Contact updateContact(Contact contact,String contactId)
    {
 
        Contact contactDB = contactRepository.findById(contactId).get();
 
        if (Objects.nonNull(contact.getName())&& !"".equalsIgnoreCase(contact.getName())) {
            contactDB.setName(contact.getName());
        }
 
        if (Objects.nonNull(contact.getEmail())&& !"".equalsIgnoreCase(contact.getEmail())) {
            contactDB.setEmail(contact.getEmail());
        }
 
        if (Objects.nonNull(contact.getPhno())){
            contactDB.setPhno(contact.getPhno());
        }
 
        return contactRepository.save(contactDB);
    }
	

}
