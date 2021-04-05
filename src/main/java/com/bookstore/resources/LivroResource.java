package com.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domains.Livro;
import com.bookstore.domains.dto.LivroDTO;
import com.bookstore.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro findById = service.findById(id);
		return ResponseEntity.ok().body(findById);
	}

	@GetMapping
	public ResponseEntity<List<LivroDTO>> findByCategoria(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
		List<Livro> livros = service.findAll(id_cat);
		List<LivroDTO> livroDto = livros.stream()
				.map(LivroDTO::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDto);
	}

}
