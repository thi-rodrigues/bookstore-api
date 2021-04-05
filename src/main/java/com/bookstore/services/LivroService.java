package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.domains.Livro;
import com.bookstore.exceptions.DataIntegrityViolationExceptions;
import com.bookstore.exceptions.ResourceNotFoundException;
import com.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> findById = repository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findByCategoria(id_cat);
	}

	public Livro create(Livro livro) {
		livro.setId(null);
		return repository.save(livro);
	}
	
	public void deleteById(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationExceptions();
		}
	}
}
