package com.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domains.Categoria;
import com.bookstore.domains.Book;
import com.bookstore.repositories.CategoriaRepository;
import com.bookstore.repositories.BookRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private BookRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficcção Científica", "Ficcção científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		Book l1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Book l2 = new Book(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", cat1);
		Book l3 = new Book(null, "The Time Machine", "H.G. Wells", "Lorem ipsum", cat2);
		Book l4 = new Book(null, "The War of the Worlds", "H.G. Wells", "Lorem ipsum", cat2);
		Book l5 = new Book(null, "I, Robot", "Isaac Asimov", "Lorem ipsum", cat2);

		cat1.setLivros(Arrays.asList(l1, l2));
		cat2.setLivros(Arrays.asList(l3, l4, l5));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}
}
