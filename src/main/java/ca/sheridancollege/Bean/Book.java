package ca.sheridancollege.Bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable{
	
	private int Id;
	private String Title;
	private String Author;
	private double Price;
	private int Quantity;
	private String RelatedCourses;
	

}
