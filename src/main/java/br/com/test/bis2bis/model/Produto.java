package br.com.test.bis2bis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String descricao;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String mercado;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String tecnologia;


}
