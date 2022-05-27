package ufrn.br.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findProdutoByDescricao(String descricao);
}