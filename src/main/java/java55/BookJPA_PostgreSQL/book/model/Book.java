package java55.BookJPA_PostgreSQL.book.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@EqualsAndHashCode(of = "isbn")
public class Book {
    @Id
    String isbn;
    String title;
    @ManyToMany
    Set<Author> authors;
    @ManyToOne
    Publisher publisher;

}

