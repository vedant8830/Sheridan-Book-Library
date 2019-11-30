package ca.sheridancollege.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.Bean.Book;
import ca.sheridancollege.Database.DatabaseAccess;

@Controller
public class BookController {
	
	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String goBooks(){
		return"HomePage.html";
	}
	
	@GetMapping("/add")
	public String page() {
		return"add.html";
	}
	
	@GetMapping("/davis")
	public String Davis() {
		return "davis.html";
	}
	
	@GetMapping("/addBook")
	public String addBook(
			@RequestParam String Title,
			@RequestParam String Author,
			@RequestParam double Price,
			@RequestParam int Quantity,
			@RequestParam String RelatedCourses
			) {
		Book b = new Book();
		b.setTitle(Title);
		b.setAuthor(Author);
		b.setPrice(Price);
		b.setQuantity(Quantity);
		b.setRelatedCourses(RelatedCourses);
		da.addBook(b);
		return"add.html";
	}
	
	@GetMapping("/view")
	public String view(Model model) {
		model.addAttribute("contactNum", da.getBooks());
		model.addAttribute("contactHmc", da.getBooksHmc());
		model.addAttribute("contactTra", da.getBooksTra()); 
		return "view.html";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable int id,Model model) {
		  
		  Book c= da.getbookById(id);
		  
		  model.addAttribute("contactNum",c);
		  return "editInBra.html";
	}
	@GetMapping("/modifyAtBra")
	public String editBookByID(@RequestParam int Id, @RequestParam String Title, @RequestParam String Author, 
			@RequestParam double Price, @RequestParam int Quantity, @RequestParam String RelatedCourses, Model model){
		
		  Book b= new Book(Id, Title, Author, Price, Quantity, RelatedCourses);
	      da.editBook(b);
	  	model.addAttribute("contactNum", da.getBooks());
		model.addAttribute("contactHmc", da.getBooksHmc());
		model.addAttribute("contactTra", da.getBooksTra());  
	   return "View.html";
	}
	@GetMapping("/delete/{id}") // this is a path variable
	public String deleteBook(@PathVariable int id, Model model) {
	 
	      da.deleteBook(id);
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactTra", da.getBooksTra()); 
		  return "View.html";
	}
	@GetMapping("/dummy")
	public String generateD(Model model) {
	da.dummyR();
	      model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactTra", da.getBooksTra());
 
		return "dummyBra.html";
	}
	@GetMapping("/search")
	public String Search() {
		return "search.html";
	}
	@GetMapping("/searchId")
	public String goSearch(@RequestParam int Id, Model model) {
		model.addAttribute("search", da.searchId(Id));
		return "search.html";
	}
	@GetMapping("/searchTitle")
	public String goTitle(@RequestParam String Title, Model model) {
		model.addAttribute("search", da.searchTitle(Title));
		return "search.html";
	}
	@GetMapping("/searchAuthor")
	public String goAuthor(@RequestParam String Author, Model model) {
		model.addAttribute("search", da.searchAuthor(Author));
		return "search.html";
	}
	@GetMapping("/searchQuantity")
	public String goQuantity(@RequestParam int Quantity, Model model) {
		model.addAttribute("search", da.searchQuantity(Quantity));
		return "search.html";
	}
	@GetMapping("/searchRelatedCourses")
	public String goRelatedCourses(@RequestParam String RelatedCourses, Model model) {
		model.addAttribute("search", da.searchRelatedCourses(RelatedCourses));
		return "search.html";
	}
	
	
	//hmc
	
	@GetMapping("/hmc")
	public String Hmc() {
		return "hmc.html";
	}
	
	@GetMapping("/addHmc")
	public String pageHmc() {
		return"addHmc.html";
	}
	
	@GetMapping("/addBookHmc")
	public String addBookHmc(
			@RequestParam String Title,
			@RequestParam String Author,
			@RequestParam double Price,
			@RequestParam int Quantity,
			@RequestParam String RelatedCourses
			) {
		Book b = new Book();
		b.setTitle(Title);
		b.setAuthor(Author);
		b.setPrice(Price);
		b.setQuantity(Quantity);
		b.setRelatedCourses(RelatedCourses);
		da.addBookHmc(b);
		return"addHmc.html";
	}
	@GetMapping("/viewHmc")
	public String viewHmc(Model model) {
		model.addAttribute("contactNum", da.getBooks());
		model.addAttribute("contactHmc", da.getBooksHmc());
		model.addAttribute("contactTra", da.getBooksTra());  
		return "view.html";
	}
	@GetMapping("/editHmc/{id}")
	public String editBookHmc(@PathVariable int id,Model model) {
		  
		  Book c= da.getbookByIdHmc(id);
		       
	      model.addAttribute("contactHmc", c);
	     
		  
		  return "editInHmc.html";
	}
	@GetMapping("/modifyAtHmc")
	public String editBookByIDHmc(@RequestParam int Id, @RequestParam String Title, @RequestParam String Author, 
			@RequestParam double Price, @RequestParam int Quantity, @RequestParam String RelatedCourses, Model model){
		
		  Book b= new Book(Id, Title, Author, Price, Quantity, RelatedCourses);
	      da.editBookHmc(b);
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactTra", da.getBooksTra()); 
	   return "View.html";
	}
	@GetMapping("/deleteHmc/{id}") // this is a path variable
	public String deleteBookHmc(@PathVariable int id, Model model) {
	 
	      da.deleteBookHmc(id);
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactTra", da.getBooksTra()); 
		  return "View.html";
	}
	@GetMapping("/dummyHmc")
	public String generateDhmc(Model model) {
	da.dummyRhmc();
	   model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactTra", da.getBooksTra());
 
		return "dummyHmc.html";
	}
	@GetMapping("/searchHmc")
	public String SearchHmc() {
		return "searchHmc.html";
	}
	@GetMapping("/searchIdHmc")
	public String goSearchHmc(@RequestParam int Id, Model model) {
		model.addAttribute("search", da.searchIdHmc(Id));
		return "searchHmc.html";
	}
	@GetMapping("/searchTitleHmc")
	public String goTitleHmc(@RequestParam String Title, Model model) {
		model.addAttribute("search", da.searchTitleHmc(Title));
		return "searchHmc.html";
	}
	@GetMapping("/searchAuthorHmc")
	public String goAuthorHmc(@RequestParam String Author, Model model) {
		model.addAttribute("search", da.searchAuthorHmc(Author));
		return "searchHmc.html";
	}
	@GetMapping("/searchQuantityHmc")
	public String goQuantityHmc(@RequestParam int Quantity, Model model) {
		model.addAttribute("search", da.searchQuantityHmc(Quantity));
		return "searchHmc.html";
	}
	@GetMapping("/searchRelatedCoursesHmc")
	public String goRelatedCoursesHmc(@RequestParam String RelatedCourses, Model model) {
		model.addAttribute("search", da.searchRelatedCoursesHmc(RelatedCourses));
		return "searchHmc.html";
	}
	
