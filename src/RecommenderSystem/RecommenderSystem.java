package RecommenderSystem;

import java.util.List;

import Model.Movie;
import Model.Rating;
import Model.User;

public interface RecommenderSystem 
{
	public User addUser(String firstName, String lastName, String age, String gender, String occupation);
	
	public User removeUser(long userID);
	
	public  Movie addMovie(String title, String year, String url);
	
	public Rating addRating(int userID, int movieID, int rating);
	
	public Movie getMovie(int movieID);
	
	public Movie getUserRating(long userID);
	
	public String getUserRecommendations(long userID);
	
	public List<Rating> getTopTenMovie();
	
	public void load() throws Exception;
	
	public void write() throws Exception;

	Movie getMovie(long movieID);
}
