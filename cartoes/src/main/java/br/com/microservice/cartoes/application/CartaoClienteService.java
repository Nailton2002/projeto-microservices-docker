package br.com.microservice.cartoes.application;

import br.com.microservice.cartoes.domain.CartaoCliente;
import br.com.microservice.cartoes.infra.repository.CartaoClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoClienteService {

    private final CartaoClienteRepository repository;

    public List<CartaoCliente> listCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
