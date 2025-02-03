package java55.BookJPA_PostgreSQL.book.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


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
}