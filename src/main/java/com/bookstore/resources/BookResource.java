package com.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.domains.Book;
import com.bookstore.domains.dto.BookDTO;
import com.bookstore.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	@Autowired
	private BookService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book findById = service.findById(id);
		return ResponseEntity.ok().body(findById);
	}

	@GetMapping
	public ResponseEntity<List<BookDTO>> findByCategoria(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
		List<Book> books = service.findAll(id_cat);
		List<BookDTO> booksDto = books.stream()
				.map(BookDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(booksDto);
	}
	
	@PostMapping
	public ResponseEntity<Book> create(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat, 
									   @RequestBody Book book){
		Book newBook = service.create(id_cat, book);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/books/{id}").buildAndExpand(newBook.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book){
		Book bookUpdate = service.update(id, book);
		return ResponseEntity.ok().body(bookUpdate);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Book> updatePatch(@PathVariable Integer id, @RequestBody Book book){
		Book bookUpdate = service.update(id, book);
		return ResponseEntity.ok().body(bookUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
