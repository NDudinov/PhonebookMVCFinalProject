package com.gridu.phonebookmvc.controller;

import com.gridu.phonebookmvc.dto.Contact;
import com.gridu.phonebookmvc.exception.ContactNotFoundException;
import com.gridu.phonebookmvc.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactRestController {

    @Autowired
    private ContactService contactService;

    @PostMapping(path = "/contacts/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody
    Contact addContact(@RequestParam String name,
                       @RequestParam String phone) {
        return contactService.save(name, phone);
    }

    @GetMapping(path = "/contacts")
    @ResponseStatus(code = HttpStatus.FOUND)
    public @ResponseBody List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @GetMapping(path = "/contacts/{name}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public @ResponseBody
    Contact getContactByName(@RequestParam(name = "name") String contactName) throws ContactNotFoundException {
        return contactService.findByName(contactName);
    }

    @PutMapping(path = "/contacts/{name}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public @ResponseBody
    Contact updateContactByName(@RequestParam(name = "name")String contactName,
                                @RequestParam String addPhone) throws ContactNotFoundException {
        return contactService.updateContact(contactName, addPhone);
    }

    @DeleteMapping(path = "/contacts/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody List<Contact> deleteContact(@RequestParam(name = "name") String contactName) throws ContactNotFoundException {
        contactService.deleteContact(contactName);
        return contactService.findAll();
    }
}
