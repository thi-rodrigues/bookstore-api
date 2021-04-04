package com.bookstore.exceptions;

import com.bookstore.domains.Categoria;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Objeto não encontrado! " + "Id: " + id + ", Tipo: " + Categoria.class.getName());
	}
}

