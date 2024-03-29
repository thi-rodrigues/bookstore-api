package com.bookstore.domains.dto;

import java.io.Serializable;

import com.bookstore.domains.Book;

public class BookDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;

	public BookDTO() {
		super();
	}

	public BookDTO(Book livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
