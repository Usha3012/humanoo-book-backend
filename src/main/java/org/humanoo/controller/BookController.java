package org.humanoo.controller;

import lombok.RequiredArgsConstructor;
import org.humanoo.domain.BookDTO;
import org.humanoo.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @RequestMapping(path = "/books",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getBook(){
        return new ResponseEntity<List<BookDTO>>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(path = "/books/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BookDTO>> getBookByName(@PathVariable("name") @NotNull String name){
        List<BookDTO> books = bookService.getBookByName(name);
        return new ResponseEntity<List<BookDTO>>(books, HttpStatus.OK);
    }

    @RequestMapping(path = "/books/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> searchBooks(@RequestParam("name") @NotNull String name,
                                               @RequestParam("author") @NotNull String author){
        BookDTO bookDTO = bookService.getBookByNameAndAuthor(name,author);
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/books",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO){
        return new ResponseEntity<>(bookService.create(bookDTO),HttpStatus.CREATED);
    }
}
