package io.github.lenilson.icompras.pedidos.controller.dto;

import io.github.lenilson.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}