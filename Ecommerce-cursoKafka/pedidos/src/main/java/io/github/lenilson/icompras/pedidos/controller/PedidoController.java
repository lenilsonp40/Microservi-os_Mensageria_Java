package io.github.lenilson.icompras.pedidos.controller;

import io.github.lenilson.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.lenilson.icompras.pedidos.controller.mappers.PedidoMapper;
import io.github.lenilson.icompras.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;
//    private final DetalhePedidoMapper detalhePedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto){
        var pedido = mapper.map(dto);
        var novoPedido = service.criarPedido(pedido);

        return ResponseEntity.ok(novoPedido.getCodigo());

    }

//    @PostMapping("pagamentos")
//    public ResponseEntity<Object> adicionarNovoPagamento(
//            @RequestBody AdicaoNovoPagamentoDTO dto){
//        try {
//            service.adicionarNovoPagamento(dto.codigoPedido(), dto.dados(), dto.tipoPagamento());
//            return ResponseEntity.noContent().build();
//        } catch (ItemNaoEncontradoException e){
//            var erro = new ErroResposta(
//                    "Item não encontrado", "codigoPedido", e.getMessage());
//            return ResponseEntity.badRequest().body(erro);
//        }
//    }
//
//    @GetMapping("{codigo}")
//    public ResponseEntity<DetalhePedidoRepresentation> obterDetalhesPedido(
//            @PathVariable("codigo") Long codigo){
//        return service
//                .carregarDadosCompletosPedido(codigo)
//                .map(detalhePedidoMapper::map)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build() );
//    }
}