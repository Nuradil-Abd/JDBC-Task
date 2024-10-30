package java15;

import config.DatabaseConfig;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;
import service.impl.BookServiceImpl;

import java.sql.Connection;

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

        bookService.creatTable();




    }
}
