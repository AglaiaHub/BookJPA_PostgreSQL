package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PublisherRepository extends JpaRepository <Publisher, String> {
//    @Query("SELECT DISTINCT p FROM Publisher p JOIN Book b ON b.publisher = p JOIN b.authors a WHERE a.name = :authorName")
//    Collection<Publisher> findPublishersByAuthor(@Param("authorName") String authorName);
}
