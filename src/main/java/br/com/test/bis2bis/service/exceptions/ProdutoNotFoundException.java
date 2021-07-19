package br.com.test.bis2bis.service.exceptions;

public class ProdutoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProdutoNotFoundException (String message) {
		super(message);
	}

	
}
