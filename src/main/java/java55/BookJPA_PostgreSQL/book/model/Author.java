package java55.BookJPA_PostgreSQL.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@EqualsAndHashCode(of = "name")
@Getter
public class Author {
    @Id
    String name;
    LocalDate birthDate;

    @ManyToMany (mappedBy = "authors", cascade = CascadeType.REMOVE)
    Set<Book> books;

    public Author(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}