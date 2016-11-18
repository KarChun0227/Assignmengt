
public interface RecommenderSystem 
{
	public String addUser(String firstName, String lastName, int age, char gender, String occupation);
	
	public int removeUser(int userID);
	
	public  String addMovie(String title, int year, String url);
	
	public String addRating(int userID, int movieID, int rating);
	
	public String getMovie(int userID);
	
	public String getUserRating(int userID);
	
	public String getUserRecommendations(int userID);
	
	public String getTopTenMovie();
	
	public void load();
	
	public void write();
}
