package br.com.test.bis2bis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.test.bis2bis.model.Produto;
import br.com.test.bis2bis.produto.dto.ProdutoRequestDTO;
import br.com.test.bis2bis.produto.dto.ProdutoResponseDTO;
import br.com.test.bis2bis.repository.ProdutoRepository;
import br.com.test.bis2bis.service.exceptions.ProdutoNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoResponseDTO> listAll(){
		List<Produto> produtos = produtoRepository.findAll();
			if(produtos.isEmpty()) {
				throw new ProdutoNotFoundException("Lista de produtos vazia");
			}
			List<ProdutoResponseDTO> produtoResponseDTOs = produtos.stream()
					.map(e -> ProdutoResponseDTO.convertToDTO(e)).collect(Collectors.toList());
			return produtoResponseDTOs;
	}
	
	
	public Produto create(ProdutoRequestDTO produtoRequestDTO) {
		Produto produto = ProdutoRequestDTO.convertToRequestDTO(produtoRequestDTO);
		produto = this.produtoRepository.save(produto);
		return produto;
	}
	
	public Produto findProdutoById(Long id) {
		Optional<Produto> produto = this.produtoRepository.findById(id);
		if(produto.isEmpty()) {
			throw new ProdutoNotFoundException("Produto não encontrado com este id informado "+id); 
		}
		return produto.get();
	}
	
	public ProdutoResponseDTO findById(Long id) {
		ProdutoResponseDTO produtoResponseDTO;
		
		try {
			Produto produto = this.findProdutoById(id);
			produtoResponseDTO = ProdutoResponseDTO.convertToDTO(produto);
		} catch (ProdutoNotFoundException e) {
			throw e;
		}
		return produtoResponseDTO;
	}

	public ProdutoResponseDTO update(Long id, ProdutoRequestDTO produtoRequestDTO) {
		ProdutoResponseDTO produtoResponseDTO = null;
		try {
			Produto produto = this.findProdutoById(id);
			produto.setDescricao(produtoRequestDTO.getDescricao());
			produto.setNome(produtoRequestDTO.getNome());
			produto.setMercado(produtoRequestDTO.getMercado());
			produto.setTecnologia(produtoRequestDTO.getTecnologia());
			produto = this.produtoRepository.saveAndFlush(produto);
			produtoResponseDTO = ProdutoResponseDTO.convertToDTO(produto);
		} catch (ProdutoNotFoundException e) {
			throw e;
		}
		return produtoResponseDTO;
	}


	public  ProdutoResponseDTO  deleteProduto(Long id) {
		
		Produto produto = this.findProdutoById(id);
		if(produto != null) {
			this.produtoRepository.delete(produto);
		
		}
		
		throw new ProdutoNotFoundException("Produto não encontrado id: "+id);
		
	}

	
}
