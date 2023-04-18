package br.com.microservice.cartoes.application;

import br.com.microservice.cartoes.application.representation.CartaoSaveRequest;
import br.com.microservice.cartoes.application.representation.CartoesPorClienteResponse;
import br.com.microservice.cartoes.domain.Cartao;
import br.com.microservice.cartoes.domain.CartaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartoesResource {

    private final CartaoService cartaoService;
    private final CartaoClienteService cartaoClienteService;

    @GetMapping
    public String status(){return "cartoes ok!";}

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<CartaoCliente> lista = cartaoClienteService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> resultList = lista.stream().map(CartoesPorClienteResponse::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
