//MODEL: a camada de manipulação dos dados.
package ufrn.br.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*A anotação @Entity é utilizada para informar que uma classe também é uma entidade.
A partir disso, a JPA estabelecerá a ligação entre a entidade e uma tabela de mesmo nome no banco de dados,
onde os dados de objetos desse tipo poderão ser persistidos.*/
@Entity
//O Lombok possui a anotação AllArgsConstructor que cria um construtor com todos os atributos da classe.
@AllArgsConstructor
//A anotação NoArgsConstructor é responsável por gerar um construtor sem parâmetros.
@NoArgsConstructor
/*A anotação Data é responsável por gerar um conjunto de anotações implícitas nela mesma 
como @ToString, @EqualsAndHashCode, @Getter e @Setter em todos os campos, e @RequiredArgsConstructor.*/
@Data
public class Produto {

    /*A anotação @Id é utilizada para informar ao JPA qual campo/atributo de uma entidade estará relacionado à chave primária da respectiva tabela no banco de dados.
    Essa é uma anotação obrigatória e um erro será gerado em tempo de execução caso ela não esteja presente.*/
    @Id
    /*A anotação GeneratedValue serve para falar que o campo mapeado será gerado automaticamente pelo banco de dados,
    quando usamos Identity falamos que deve pegar o último registro daquela tabela e seguir com base naquele.*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;
    String descricao;
    String preco;
}