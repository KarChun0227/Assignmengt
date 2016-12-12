package RecommenderSystem;

import java.util.Scanner;

public class Main 
{
	static RSystem Rs = new RSystem();
	private static Scanner sc = new Scanner(System.in);
	static Main M = new Main();
	
	public static void main(String[] args) throws Exception
	{	
		Rs.loadMovieFile();
		Rs.loadRatingFile();
		Rs.loadUserFile();
//		Rs.write();
//		Rs.load();
		M.run();
		
	}
	
	private int mainMenu()
    {
    	System.out.println("1) Add User");
    	System.out.println("2) Add Movie");
    	System.out.println("3) Add Rating");
    	System.out.println("4) Remove User");
    	System.out.println("5) Get Movie");
    	System.out.println("6) Get User Rating");
    	System.out.println("7) Get Top 10 Movie");
    	System.out.println("8) Get Recommendation");
    	System.out.println("9) Exit ");
    	int option = sc.nextInt();
    	sc.nextLine();
    	return option;
    }
	
	public void run()
    {
    	System.out.println("Choose Option");
    	int option = mainMenu();
    	while(option != 0)
    	{
    		switch(option)
    		{
    		case 1:
    			addUser();
    			break;
    		case 2:
    			addMovie();
    			break;
    		case 3:
    			addRating();
    			break;
    		case 4:
    			removeUser();
    			break;
    		case 5:
    			getMovie();
    			break;
    		case 6:
    			getUserRating();
    			break;
    		case 7:
    			Rs.getTopTenMovie();
    			break;
    		case 8:
	
    			break;
    		case 9:
	
    			break;
    		}
    	}
    }
	
	public void addUser()
    {
    	System.out.println("User Adding Interface");
    	System.out.println("First Name: ");
    	String firstName = sc.nextLine();
    	System.out.println("Last Name: ");
    	String lastName = sc.nextLine();
    	System.out.println("Age: ");
    	String age = sc.nextLine();
    	System.out.println("Gender: ");
    	String gender = sc.nextLine();
    	System.out.println("Occupation: ");
    	String occupation = sc.nextLine();
    	System.out.println(Rs.addUser(firstName, lastName, age, gender, occupation));
    	run();
    }
	
	public void addMovie()
    {
    	System.out.println("Movie Adding Interface");
    	System.out.println("Title: ");
    	String title = sc.nextLine();
    	System.out.println("Year: ");
    	String year = sc.nextLine();
    	System.out.println("URL: ");
    	String url = sc.nextLine();
    	System.out.println(Rs.addMovie(title, year, url));
    	run();
    }
	
	public void addRating()
    {
    	System.out.println("Movie Adding Interface");
    	System.out.println("User ID: ");
    	int userID = sc.nextInt();
    	System.out.println("Movie ID: ");
    	int movieID = sc.nextInt();
    	System.out.println("Rating: ");
    	int rating = sc.nextInt();
    	System.out.println(Rs.addRating(userID, movieID, rating));
    	run();
    }
	
    public void removeUser()
    {
    	int userID = 0;
    	boolean goodinput = false;
    	do {
    		try{
    			System.out.print("Remove ID: ");
    			userID = sc.nextInt();
    			goodinput = true;
    			
    		}
    		 catch (Exception e) {
    			    sc.nextLine(); 
    			    System.err.println("String expected - you entered text");
    			    }
    			    } while (!goodinput);   	
    	System.out.print(Rs.removeUser(userID));
    	run();
    }
    
    public void getMovie()
    {
    	long MovieID = 0;
    	boolean goodinput = false;
    	do {
    		try{
    			System.out.print("Movie ID: ");
    			MovieID = sc.nextInt();
    			goodinput = true;
    			
    		}
    		 catch (Exception e) {
    			    sc.nextLine(); 
    			    System.err.println("String expected - you entered text");
    			    }
    			    } while (!goodinput);   	
    	System.out.print(Rs.getMovie(MovieID));
    	run();
    }
    
    public void getUserRating()
    {
    	long userID = 0;
    	boolean goodinput = false;
    	do {
    		try{
    			System.out.print("User ID: ");
    			userID = sc.nextInt();
    			goodinput = true;
    		}
    		 catch (Exception e) {
    			    sc.nextLine(); 
    			    System.err.println("String expected - you entered text");
    			    }
    			    } while (!goodinput);   	
    	System.out.print(Rs.getUserRating(userID));
    	run();
    }
    

}
