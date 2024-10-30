package service.impl;

import config.DatabaseConfig;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import enums.Genre;
import models.Book;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    public BookServiceImpl() {
        this.bookDao = new BookDaoImpl(DatabaseConfig.getConnection());
    }
    @Override
    public void creatEnumColor() {
        bookDao.creatEnumColor();
    }

    @Override
    public void creatTable() {
        bookDao.creatTable();

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
