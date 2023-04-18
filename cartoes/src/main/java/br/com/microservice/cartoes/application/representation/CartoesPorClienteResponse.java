package br.com.microservice.cartoes.application.representation;

import br.com.microservice.cartoes.domain.CartaoCliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartoesPorClienteResponse {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public static CartoesPorClienteResponse fromModel(CartaoCliente model){
        return new CartoesPorClienteResponse(model.getCartao().getNome(), model.getCartao().getBandeiraCartao().toString(), model.getLimite());
    }
}
