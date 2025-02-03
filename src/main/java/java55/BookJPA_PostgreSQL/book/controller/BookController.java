package java55.BookJPA_PostgreSQL.book.controller;

import java55.BookJPA_PostgreSQL.book.dto.AuthorDto;
import java55.BookJPA_PostgreSQL.book.dto.BookDto;
import java55.BookJPA_PostgreSQL.book.dto.PublisherDto;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import java55.BookJPA_PostgreSQL.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {
    final BookService bookService;

    @PostMapping("/book")
    public Boolean addBook(@RequestBody BookDto bookDto){
        return bookService.addBook(bookDto);
    }

    @GetMapping("/book/{isbn}")
    public BookDto findBookByIsbn(@PathVariable String isbn){
        return bookService.findBookByIsbn(isbn);
    }

    @DeleteMapping ("/book/{isbn}")
    public BookDto removeBookByIsbn(@PathVariable String isbn){
        return bookService.removeBookByIsbn(isbn);
    }

    @DeleteMapping ("/author/{author}")
    public AuthorDto removeAuthorByName(@PathVariable String author){
        return bookService.removeAuthorByName(author);
    }

    @PutMapping ("book/{isbn}/title/{title}")
    public BookDto updateBookTitle(@PathVariable String isbn,
                                   @PathVariable String title){
        return bookService.updateBookTitle(isbn, title);
    }

    @GetMapping ("/books/author/{author}")
    public Iterable<BookDto> findBooksByAuthor(@PathVariable String author){
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping ("/books/publisher/{publisher}")
    public Iterable<BookDto> findBooksByPublisher(@PathVariable String publisher){
        return bookService.findBooksByPublisher(publisher);
    }

    @GetMapping ("/authors/book/{isbn}")
    public Iterable<AuthorDto> findBookAuthorsByIsbn(@PathVariable String isbn){
        return bookService.findBookAuthorsByIsbn(isbn);
    }

    @GetMapping ("/publishers/author/{author}")
    public Iterable<PublisherDto> findPublishersByAuthor(@PathVariable String author){
        return bookService.findPublishersByAuthor(author);
    }





}
