package com.bookstore.exception;

import com.bookstore.domain.Categoria;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

//	public ResourceNotFoundException(String message, Throwable cause) {
//		super(message, cause);
//	}

	public ResourceNotFoundException(Object id) {
		super("Objeto não encontrado! " + "Id: " + id + ", Tipo: " + Categoria.class.getName());
	}
}

