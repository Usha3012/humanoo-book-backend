package org.humanoo.repository;

import org.humanoo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<List<Book>> findByName(String name);
    Optional<Book> findByNameAndAuthor(String name,String author);
}
