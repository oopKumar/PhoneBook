package com.oop.phonebook.services;

import java.util.List;
import com.oop.phonebook.entities.Contact;
public interface ContactServices {
	public Contact saveContact(Contact contact);
	public Contact updateContact(Contact contact,String ContactId);
    
	public List<Contact> getAllContact();
	public Contact getContactById(String contactId);
	public String deleteById(String contactId);
}
