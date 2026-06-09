package io.github.lenilson.icompras.pedidos.controller.mappers;

import io.github.lenilson.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.lenilson.icompras.pedidos.controller.dto.NovoPedidoDTO;
import io.github.lenilson.icompras.pedidos.model.ItemPedido;
import io.github.lenilson.icompras.pedidos.model.Pedido;
import io.github.lenilson.icompras.pedidos.model.enums.StatusPedido;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    ItemPedidoMapper ITEM_PEDIDO_MAPPER = Mappers.getMapper(ItemPedidoMapper.class);

    @Mapping(source = "itens", target = "itens", qualifiedByName = "mapItens")
    @Mapping(source = "dadosPagamento", target = "dadosPagamento")
    Pedido map(NovoPedidoDTO dto);

    @Named("mapItens")
    default List<ItemPedido> map(List<ItemPedidoDTO> dtos) {
        return dtos.stream()
                .map(ITEM_PEDIDO_MAPPER::map)
                .toList();
    }

    @AfterMapping
    default void afterMapping(@MappingTarget Pedido pedido) {
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setDataPedido(LocalDateTime.now());

        var total = pedido.getItens().stream().map(item ->
             item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()))
        ).reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
