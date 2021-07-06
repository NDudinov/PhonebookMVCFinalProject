package com.gridu.phonebookmvc.service;

import com.gridu.phonebookmvc.dto.Contact;
import com.gridu.phonebookmvc.exception.ContactNotFoundException;

import java.util.List;

public interface ContactService {

    public Contact save(String name, String phone);

    public List<Contact> findAll();

    public Contact findByName(String contactName) throws ContactNotFoundException;

    public Contact updateContact(String contactName, String addPhone) throws ContactNotFoundException;

    public void deleteContact(String contactName) throws ContactNotFoundException;
}
