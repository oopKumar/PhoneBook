package com.oop.phonebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop.phonebook.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,String> {

}
