package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {



    List<Book> findByAuthorsName(String name);

    List<Book> findByPublisherName(String publisher);

    void deleteByAuthorName(String authorName);

    Book save(Book book);

    Optional<Book> findById(String isbn);

    boolean existsById(String isbn);

    void deleteById(String isbn);
}
