package com.gridu.phonebookmvc.repository;

import com.gridu.phonebookmvc.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Contact findByName(String name);

    List<Contact> findAll();
}
