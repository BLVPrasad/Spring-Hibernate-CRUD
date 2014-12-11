package blv.prasad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blv.prasad.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
    
    
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }
 
   
    public void removeBook(Integer id) {
        Book book = (Book)sessionFactory.getCurrentSession()
            .load(Book.class, id);
        if(null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }
    }
 

    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        return sessionFactory.getCurrentSession()
            .createQuery("from Book").list();
    }
 

    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }
    

    @SuppressWarnings("unchecked")
    public Book getBookById(Integer bookId) {
        Session session = sessionFactory.getCurrentSession();
        List<Book> list = session.createQuery("from Book b where b.id = :bookId")
            .setParameter("bookId", bookId)
            .list();
        return list.size() > 0 ?(Book)list.get(0): null;
    }
 
}
