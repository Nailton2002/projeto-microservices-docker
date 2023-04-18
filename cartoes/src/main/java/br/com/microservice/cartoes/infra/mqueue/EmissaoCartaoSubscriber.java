package br.com.microservice.cartoes.infra.mqueue;

import br.com.microservice.cartoes.domain.Cartao;
import br.com.microservice.cartoes.domain.CartaoCliente;
import br.com.microservice.cartoes.domain.DadosSolicitacaoEmissaoCartao;
import br.com.microservice.cartoes.infra.repository.CartaoClienteRepository;
import br.com.microservice.cartoes.infra.repository.CartaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;

    private final CartaoClienteRepository cartaoClienteRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload){
        try {
        var mapper = new ObjectMapper();

        DadosSolicitacaoEmissaoCartao dados = mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
        Cartao cartao = cartaoRepository.findById(dados.getIdCartao()).orElseThrow();

            CartaoCliente cartaoCliente = new CartaoCliente();
            cartaoCliente.setCartao(cartao);
            cartaoCliente.setCpf(dados.getCpf());
            cartaoCliente.setLimite(dados.getLimiteLiberado());
            cartaoClienteRepository.save(cartaoCliente);

        } catch (Exception e) {
            log.error("Erro ao receber solicitação de emissão de cartão: {} ", e.getMessage());
        }

    }
}
