package br.com.microservice.clientes.application;

import br.com.microservice.clientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toMode(){
        return new Cliente(cpf, nome, idade);
    }
}
