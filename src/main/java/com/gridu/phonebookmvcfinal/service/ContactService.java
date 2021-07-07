package com.gridu.phonebookmvcfinal.service;

import com.gridu.phonebookmvcfinal.dto.Contact;
import com.gridu.phonebookmvcfinal.exception.ContactNotFoundException;

import java.util.List;

public interface ContactService {

    public Contact save(Contact contact);

    public List<Contact> findAll();

    public Contact findByName(String contactName) throws ContactNotFoundException;

    public Contact updateContact(String contactName, String newPhone) throws ContactNotFoundException;

    public void deleteContact(String contactName) throws ContactNotFoundException;
}
