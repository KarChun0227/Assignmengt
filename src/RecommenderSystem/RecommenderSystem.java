package RecommenderSystem;

public interface RecommenderSystem 
{
	public String addUser(String firstName, String lastName, int age, String gender, String occupation);
	
	public String removeUser(int userID);
	
	public  String addMovie(String title, int year, String url);
	
	public String addRating(int userID, int movieID, int rating);
	
	public String getMovie(int movieID);
	
	public String getUserRating(int userID);
	
	public String getUserRecommendations(int userID);
	
	public String getTopTenMovie();
	
	public void load();
	
	public void write() throws Exception;
}
