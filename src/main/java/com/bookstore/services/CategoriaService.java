package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domains.Categoria;
import com.bookstore.exceptions.ResourceNotFoundException;
import com.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> findById = repository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria categoria) {
		categoria.setId(null);
		return repository.save(categoria);
	}
}