package io.github.lenilson.icompras.pedidos.service;

import io.github.lenilson.icompras.pedidos.client.ServicoBancarioClient;
import io.github.lenilson.icompras.pedidos.model.Pedido;
import io.github.lenilson.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.lenilson.icompras.pedidos.repository.PedidoRepository;
import io.github.lenilson.icompras.pedidos.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;
    private final ServicoBancarioClient servicoBancarioClient;
//    private final ClientesClient apiClientes;
//    private final ProdutosClient apiProdutos;
//    private final PagamentoPublisher pagamentoPublisher;

    @Transactional
    public Pedido criarPedido(Pedido pedido){
     validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolictacaoPagamento(pedido);
        return pedido;

    }

    private void enviarSolictacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }


}