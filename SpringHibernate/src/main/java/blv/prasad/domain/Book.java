package blv.prasad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "BOOKS", schema = "springhibernate_db")
public class Book {
 
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    
    @Column(name="BOOK_NAME")
    private String bookName;
 
    @Column(name="AUTHOR")
    private String author;
    
    @Column(name="PRICE")
    private int price;
    
    @Column(name="QTY")
    private int quantity;
    
    public Integer getId() 
    {return id;}
 
    public String getBookName() 
    {return bookName;}
 
    public String getAuthor() 
    {return author;}
 
    public int getPrice() 
    {return price;}
 
    public int getQuantity() 
    {return quantity;}
 
    public void setId(Integer id) 
    {this.id = id;}
 
    public void setBookName(String bookName) 
    {this.bookName = bookName;}
 
    public void setAuthor(String author) 
    {this.author = author;}
 
    public void setPrice(int price) 
    {this.price = price;}
 
    public void setQuantity(int quantity) 
    {this.quantity = quantity;}
}