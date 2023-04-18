package br.com.microservice.avaliadorcredito.application.exceptions;

public class DadosClienteNotFoundException extends Exception{
    public DadosClienteNotFoundException() {
        super("Dados do cliente não encontrado para cpf informado!");
    }
}
