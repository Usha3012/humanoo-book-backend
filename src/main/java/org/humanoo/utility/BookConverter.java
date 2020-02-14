package org.humanoo.utility;

import org.humanoo.domain.BookDTO;
import org.humanoo.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {
    public static Book toDo(BookDTO bookDTO){
        Book book = new Book();
        book.setName(bookDTO.getBookName());
        book.setAuthor(bookDTO.getAuthorName());
        book.setIsbn(bookDTO.getIsbn());
        book.setCategory(bookDTO.getCategories());
        return book;
    }

    public static BookDTO toDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookName(book.getName());
        bookDTO.setAuthorName(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setId(book.getId().toString());
        bookDTO.setCreatedOn(book.getCreatedOn());
        bookDTO.setModifiedOn(book.getModifiedOn());
        bookDTO.setCategories(book.getCategory());
        return bookDTO;
    }

    public static List<BookDTO> toDTO(List<Book> books){
        return books.stream()
                .map(BookConverter::toDTO)
                .collect(Collectors.toList());
    }
}
