package io.github.lenilson.icompras.pedidos.repository;

import io.github.lenilson.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
