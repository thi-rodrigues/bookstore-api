package com.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bookstore.domains.Book;
import com.bookstore.domains.Categoria;
import com.bookstore.exceptions.DataIntegrityViolationExceptions;
import com.bookstore.exceptions.ResourceNotFoundException;
import com.bookstore.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoriaService categoriaService;

	public Book findById(Integer id) {
		Optional<Book> findById = repository.findById(id);
		return findById.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Book> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findByCategoria(id_cat);
	}

	public Book create(Integer id_cat, Book book) {
		book.setId(null);
		Categoria categoria = categoriaService.findById(id_cat);
		book.setCategoria(categoria);
		return repository.save(book);
	}

	public void deleteById(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationExceptions();
		}
	}

	public Book update(Integer id, Book book) {
		Book bookUpdate = findById(id);
		updateBook(bookUpdate, book);
		return repository.save(bookUpdate);
	}

	private void updateBook(Book bookUpdate, Book book) {
		bookUpdate.setTitulo(book.getTitulo());
		bookUpdate.setNome_autor(book.getNome_autor());
		bookUpdate.setTexto(book.getTexto());
	}
}
