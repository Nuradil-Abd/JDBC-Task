package java15;

import config.DatabaseConfig;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import enums.Genre;
import models.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        DatabaseConfig.getConnection();

        BookService bookService = new BookServiceImpl();

//        bookService.creatEnumColor();
//
//        //create Books table
//        bookService.creatTable();
//
//        //add book
//      bookService.insertBook(
//              new Book("Cod Da Vinci","Den Braun",
//                      LocalDate.of(2009,3,12),
//                      Genre.ROMANCE));

//        // get books where genre romans
//        List<Book> target = bookService.getBooksByGenre(Genre.ROMANCE);
//        target.forEach(System.out::println);

        //update book
//        bookService.updateBook(1L,new Book("Angels and Demons","Den Braun",
//                      LocalDate.of(2009,3,12),
//                      Genre.ROMANCE));

//        //delete book
//        bookService.deleteBook(1L);

//        //grouped by author  использовал array_agg() для группировки в  массив
//        List<Book> target = bookService.getBooksGroupedByAuthor();
//        target.forEach(System.out::println);

//       //  get books desc
//        List<Book> sorted = bookService.getBooksSortedByPublicationDate("deSc");
//        sorted.forEach(System.out::println);
    }
}
