package Model;

public class Rating implements Comparable<Rating>
{
	private long userID;
	private long movieID;
	private int rating;
	

	
	public Rating(int userID, int movieID, int rating)
	{
		this.userID = (long) userID;
		this.movieID = (long) movieID;
		this.rating =rating;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = (long) userID;
	}

	public Long getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = (long) movieID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [userID=" + userID + ", movieID=" + movieID + ", rating=" + rating + "]";
	}
	
	public int compareTo(Rating t2) {
		
		if(this.getMovieID()<t2.getMovieID()) return -1;
		else if(this.getMovieID()>t2.getMovieID()) return 1;
		return 0;
		
		
	}
}
