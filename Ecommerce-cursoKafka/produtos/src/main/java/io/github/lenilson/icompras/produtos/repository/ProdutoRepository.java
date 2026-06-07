package io.github.lenilson.icompras.produtos.repository;

import io.github.lenilson.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
