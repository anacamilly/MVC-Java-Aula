package ufrn.br.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.demo.model.Produto;

/*Um Repository (Repositório) é um objeto que isola os objetos ou entidades do domínio do código que acessa o banco de dados.
Temos que um repositório implementa parte das regras de negócio no que se refere à composição das entidades.*/
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findProdutoByDescricao(String descricao);
}