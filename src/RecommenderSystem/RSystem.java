package RecommenderSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class RSystem implements RecommenderSystem {

	static ArrayList<User> allUser = new ArrayList<>();
	static ArrayList<Movie> allMovie = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	
	@Override
	public String addUser(String firstName, String lastName, int age, String gender, String occupation) 
	{
		System.out.println("First Name: ");
		firstName = sc.next();
		System.out.println("Last Name: ");
		lastName = sc.next();
		System.out.println("Age: ");
		age = sc.nextInt();
		System.out.println("Gender(L or F): " );
		gender = sc.next();
		System.out.println("Occupation: ");
		occupation = sc.next();
		User user = new User(firstName, lastName, age, gender, occupation);
		allUser.add(user);
		return (firstName + " " + lastName + " are add!");
	}

	@Override
	public String removeUser(int userID) 
	{
		int key = userID;
		int low = 0;
		int hight = allUser.size() - 1;
		while(hight >= low)
		{
			int middle = (hight + low)/2;
			if (allUser.get(middle).getID() == key)
			{
				allUser.remove(middle);
				System.out.println("User removed");
			}
			if(allUser.get(middle).getID() < key)
			{
				hight = middle - 1;
			}
			if(allUser.get(middle).getID() > key)
			{
				low = middle + 1;
			}
		}
		
		return (key + " doesn't exist");
		
//		for(User U : allUser)
//		{
//			if (U.getID() == userID);
//			{
//				allUser.remove(U);
//			}
//		}
	}

	@Override
	public String addMovie(String title, int year, String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addRating(int userID, int movieID, int rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMovie(int movieID) 
	{
		String name = null;
		for(Movie M : allMovie)
		{
			if(M.getID() == movieID);
			{
				name = M.getTitle();
			}
		}
		return name;
	}

	@Override
	public String getUserRating(int userID) 
	{
		
		return null;
	}

	@Override
	public String getUserRecommendations(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTopTenMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

}
