package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.domains.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT obj FROM Book obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Book> findByCategoria(@Param(value="id_cat") Integer id_cat);

}
