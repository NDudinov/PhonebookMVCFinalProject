package com.gridu.phonebookmvc.service;

import com.gridu.phonebookmvc.controller.ContactRestController;
import com.gridu.phonebookmvc.dto.Contact;
import com.gridu.phonebookmvc.exception.ContactNotFoundException;
import com.gridu.phonebookmvc.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ContactRestController.class);

    @Override
    public Contact save(String name, String phone) {
        LOG.info("SAVE NEW CONTACT POST");
        Contact newContact = new Contact();
        newContact.setName(name);
        newContact.setPhone(phone);
        contactRepository.save(newContact);
        return newContact;
    }

    @Override
    public List<Contact> findAll() {
        LOG.info("FIND ALL CONTACTS GET");
        Iterable<Contact> contactsIterator = contactRepository.findAll();
        List<Contact> contactList = null;
        contactsIterator.forEach(contact -> contactList.add(contact));
        return contactList;
    }

    @Override
    public Contact findByName(String contactName) throws ContactNotFoundException {
        LOG.info("FIND ONE CONTACT BY NAME "+ contactName);
        throwExceptionIfContactNotFound(contactName);
        return contactRepository.findByName(contactName);

    }

    @Override
    public Contact updateContact(String contactName, String addPhone) throws ContactNotFoundException {
        LOG.info("UPDATE A CONTACT PUT "+ contactName);
        throwExceptionIfContactNotFound(contactName);
        Contact contact = contactRepository.findByName(contactName);
        contact.setPhone(String.format("%s|%s", contact.getPhone(),addPhone));
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public void deleteContact(String contactName) throws ContactNotFoundException {
        LOG.info("DELETE A CONTACT DELETE "+ contactName);
        throwExceptionIfContactNotFound(contactName);
        Contact contact = contactRepository.findByName(contactName);
        contactRepository.delete(contact);
        contactRepository.saveAll(contactRepository.findAll());
    }



    private void throwExceptionIfContactNotFound(String contactName) throws ContactNotFoundException{
        if (contactRepository.findByName(contactName).equals(null)) {
            throw new ContactNotFoundException(contactName);
        }
    }
}
