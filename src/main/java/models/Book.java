package models;

import enums.Genre;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Book {
    private Long id;
    private String title;
    private String author;
    private LocalDate publication_date;
    @Enumerated
    private Genre genre;

    public Book(String title, String author, LocalDate publication_date, Genre genre) {
        this.title = title;
        this.author = author;
        this.publication_date = publication_date;
        this.genre = genre;
    }
}
