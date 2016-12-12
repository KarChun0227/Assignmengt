package RecommenderSystem;

import java.io.*;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import Model.Movie;
import Model.Rating;
import Model.User;
import Serializer.XMLSerliaizer;

public class RSystem implements RecommenderSystem 
{
	File datastore = new File("datastore2.xml");
	XMLSerliaizer XMLS = new XMLSerliaizer(datastore);

	private Map<Long,   User>   userIndex       = new HashMap<>();
	private Map<Long, Movie>   movieIndex      = new HashMap<>();
	private ArrayList<Rating> ratingIndex = new ArrayList<>();
	
	 public  void loadUserFile() 
	  {
		 File usersFile = new File("../Assignment2/src/data/users.dat");  
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = "[|]";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);

		        if (userTokens.length == 7)
		        {
//		        	Long ID = Long.parseLong(userTokens[0]);
		        	String firstName = userTokens[1];
		        	String lastName = userTokens[2];
		        	String age = userTokens[3];
		        	String gender = userTokens[4];
		        	String occupation = userTokens[5];
//		        	int zipcode = Integer.parseInt(userTokens[6]);
		        	this.addUser(firstName, lastName, age, gender, occupation);
		        
		        }
			}
			
	      } catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	      //test
//	      for(User x : userIndex.values())
//	    	  System.out.println(x);
	  }
	 
	 public  void loadMovieFile() 
	  {
		 File usersFile = new File("../Assignment2/src/data/items.dat");
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = "[|]";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);
		        	String title = userTokens[1];
		        	String year = userTokens[2];
		        	String url = userTokens[3];
		        	this.addMovie(title, year, url);
			}
			
	      } catch (FileNotFoundException e) 
	      {
				e.printStackTrace();
			}
	      
	      //test
//	      for(Movie x : movieIndex.values())
//	    	  System.out.println(x);
	  }
	 
	 public  void loadRatingFile() 
	  {
		 File usersFile = new File("../Assignment2/src/data/ratings.dat");
	      Scanner In;
	      try {
			In = new Scanner(usersFile);
			String delims = "[|]";			
			while (In.hasNextLine()) 
			{
				String userDetails = In.nextLine();
		        String[] userTokens = userDetails.split(delims);

		        if (userTokens.length == 4)
		        {
		        	int title = Integer.parseInt(userTokens[0]);
		        	int year = Integer.parseInt(userTokens[1]);
		        	int url = Integer.parseInt(userTokens[2]);
		        	this.addRating(title, year, url);
		        
		        }
			}
			
	      } catch (FileNotFoundException e) 
	      {
				e.printStackTrace();
			}
	      //test
//	      for(Rating x : ratingIndex)
//	    	  System.out.println(x);
	  }
	
	 
	
	public User addUser(String firstName, String lastName, String age, String gender, String occupation) 
	{
		User user = new User (firstName, lastName, age, gender, occupation);
	    userIndex.put(user.ID, user);
	    return user;
	}

	@Override
	public User removeUser(long userID) 
	{
		long key = userID;
		int low = 0;
		int hight = userIndex.size() - 1;
		while(hight >= low)
		{
			int middle = (hight + low)/2;
			if (userIndex.get(middle).ID == key)
			{
				userIndex.remove(key);
				System.out.println("User removed");
			}
			if(userIndex.get(middle).ID < key)
			{
				hight = middle - 1;
			}
			if(userIndex.get(middle).ID > key)
			{
				low = middle + 1;
			}
		}
		
		return null;
		
	}

	@Override
	public Movie addMovie(String title, String year, String url) 
	{
		Movie movie = new Movie (title, year, url);
	    movieIndex.put(movie.ID, movie);
	    return movie;
	}

	@Override
	public Rating addRating(int userID, int movieID, int rating) 
	{
		Rating rate = new Rating(userID, movieID, rating);
		ratingIndex.add(rate);	
		return rate;
	}

	@Override
	public Movie getMovie(long movieID) 
	{
		return  movieIndex.get(movieID);
	}

	@Override
	public Movie getUserRating(long userID) 
	{
		ArrayList<Long> Movieid = new ArrayList<>() ;
		for (int j = 0; j < ratingIndex.size(); j++)
		{
			if(ratingIndex.get(j).getMovieID().equals(userID));
			{
			Movieid.add(ratingIndex.get(j).getMovieID());
			}
		}
		for(int i = 0; i < Movieid.size(); i++)
		{
			return movieIndex.get(Movieid.get(i));	
		}
		return null;
	}

	@Override
	public String getUserRecommendations(long userID) 
	{
		
		return null;
	}

	@Override
	public List<Rating> getTopTenMovie() 
	{
		ArrayList<Rating> rating = new ArrayList<>();
		for(Rating R: ratingIndex)
		{
			if(rating.contains(R.getMovieID()))
			{
				for (Rating X: rating)
				{
					if(X.getMovieID().equals(R.getMovieID()))
					{
						X.setRating(R.getRating() + X.getRating());
					}
				}
			}
			else
			{
				rating.add(R);
			}
		}
		rating.sort((a,b)-> { return b.getRating()-a.getRating(); });
		return rating.subList(0, 9);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load() throws Exception 
	{
		XMLS.read();
		ratingIndex = (ArrayList<Rating>) 			XMLS.pop();
		movieIndex = (Map<Long, Movie>) 			XMLS.pop();
		userIndex = (Map<Long, User>) 				XMLS.pop();
		User.counter = (Long) 						XMLS.pop();
		System.out.println("x");
		for(User x : userIndex.values())
	    	  System.out.println(x);
	  
	}

	@Override
	public void write() throws Exception 
	{
		XMLS.push(User.counter);
		XMLS.push(userIndex);
		XMLS.push(movieIndex);
		XMLS.push(ratingIndex);
		XMLS.write();
	
	}
}



