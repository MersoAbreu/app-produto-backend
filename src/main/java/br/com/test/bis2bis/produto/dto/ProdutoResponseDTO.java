package br.com.test.bis2bis.produto.dto;

import java.io.Serializable;

import br.com.test.bis2bis.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoResponseDTO implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    
	private Long id;

    private String nome;

    private String descricao;
    
    private String mercado;

    private String tecnologia;


	public static ProdutoResponseDTO convertToDTO(Produto produto) {
	
		return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getDescricao(),produto.getMercado(), produto.getTecnologia());
	}


	


}
