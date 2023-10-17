package com.devmalu.emailservice.application;

import com.devmalu.emailservice.adapters.EmailSenderGateway;
import com.devmalu.emailservice.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//essa classe conecta o core da minha aplicação com o grande universo lá fora *-*

@Service
public class EmailSenderClass implements EmailSenderUserCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderClass(EmailSenderGateway emailGateway){
        this.emailSenderGateway = emailGateway;

    }
    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to,subject,body);

    }
}
