package br.com.microservice.avaliadorcredito.application.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException{

    public ErroSolicitacaoCartaoException(String message) {
        super(message);
    }
}
