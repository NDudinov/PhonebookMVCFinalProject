package com.gridu.phonebookmvc.repository;

import com.gridu.phonebookmvc.dto.Contact;
import com.gridu.phonebookmvc.exception.ContactNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByContactName(String contactName);

    List<Contact> findAll();
}
