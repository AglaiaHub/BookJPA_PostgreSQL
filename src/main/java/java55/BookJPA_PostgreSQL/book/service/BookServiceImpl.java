package java55.BookJPA_PostgreSQL.book.service;

import jakarta.persistence.EntityNotFoundException;
import java55.BookJPA_PostgreSQL.book.dao.AuthorRepository;
import java55.BookJPA_PostgreSQL.book.dao.BookRepository;
import java55.BookJPA_PostgreSQL.book.dao.PublisherRepository;
import java55.BookJPA_PostgreSQL.book.dto.AuthorDto;
import java55.BookJPA_PostgreSQL.book.dto.BookDto;
import java55.BookJPA_PostgreSQL.book.dto.PublisherDto;
import java55.BookJPA_PostgreSQL.book.model.Author;
import java55.BookJPA_PostgreSQL.book.model.Book;
import java55.BookJPA_PostgreSQL.book.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    final BookRepository bookRepository;
    final AuthorRepository authorRepository;
    final PublisherRepository publisherRepository;
    final ModelMapper modelMapper;

    @Transactional
    @Override
    public Boolean addBook(BookDto bookDto) {
        if (bookRepository.existsById(bookDto.getIsbn())){
            return false;
        }
        //publisher
        Publisher publisher = publisherRepository.findById(bookDto.getPublisher())
                .orElse(publisherRepository.save(new Publisher(bookDto.getPublisher())));
        //Authors
        Set<Author> authors = bookDto.getAuthors().stream()
                .map(a -> authorRepository.findById(a.getName()).orElse(authorRepository.save(new Author(a.getName(), a.getBirthDate()))))
                .collect(Collectors.toSet());


        //Book
        Book book = new Book(bookDto.getIsbn(), bookDto.getTitle(), authors, publisher);
        bookRepository.save(book);
        return true;
    }

    @Override
    public BookDto findBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(book, BookDto.class);
    }

    @Transactional
    @Override
    public BookDto removeBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
        bookRepository.delete(book);
        return modelMapper.map(book, BookDto.class);
    }

    @Transactional
    @Override
    public AuthorDto removeAuthorByName(String authorName) {
        Author author = authorRepository.findById(authorName).orElseThrow(EntityNotFoundException::new);
        bookRepository.deleteByAuthorsName(authorName);
        authorRepository.deleteById(authorName);
        return modelMapper.map(author, AuthorDto.class);
    }

    @Transactional
    @Override
    public BookDto updateBookTitle(String isbn, String title) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
        book.setTitle(title);
        bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public Iterable<BookDto> findBooksByAuthor(String authorName) {
        return authorRepository.findBooksByAuthorName(authorName)
                .stream()
                .map(b -> modelMapper.map(b, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<BookDto> findBooksByPublisher(String publisher) {
//        return publisherRepository.findBooksByPublisher(publisher)
//                .stream()
//                .map(b -> modelMapper.map(b, BookDto.class))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public Iterable<AuthorDto> findBookAuthorsByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn).orElseThrow(EntityNotFoundException::new);
        return book.getAuthors().stream()
                .map(a -> modelMapper.map(a, AuthorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<PublisherDto> findPublishersByAuthor(String authorName) {
        return bookRepository.findPublishersByAuthor(authorName)
                .stream()
                .map(p -> modelMapper.map(p, PublisherDto.class))
                .collect(Collectors.toList());
    }
}
