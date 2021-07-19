package br.com.test.bis2bis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.test.bis2bis.model.Produto;
import br.com.test.bis2bis.produto.dto.ProdutoRequestDTO;
import br.com.test.bis2bis.produto.dto.ProdutoResponseDTO;
import br.com.test.bis2bis.service.ProdutoService;

@RequestMapping("/produtos")
@Controller
@CrossOrigin("http://localhost:4200")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity< List <ProdutoResponseDTO >> listAll(){
		
		List<ProdutoResponseDTO> produtoDTO = this.produtoService.listAll();
		return ResponseEntity.ok(produtoDTO);
		 
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Produto> create(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO){
		Produto produtos = produtoService.create(produtoRequestDTO);
		
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(produtos.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> update(@PathVariable(name = "id") Long id, @Valid @RequestBody ProdutoRequestDTO ProdutoRequestDTO ){
		ProdutoResponseDTO produtoResponseDTO = this.produtoService.update(id, ProdutoRequestDTO);
		return ResponseEntity.ok(produtoResponseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> findByIdProduto(@PathVariable(name = "id") Long id){
		ProdutoResponseDTO produtoResponseDTO = this.produtoService.findById(id);
		return ResponseEntity.ok(produtoResponseDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> deleteProduto(@PathVariable(name="id") Long id) {
		ProdutoResponseDTO produtoResponseDTO = this.produtoService.deleteProduto(id);
		return ResponseEntity.ok(produtoResponseDTO);
		
	}
}