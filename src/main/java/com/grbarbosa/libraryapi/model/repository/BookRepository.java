package com.grbarbosa.libraryapi.model.repository;

import com.grbarbosa.libraryapi.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByIsbn( String isbn );

    Optional<Book> findByIsbn( String isbn);

}
