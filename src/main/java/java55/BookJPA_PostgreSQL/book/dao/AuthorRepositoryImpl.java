package java55.BookJPA_PostgreSQL.book.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java55.BookJPA_PostgreSQL.book.model.Author;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Author save(Author author) {
        em.persist(author);
        return author;
    }

    @Override
    public Optional<Author> findById(String name) {
        return Optional.ofNullable(em.find(Author.class, name));
    }

    @Override
    public void deleteById(String authorName) {
        Author author = em.find(Author.class, authorName);
        em.remove(author);
    }
}
