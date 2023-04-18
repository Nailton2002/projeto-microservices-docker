package br.com.microservice.cartoes.application.representation;

import br.com.microservice.cartoes.domain.BandeiraCartao;
import br.com.microservice.cartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BigDecimal renda;
    private BigDecimal limite;
    private BandeiraCartao bandeira;

    public Cartao toModel(){
        return new Cartao(nome, renda, limite, bandeira);
    }
}
