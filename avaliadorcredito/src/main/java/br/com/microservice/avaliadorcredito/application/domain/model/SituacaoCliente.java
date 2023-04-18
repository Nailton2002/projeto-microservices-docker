package br.com.microservice.avaliadorcredito.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituacaoCliente { private DadosCliente cliente; private List<CartaoCliente> cartoes; }
