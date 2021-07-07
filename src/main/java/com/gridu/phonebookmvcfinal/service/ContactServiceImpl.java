package com.gridu.phonebookmvcfinal.service;

import com.gridu.phonebookmvcfinal.controller.ContactRestController;
import com.gridu.phonebookmvcfinal.dto.Contact;
import com.gridu.phonebookmvcfinal.exception.ContactNotFoundException;
import com.gridu.phonebookmvcfinal.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ContactRestController.class);

    @Override
    public Contact save(Contact contact) {
        LOG.info("SAVE NEW CONTACT POST");
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        LOG.info("FIND ALL CONTACTS GET");
        return contactRepository.findAll();
    }

    @Override
    public Contact findByName(String contactName) throws ContactNotFoundException {
        LOG.info("FIND ONE CONTACT BY NAME "+ contactName);
        return contactRepository.findByContactName(contactName).orElseThrow(() -> new ContactNotFoundException(contactName));
    }

    @Override
    public Contact updateContact(String contactName, String newPhone) throws ContactNotFoundException {
        LOG.info("UPDATE A CONTACT PUT " + contactName);
        Contact contact = findByName(contactName);
        contact.setPhone(String.format("%s | %s", contact.getPhone(), newPhone));
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public void deleteContact(String contactName) throws ContactNotFoundException {
        LOG.info("DELETE A CONTACT " + contactName);
        Contact contact = findByName(contactName);
        contactRepository.delete(contact);
    }
}
