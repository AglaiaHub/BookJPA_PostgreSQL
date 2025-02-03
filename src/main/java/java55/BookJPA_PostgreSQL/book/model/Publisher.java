package java55.BookJPA_PostgreSQL.book.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@EqualsAndHashCode(of = "publisherName")
public class Publisher {
    @Id
    String publisherName;
}
