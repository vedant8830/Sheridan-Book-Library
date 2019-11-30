package ca.sheridancollege.Database;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.Bean.Book;
import ca.sheridancollege.Bean.DummyRecord;



@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public void addBook(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO davis(Title,Author,Price,Quantity,RelatedCourses)" +
		" Values(:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		parameters.addValue("Title", book.getTitle());
		parameters.addValue("Author", book.getAuthor());
		parameters.addValue("Price", book.getPrice());
		parameters.addValue("Quantity", book.getQuantity());
		parameters.addValue("RelatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	
	public ArrayList<Book> getBooks(){
		String query = "select * from davis";
		ArrayList<Book> books = (ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}
	public Book getbookById(int Id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	
	public void editBook(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE davis SET Title =:Title, Author=:Author, Price=:Price, Quantity=:Quantity, RelatedCourses=:RelatedCourses WHERE Id=:Id";
		  parameters.addValue("Id",book.getId());
		  parameters.addValue("Title",book.getTitle());
		  parameters.addValue("Author",book.getAuthor());
		  parameters.addValue("Price",book.getPrice());
		  parameters.addValue("Quantity",book.getQuantity());
		  parameters.addValue("RelatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	
	public void deleteBook(int Id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM davis WHERE Id=:Id";
			  parameters.addValue("Id",Id);
			  jdbc.update(query, parameters);
		  }
	
	
	// hmc 
	
	public void addBookHmc(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO hmc(Title,Author,Price,Quantity,RelatedCourses)" +
		" Values(:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		parameters.addValue("Title", book.getTitle());
		parameters.addValue("Author", book.getAuthor());
		parameters.addValue("Price", book.getPrice());
		parameters.addValue("Quantity", book.getQuantity());
		parameters.addValue("RelatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	public ArrayList<Book> getBooksHmc(){
		String query = "select * from hmc";
		ArrayList<Book> books = (ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}
	public Book getbookByIdHmc(int Id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	public void editBookHmc(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE hmc SET Title =:Title, Author=:Author, Price=:Price, Quantity=:Quantity, RelatedCourses=:RelatedCourses WHERE Id=:Id";
		  parameters.addValue("Id",book.getId());
		  parameters.addValue("Title",book.getTitle());
		  parameters.addValue("Author",book.getAuthor());
		  parameters.addValue("Price",book.getPrice());
		  parameters.addValue("Quantity",book.getQuantity());
		  parameters.addValue("RelatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	public void deleteBookHmc(int Id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM hmc WHERE Id=:Id";
			  parameters.addValue("Id",Id);
			  jdbc.update(query, parameters);
		  }
	
	//trafalgar
	public void addBookTra(Book book) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="INSERT INTO trafalgar(Title,Author,Price,Quantity,RelatedCourses)" +
		" Values(:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		parameters.addValue("Title", book.getTitle());
		parameters.addValue("Author", book.getAuthor());
		parameters.addValue("Price", book.getPrice());
		parameters.addValue("Quantity", book.getQuantity());
		parameters.addValue("RelatedCourses", book.getRelatedCourses());
		 
		jdbc.update(query, parameters);
		}
	public ArrayList<Book> getBooksTra(){
		String query = "select * from trafalgar";
		ArrayList<Book> books = (ArrayList<Book>)jdbc.query(query,new BeanPropertyRowMapper<Book>(Book.class));
		return books;
	}
	public Book getbookByIdTra(int Id){ 
		  MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  if(books.size()>0)
		return books.get(0);
	  else
	  return null;
	  }
	public void editBookTra(Book book) {	  
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String  query="UPDATE trafalgar SET Title =:Title, Author=:Author, Price=:Price, Quantity=:Quantity, RelatedCourses=:RelatedCourses WHERE Id=:Id";
		  parameters.addValue("Id",book.getId());
		  parameters.addValue("Title",book.getTitle());
		  parameters.addValue("Author",book.getAuthor());
		  parameters.addValue("Price",book.getPrice());
		  parameters.addValue("Quantity",book.getQuantity());
		  parameters.addValue("RelatedCourses",book.getRelatedCourses());
		  jdbc.update(query, parameters); 	  
	  }
	public void deleteBookTra(int Id) {	  	  
		   MapSqlParameterSource parameters = new MapSqlParameterSource();  
		   String  query="DELETE FROM trafalgar WHERE Id=:Id";
			  parameters.addValue("Id",Id);
			  jdbc.update(query, parameters);
		  }
	
public ArrayList<Book> searchBox(int id){
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where id=:id";
		  parameters.addValue("id",id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
	public void dummyR() {
		for(int i=1;i <=6;i++) {
			dummyBra(new DummyRecord("Title1","Author1",i+i,i+i+i,"Related Courses1"),
			 new DummyRecord("Title2","Author2",i+i,i+i+i,"Related Courses2"),
			 new DummyRecord("Title3","Author3",i+i,i+i+i,"Related Courses3"),
			 new DummyRecord("Title4","Author4",i+i,i+i+i,"Related Courses4"),
			 new DummyRecord("Title5","Author5",i+i,i+i+i,"Related Courses5"));
		}
	}
	
	public void dummyRhmc() {
		for(int i=1;i <=6;i++) {
			dummyhmc(new DummyRecord("Title1","Author1",i+i,i+i+i,"Related Courses1"),
			 new DummyRecord("Title2","Author2",i+i,i+i+i,"Related Courses2"),
			 new DummyRecord("Title3","Author3",i+i,i+i+i,"Related Courses3"),
			 new DummyRecord("Title4","Author4",i+i,i+i+i,"Related Courses4"),
			 new DummyRecord("Title5","Author5",i+i,i+i+i,"Related Courses5"));
		}
	}
	
	public void dummyRtra() {
		for(int i=1;i <=6;i++) {
			dummytra(new DummyRecord("Title1","Author1",i+i,i+i+i,"Related Courses1"),
			 new DummyRecord("Title2","Author2",i+i,i+i+i,"Related Courses2"),
			 new DummyRecord("Title3","Author3",i+i,i+i+i,"Related Courses3"),
			 new DummyRecord("Title4","Author4",i+i,i+i+i,"Related Courses4"),
			 new DummyRecord("Title5","Author5",i+i,i+i+i,"Related Courses5"));
		}
	}
	
	
	
	public void dummyBra(DummyRecord b1,DummyRecord b2,DummyRecord b3,DummyRecord b4,DummyRecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO davis (Title, Author, Price, Quantity, RelatedCourses)"
					+ " VALUES (:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		  
		  parameters.addValue("Title",b1.getTitle());
		  parameters.addValue("Author",b1.getAuthor());
		  parameters.addValue("Price",b1.getPrice());
		  parameters.addValue("Quantity",b1.getQuantity());
		  parameters.addValue("RelatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("Title",b2.getTitle());
		  parameters.addValue("Author",b2.getAuthor());
		  parameters.addValue("Price",b2.getPrice());
		  parameters.addValue("Quantity",b2.getQuantity());
		  parameters.addValue("RelatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b3.getTitle());
		  parameters.addValue("Author",b3.getAuthor());
		  parameters.addValue("Price",b3.getPrice());
		  parameters.addValue("Quantity",b3.getQuantity());
		  parameters.addValue("RelatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b4.getTitle());
		  parameters.addValue("Author",b4.getAuthor());
		  parameters.addValue("Price",b4.getPrice());
		  parameters.addValue("Quantity",b4.getQuantity());
		  parameters.addValue("RelatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b5.getTitle());
		  parameters.addValue("Author",b5.getAuthor());
		  parameters.addValue("Price",b5.getPrice());
		  parameters.addValue("Quantity",b5.getQuantity());
		  parameters.addValue("RelatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	public void dummyhmc(DummyRecord b1,DummyRecord b2,DummyRecord b3,DummyRecord b4,DummyRecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO hmc (Title, Author, Price, Quantity, RelatedCourses)"
					+ " VALUES (:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		  
		  parameters.addValue("Title",b1.getTitle());
		  parameters.addValue("Author",b1.getAuthor());
		  parameters.addValue("Price",b1.getPrice());
		  parameters.addValue("Quantity",b1.getQuantity());
		  parameters.addValue("RelatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("Title",b2.getTitle());
		  parameters.addValue("Author",b2.getAuthor());
		  parameters.addValue("Price",b2.getPrice());
		  parameters.addValue("Quantity",b2.getQuantity());
		  parameters.addValue("RelatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b3.getTitle());
		  parameters.addValue("Author",b3.getAuthor());
		  parameters.addValue("Price",b3.getPrice());
		  parameters.addValue("Quantity",b3.getQuantity());
		  parameters.addValue("RelatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b4.getTitle());
		  parameters.addValue("Author",b4.getAuthor());
		  parameters.addValue("Price",b4.getPrice());
		  parameters.addValue("Quantity",b4.getQuantity());
		  parameters.addValue("RelatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b5.getTitle());
		  parameters.addValue("Author",b5.getAuthor());
		  parameters.addValue("Price",b5.getPrice());
		  parameters.addValue("Quantity",b5.getQuantity());
		  parameters.addValue("RelatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	public void dummytra(DummyRecord b1,DummyRecord b2,DummyRecord b3,DummyRecord b4,DummyRecord b5) {
		
		  MapSqlParameterSource parameters = new MapSqlParameterSource();		  
		  String query="INSERT INTO trafalgar (Title, Author, Price, Quantity, RelatedCourses)"
					+ " VALUES (:Title, :Author, :Price, :Quantity, :RelatedCourses)";
		  
		  parameters.addValue("Title",b1.getTitle());
		  parameters.addValue("Author",b1.getAuthor());
		  parameters.addValue("Price",b1.getPrice());
		  parameters.addValue("Quantity",b1.getQuantity());
		  parameters.addValue("RelatedCourses",b1.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  
		  parameters.addValue("Title",b2.getTitle());
		  parameters.addValue("Author",b2.getAuthor());
		  parameters.addValue("Price",b2.getPrice());
		  parameters.addValue("Quantity",b2.getQuantity());
		  parameters.addValue("RelatedCourses",b2.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b3.getTitle());
		  parameters.addValue("Author",b3.getAuthor());
		  parameters.addValue("Price",b3.getPrice());
		  parameters.addValue("Quantity",b3.getQuantity());
		  parameters.addValue("RelatedCourses",b3.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b4.getTitle());
		  parameters.addValue("Author",b4.getAuthor());
		  parameters.addValue("Price",b4.getPrice());
		  parameters.addValue("Quantity",b4.getQuantity());
		  parameters.addValue("RelatedCourses",b4.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		  
		  
		  parameters.addValue("Title",b5.getTitle());
		  parameters.addValue("Author",b5.getAuthor());
		  parameters.addValue("Price",b5.getPrice());
		  parameters.addValue("Quantity",b5.getQuantity());
		  parameters.addValue("RelatedCourses",b5.getRelatedCourses());
		  
		  jdbc.update(query, parameters); 	
		
	}
	
	//search 
	public ArrayList<Book> searchId(int Id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchTitle(String Title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where Title=:Title";
		  parameters.addValue("Title",Title);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchAuthor(String Author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where Author=:Author";
		  parameters.addValue("Author",Author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchQuantity(int Quantity){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where Quantity=:Quantity";
		  parameters.addValue("Quantity",Quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchRelatedCourses(String RelatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM davis where RelatedCourses=:RelatedCourses";
		  parameters.addValue("RelatedCourses",RelatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
	//search hmc
	
	public ArrayList<Book> searchIdHmc(int Id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchTitleHmc(String Title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where Title=:Title";
		  parameters.addValue("Title",Title);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchAuthorHmc(String Author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where Author=:Author";
		  parameters.addValue("Author",Author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchQuantityHmc(int Quantity){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where Quantity=:Quantity";
		  parameters.addValue("Quantity",Quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchRelatedCoursesHmc(String RelatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM hmc where RelatedCourses=:RelatedCourses";
		  parameters.addValue("RelatedCourses",RelatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
	//search trafalgar
	
	public ArrayList<Book> searchIdTra(int Id){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where Id=:Id";
		  parameters.addValue("Id",Id);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchTitleTra(String Title){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where Title=:Title";
		  parameters.addValue("Title",Title);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchAuthorTra(String Author){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where Author=:Author";
		  parameters.addValue("Author",Author);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchQuantityTra(int Quantity){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where Quantity=:Quantity";
		  parameters.addValue("Quantity",Quantity);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	public ArrayList<Book> searchRelatedCoursesTra(String RelatedCourses){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		  String  query="SELECT * FROM trafalgar where RelatedCourses=:RelatedCourses";
		  parameters.addValue("RelatedCourses",RelatedCourses);
	  ArrayList<Book> books=(ArrayList<Book>)jdbc.query(query,parameters,new BeanPropertyRowMapper<Book>(Book.class));  
	  return books;
	}
	
}
