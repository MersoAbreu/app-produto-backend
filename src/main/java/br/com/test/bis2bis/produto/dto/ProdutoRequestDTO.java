package br.com.test.bis2bis.produto.dto;

import java.io.Serializable;

import br.com.test.bis2bis.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoRequestDTO implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
	private Long id;

    private String nome;

    private String descricao;

    private String tecnologia;

    private String mercado;
    
    public static Produto convertToRequestDTO(ProdutoRequestDTO produtoRequestDTO) {
    	return new Produto(produtoRequestDTO.getId(),produtoRequestDTO.getNome(), produtoRequestDTO.getDescricao(), produtoRequestDTO.getMercado(), produtoRequestDTO.getTecnologia());
    	
    }

}