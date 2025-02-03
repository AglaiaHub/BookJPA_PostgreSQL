package java55.BookJPA_PostgreSQL.book.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AuthorDto {
    String name;
    LocalDate birthDate;
}