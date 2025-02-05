package java55.BookJPA_PostgreSQL.book.dao;

import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface PublisherRepository {
//    @Query("select distinct p.publisherName from Book b join b.publisher p join b.authors a where a.name=?1")
    Iterable<String> findPublishersByAuthor(String authorName);

    Optional<Publisher> findById(String publisher);

    Publisher save(Publisher publisher);
}
