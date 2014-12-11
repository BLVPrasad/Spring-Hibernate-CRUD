package blv.prasad.dao;

import java.util.List;

import blv.prasad.domain.Book;
 
public interface BookDAO {
    
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(Integer bookId);
    public void removeBook(Integer id);
    
}