package java55.BookJPA_PostgreSQL.book.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java55.BookJPA_PostgreSQL.book.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Book> findByAuthorsName(String name) {
        return entityManager.createQuery(
                "SELECT b FROM Book b JOIN b.authors a WHERE a.name = :authorName", Book.class)
                .setParameter("authorName", name)
                .getResultList();
    }

    @Override
    public List<Book> findByPublisherName(String publisher) {
        return entityManager.createQuery(
                        "SELECT b FROM books b JOIN b.publisher p WHERE p.publisherName = :publisherName", Book.class)
                .setParameter("publisherName", publisher)
                .getResultList();
    }

    @Override
    public void deleteByAuthorName(String authorName) {
        entityManager.createQuery(
                        "DELETE b FROM Book b JOIN b.authors a WHERE a.name = :authorName", Book.class)
                .setParameter("authorName", authorName);
    }

    @Override
    public Book save(Book book)  {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Optional<Book> findById(String isbn) {
        return Optional.ofNullable(entityManager.find(Book.class, isbn));
    }

    @Override
    public boolean existsById(String isbn) {
        return entityManager.find(Book.class, isbn) != null;
    }

    @Override
    public void deleteById(String isbn) {
        entityManager.remove(isbn);
    }
}
