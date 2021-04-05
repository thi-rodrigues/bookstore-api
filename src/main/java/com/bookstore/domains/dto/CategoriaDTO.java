package com.bookstore.domains.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.bookstore.domains.Categoria;

public class CategoriaDTO {

	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requerido!")
	@Length(min = 3, max = 100, message = "Campo NOME deve ter entre {min} e {max} caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requerido!")
	@Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre {min} e {max} caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
