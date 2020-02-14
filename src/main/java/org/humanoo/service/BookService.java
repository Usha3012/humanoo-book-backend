package org.humanoo.service;

import lombok.RequiredArgsConstructor;
import org.humanoo.domain.BookDTO;
import org.humanoo.entity.Book;
import org.humanoo.exception.BookNotFoundException;
import org.humanoo.repository.BookRepository;
import org.humanoo.utility.BookConverter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.humanoo.utility.BookConverter.toDTO;
import static org.humanoo.utility.BookConverter.toDo;

@Service
@RequiredArgsConstructor
public class BookService {
    private  final BookRepository bookRepository;
    @Transactional
    public List<BookDTO> getAllBooks() {
        List<Book> books= bookRepository.findAll();
        return books.stream()
                .map(BookConverter::toDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public List<BookDTO> getBookByName(String name) {
            List<Book> books = bookRepository.findByName(name)
                .orElseThrow(()->new BookNotFoundException("No book with name "+ name + " found"));
        return BookConverter.toDTO(books);
    }
    @Transactional
    public BookDTO getBookByNameAndAuthor(String name,String author) {
        Book book = bookRepository.findByNameAndAuthor(name,author)
                .orElseThrow(()->new BookNotFoundException("No book with name "+ name + "and author "+author+ "found"));
        return BookConverter.toDTO(book);
    }
@Transactional
    public BookDTO create(BookDTO bookDTO) {
        Book book = toDo(bookDTO);
        book=bookRepository.save(book);
        return toDTO(book);
    }
}
