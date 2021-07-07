package com.gridu.phonebookmvcfinal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends Exception{

    public ContactNotFoundException(String contactName) {
        super(String.format("Contact not found: %s", contactName));
    }
}
