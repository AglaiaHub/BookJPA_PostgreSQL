package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AuthorRepository extends JpaRepository <Author, String> {

    @Query("SELECT DISTINCT a FROM Book b JOIN b.authors a WHERE b.isbn = :isbn")
    Collection<Author> findAuthorsByIsbn(String isbn);

}
