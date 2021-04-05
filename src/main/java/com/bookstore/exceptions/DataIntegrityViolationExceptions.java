package com.bookstore.exceptions;

public class DataIntegrityViolationExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationExceptions() {
		super("Categoria não pode ser deletada. Possui livros associado(s).");
	}
}
