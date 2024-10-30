package dao.impl;

import dao.BookDao;
import enums.Genre;
import models.Book;

import java.sql.*;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private final Connection connection;

    public BookDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void creatEnumColor() {
        String query = """
                               create type genres as ENUM (
                                   'FICTION',
                                   'NON_FICTION',
                                   'ROMANCE',
                                   'FANTASY',
                                   'BIOGRAPHY',
                                   'THRILLER'
                               );
                """;
        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("success created table");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void creatTable() {
        String query = """
                create table Books (
                id serial primary key ,
                title varchar unique not null,
                author varchar,
                publication_date date not null,
                genre genres NOT NULL )
                """;
        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);
            System.out.println("success created table");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insertBook(Book newBook) {

    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return null;
    }

    @Override
    public void updateBook(Long id, Book newBook) {

    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public List<Book> getBooksGroupedByAuthor() {
        return null;
    }

    @Override
    public List<Book> getBooksSortedByPublicationDate(String ascOrDesc) {
        return null;
    }

}
