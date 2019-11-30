package ca.sheridancollege.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DummyRecord {

	
	private String Title;
	private String Author;
	private double Price;
	private int Quantity;
	private String RelatedCourses;
}
