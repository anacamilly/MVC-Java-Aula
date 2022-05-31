package ufrn.br.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ufrn.br.demo.errorhandling.ApiMessages;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = ApiMessages.ERRO_NOME)
    @Size(min = 5)
    String nome;

    @Size(min = 10)
    @NotBlank(message = ApiMessages.ERRO_DESCRICAO)
    String descricao;

    @Min(0)
    Float preco;
}