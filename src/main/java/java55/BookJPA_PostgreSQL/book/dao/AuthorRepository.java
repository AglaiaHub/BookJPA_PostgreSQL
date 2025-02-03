package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Author;
import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AuthorRepository extends JpaRepository <Author, String> {

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.name = :authorName")
    Collection<Book> findBooksByAuthorName(@Param("authorName") String authorName);

}
