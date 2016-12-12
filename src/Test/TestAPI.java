package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import org.junit.Test;

import Model.Movie;
import Model.Rating;
import Model.User;


public class TestAPI 
{
	private Map<Long,   User>   userIndexT       = new HashMap<>();
	private Map<Long, Movie>   movieIndexT      = new HashMap<>();
	private ArrayList<Rating> ratingIndexT = new ArrayList<>();
	
	Rating rate1 = new Rating(112, 121, 2);
	Rating rate2 = new Rating(23, 34, -3);
	Rating rate3 = new Rating(24, 35,2);
	Rating rate4 = new Rating(112, 24, 3);
	Rating rate5 = new Rating(36, 35, 5);
	
	User homer = new User ("homer", "simpson", "31", "L",  "secret");
	User Karber = new User ("Karber", "Lang", "32", "L",  "Student");
	User barer = new User ("barer", "King", "23", "F",  "Teacher");
	
	Movie movie1 = new Movie ("king of king", "1992", "www.kingofking.com");
	Movie movie2 = new Movie ("worst of king", "1973", "www.worstofking.com");
	Movie movie3 = new Movie ("best of king", "1982", "www.bestofking.com");
	

	
	
	@Test
	public void testUserCreate()
	{
		assertEquals("homer",		homer.firstName);	
		assertEquals("simpson",		homer.lastName);
		assertEquals("31", 			homer.age);
		assertEquals("secret", 		homer.occupation);	
	}
	
	@Test
	public void testMovieCreate()
	{
		assertEquals("king of king",		movie1.title);	
		assertEquals("1992",				movie1.year);
		assertEquals("www.kingofking.com", 	movie1.url);
	}
	

	

	
}
