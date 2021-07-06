package com.gridu.phonebookmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends Exception{

    public ContactNotFoundException(Object contact) {
        super(contact != null ? String.format("Resource not found: %s", contact.toString()) : null);
    }
}
