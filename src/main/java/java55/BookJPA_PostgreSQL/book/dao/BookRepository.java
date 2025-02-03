package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Author;
import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface BookRepository extends JpaRepository <Book, String> {
//    Collection<Book> findBooksByAuthor_Name(String authorName);

//    Collection<Book> findBooksByPublisher_Name(String publisher);

    @Query("SELECT DISTINCT b.publisher FROM Book b JOIN b.authors a WHERE a.name = :authorName")
    Collection<Publisher> findPublishersByAuthor(@Param("authorName") String authorName);
}
