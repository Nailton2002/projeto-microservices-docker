package br.com.microservice.cartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal renda;
    private BigDecimal limiteBasico;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;

    public Cartao(String nome, BigDecimal renda, BigDecimal limiteBasico, BandeiraCartao bandeiraCartao) {
        this.nome = nome;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
        this.bandeiraCartao = bandeiraCartao;
    }
}

