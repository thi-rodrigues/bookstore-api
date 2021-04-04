package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Categoria;
import com.bookstore.exception.ResourceNotFoundException;
import com.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> findById = repository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
