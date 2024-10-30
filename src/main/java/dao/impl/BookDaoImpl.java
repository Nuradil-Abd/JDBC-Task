package dao.impl;

import dao.BookDao;
import enums.Genre;
import models.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
                genre genres not null )
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
        String query = """
                insert into Books (title, author, publication_date, genre)
                 values (?, ?, ?, ?);""";

       try (PreparedStatement ps = connection.prepareStatement(query)){
           ps.setString(1, newBook.getTitle());
           ps.setString(2, newBook.getAuthor());
           ps.setDate(3,java.sql.Date.valueOf(newBook.getPublication_date()));
           ps.setObject(4,newBook.getGenre().name(), Types.OTHER);

           int row = ps.executeUpdate();
           if(row > 0) {
               System.out.println("book inserted successfully");
           }

       }catch (SQLException e) {
           throw new RuntimeException("Error inserting book",e);
       }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        String query = "select * from Books where genre = ? :: genres";
        List<Book> books = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, genre.name());
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Book book = new Book(
                    rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDate("publication_date").toLocalDate(),
                    Genre.valueOf(rs.getString("genre") ));
                    books.add(book);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error ",e);
        }
        return books;
    }

    @Override
    public void updateBook(Long id, Book newBook) {
        String query = """
                update Books set title = ?, author = ?, publication_date = ?, genre = ?
                where id = ?;""";

        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, newBook.getTitle());
            ps.setString(2, newBook.getAuthor());
            ps.setDate(3, java.sql.Date.valueOf(newBook.getPublication_date()));
            ps.setObject(4,newBook.getGenre().name(), Types.OTHER);
            ps.setLong(5,id);

            int row = ps.executeUpdate();
            if(row > 0) {
                System.out.println("book updated successfully");
            }else {
                System.out.println("book not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error updating book",e);
        }

    }

    @Override
    public void deleteBook(Long id) {
        String query = "delete from Books where id = ?;";

        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1, id);

            int row = ps.executeUpdate();
            if(row > 0) {
                System.out.println("book deleted successfully");
            }else{
                System.out.println("book not found");
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error deleting book",e);
        }

    }

    @Override
    public List<Book> getBooksGroupedByAuthor() {
        String query = "select author, array_agg(title) as titles from Books group by author";
        List<Book> books = new ArrayList<>();

        try(Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(query)){
           while (rs.next()) {
               String author = rs.getString("author");
               String[] titles = (String[]) rs.getArray("titles").getArray();

               for (String title : titles) {
                   books.add(new Book(null,title,author,null,null));
               }
           }
        }catch (SQLException e){
            throw new RuntimeException("Error",e);
        }
        return books;
    }

    @Override
    public List<Book> getBooksSortedByPublicationDate(String ascOrDesc) {
        String order = ascOrDesc.equalsIgnoreCase("asc") ? "asc" : "desc";
        String query = "select * from Books order by publication_date " + order;
        List<Book> books = new ArrayList<>();

        try(Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(query)){
            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                LocalDate publicationDate = rs.getDate("publication_date").toLocalDate();
                Genre genre = Genre.valueOf(rs.getString("genre"));

                Book book = new Book(id,title,author,publicationDate,genre);
                books.add(book);
            }

        }catch(SQLException e){
            throw new RuntimeException("Error",e);
        }

        return books;
    }

}
