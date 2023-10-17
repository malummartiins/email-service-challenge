package com.devmalu.emailservice.core;

//essa classe define o comportamento da aplicação

public interface EmailSenderUserCase {
    public void sendEmail(String to, String subject, String body);
}
