package dao;

import enums.Genre;
import models.Book;

import java.sql.Connection;
import java.util.List;

public interface BookDao {
    void creatEnumColor();

    void creatTable();

    void insertBook(Book newBook);

    List<Book> getBooksByGenre(Genre genre);

    void updateBook(Long id, Book newBook);
    void deleteBook(Long id);
    List<Book> getBooksGroupedByAuthor();

    List<Book> getBooksSortedByPublicationDate( String ascOrDesc);
}