	//trafalgar
	
	
	@GetMapping("/trafalgar")
	public String Trafalgar() {
		return "trafalgar.html";
	}
	@GetMapping("/addTra")
	public String pageTra() {
		return"addTra.html";
	}
	
	@GetMapping("/addBookTra")
	public String addBookTra(
			@RequestParam String Title,
			@RequestParam String Author,
			@RequestParam double Price,
			@RequestParam int Quantity,
			@RequestParam String RelatedCourses
			) {
		Book b = new Book();
		b.setTitle(Title);
		b.setAuthor(Author);
		b.setPrice(Price);
		b.setQuantity(Quantity);
		b.setRelatedCourses(RelatedCourses);
		da.addBookTra(b);
		return"addTra.html";
	}
	@GetMapping("/viewTra")
	public String viewTra(Model model) {
		model.addAttribute("contactNum", da.getBooks());
		model.addAttribute("contactHmc", da.getBooksHmc());
		model.addAttribute("contactTra", da.getBooksTra()); 
		return "view.html";
	}
	
	@GetMapping("/editTra/{id}")
	public String editBookTra(@PathVariable int id,Model model) {
		  
		  Book c= da.getbookByIdTra(id);
		  
		  model.addAttribute("contactTra",c);
		  return "editInTra.html";
	}
	@GetMapping("/modifyAtTra")
	public String editBookByIDTra(@RequestParam int Id, @RequestParam String Title, @RequestParam String Author, 
			@RequestParam double Price, @RequestParam int Quantity, @RequestParam String RelatedCourses, Model model){
		
		  Book b= new Book(Id, Title, Author, Price, Quantity, RelatedCourses);
	      da.editBookTra(b);
	  	model.addAttribute("contactNum", da.getBooks());
		model.addAttribute("contactHmc", da.getBooksHmc());
		model.addAttribute("contactTra", da.getBooksTra()); 
	   return "View.html";
	}
	@GetMapping("/deleteTra/{id}") // this is a path variable
	public String deleteBookTra(@PathVariable int id, Model model) {
 
	      da.deleteBookTra(id);
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactNum", da.getBooks());
	      model.addAttribute("contactTra", da.getBooksTra()); 
		  return "View.html";
	}

	@GetMapping("dummyTra")
	public String generateDtra(Model model) {
	da.dummyRtra();
	   model.addAttribute("contactNum",da.getBooks());
	      model.addAttribute("contactHmc", da.getBooksHmc());
	      model.addAttribute("contactTra", da.getBooksTra());
 
		return "dummyTra.html";
	}
	@GetMapping("/searchTra")
	public String SearchTra() {
		return "searchTra.html";
	}
	@GetMapping("/searchIdTra")
	public String goSearchTra(@RequestParam int Id, Model model) {
		model.addAttribute("search", da.searchIdTra(Id));
		return "searchTra.html";
	}
	@GetMapping("/searchTitleTra")
	public String goTitleTra(@RequestParam String Title, Model model) {
		model.addAttribute("search", da.searchTitleTra(Title));
		return "searchTra.html";
	}
	@GetMapping("/searchAuthorTra")
	public String goAuthorTra(@RequestParam String Author, Model model) {
		model.addAttribute("search", da.searchAuthorTra(Author));
		return "searchTra.html";
	}
	@GetMapping("/searchQuantityTra")
	public String goQuantityTra(@RequestParam int Quantity, Model model) {
		model.addAttribute("search", da.searchQuantityTra(Quantity));
		return "searchTra.html";
	}
	@GetMapping("/searchRelatedCoursesTra")
	public String goRelatedCoursesTra(@RequestParam String RelatedCourses, Model model) {
		model.addAttribute("search", da.searchRelatedCoursesTra(RelatedCourses));
		return "searchTra.html";
	}
	
	
}
