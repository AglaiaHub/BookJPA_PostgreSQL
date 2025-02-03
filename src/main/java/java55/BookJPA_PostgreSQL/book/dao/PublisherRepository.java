package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PublisherRepository extends JpaRepository <Publisher, String> {

    @Query("SELECT b FROM Book b WHERE b.publisher.name = :publisherName")
    Collection<Book> findBooksByPublisher(@Param("publisherName") String publisherName);
}
