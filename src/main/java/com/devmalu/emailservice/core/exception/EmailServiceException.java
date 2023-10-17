package com.devmalu.emailservice.core.exception;

public class EmailServiceException extends RuntimeException {

    public EmailServiceException (String mensagem){
        super(mensagem);
    }

    public EmailServiceException(String messagem, Throwable causa){
        super(messagem, causa);
    }

}
