package java55.BookJPA_PostgreSQL.book.service;

import java55.BookJPA_PostgreSQL.book.dto.AuthorDto;
import java55.BookJPA_PostgreSQL.book.dto.BookDto;

public interface BookService {
    Boolean addBook(BookDto bookDto);

    BookDto findBookByIsbn(String isbn);

    BookDto removeBookByIsbn(String isbn);

    AuthorDto removeAuthorByName(String author);

    BookDto updateBookTitle(String isbn, String title);

    Iterable<BookDto> findBooksByAuthor(String author);

    Iterable<BookDto> findBooksByPublisher(String publisher);

    Iterable<AuthorDto> findBookAuthorsByIsbn(String isbn);

    Iterable<String> findPublishersByAuthor(String author);
}
