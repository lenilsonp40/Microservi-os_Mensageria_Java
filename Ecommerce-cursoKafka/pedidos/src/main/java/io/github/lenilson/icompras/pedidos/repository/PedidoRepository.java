package io.github.lenilson.icompras.pedidos.repository;

import io.github.lenilson.icompras.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
