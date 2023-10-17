package com.devmalu.emailservice.controllers;

import com.devmalu.emailservice.application.EmailSenderClass;
import com.devmalu.emailservice.core.EmailRequest;
import com.devmalu.emailservice.core.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSendersController {
    private final EmailSenderClass emailSenderClass;

    @Autowired
    public EmailSendersController (EmailSenderClass emailSenderClass){
        this.emailSenderClass = emailSenderClass;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            this.emailSenderClass.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email send succesfully");
        }catch (EmailServiceException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
