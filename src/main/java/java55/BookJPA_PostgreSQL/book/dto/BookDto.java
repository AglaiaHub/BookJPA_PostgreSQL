package java55.BookJPA_PostgreSQL.book.dto;

import lombok.Getter;

import java.util.Set;

@Getter
public class BookDto {
    String isbn;
    String title;
    Set<AuthorDto> authors;
    String publisher;

}

