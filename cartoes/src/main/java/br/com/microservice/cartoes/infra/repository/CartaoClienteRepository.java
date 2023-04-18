package br.com.microservice.cartoes.infra.repository;

import br.com.microservice.cartoes.domain.CartaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, Long> {

    List<CartaoCliente> findByCpf(String cpf);

}
