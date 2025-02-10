package java55.BookJPA_PostgreSQL.book.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java55.BookJPA_PostgreSQL.book.model.Author;
import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public Iterable<String> findPublishersByAuthor(String authorName) {
        return em.createQuery(
                        "SELECT p.publisherName FROM Publisher p JOIN p.books b JOIN b.authors a WHERE a.name = :authorName", String.class)
                .setParameter("authorName", authorName)
                .getResultList();
//        TypedQuery<String> query = em.createQuery("select distinct p.publisherName from Book b" +
//                " join b.publisher p join b.author a where a.name=:authorName", String.class);
//        query.setParameter("authorName", authorName);
//        return query.getResultList();
    }

    @Override
    public Optional<Publisher> findById(String publisher) {
        return Optional.ofNullable(em.find(Publisher.class, publisher));
    }

    @Override
    public Publisher save(Publisher publisher) {
        em.persist(publisher);
        return publisher;
    }
}
