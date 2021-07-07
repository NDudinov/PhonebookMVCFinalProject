package com.gridu.phonebookmvcfinal.controller;

import com.gridu.phonebookmvcfinal.dto.Contact;
import com.gridu.phonebookmvcfinal.exception.ContactNotFoundException;
import com.gridu.phonebookmvcfinal.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @PostMapping(path = "/contacts/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping(path = "/contacts")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping(path = "/contacts/{contactName}")
    @ResponseStatus(code = HttpStatus.FOUND)
    @ResponseBody
    public Contact getContactByName(@PathVariable("contactName") String contactName) {
        try {
            return contactService.findByName(contactName);
        } catch (ContactNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Contact %s was not fount", contactName));
        }
    }

    @PutMapping(path = "/contacts/{contactName}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @ResponseBody
    public Contact updateContactByName(@PathVariable("contactName") String contactName,
                                       @RequestParam(name = "newPhone") String newPhone) {
        try {
            return contactService.updateContact(contactName, newPhone);
        } catch (ContactNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Contact %s was not fount", contactName));
        }
    }

    @DeleteMapping(path = "/contacts/{contactName}")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public ResponseEntity deleteContact(@PathVariable("contactName") String contactName) {
        try {
            contactService.deleteContact(contactName);
        } catch (ContactNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("Contact %s was not fount", contactName));
        }
        return ResponseEntity.ok().build();
    }
}
