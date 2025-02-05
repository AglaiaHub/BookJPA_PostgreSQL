package java55.BookJPA_PostgreSQL.book.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@EqualsAndHashCode(of = "publisherName")
public class Publisher {
    @Id
    String publisherName;

    @OneToMany(mappedBy = "publisher")
    Set<Book> books;

    public Publisher(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return publisherName;
    }
}
