package com.gridu.phonebookmvcfinal.repository;

import com.gridu.phonebookmvcfinal.dto.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Optional<Contact> findByContactName(String contactName);

    List<Contact> findAll();
}
