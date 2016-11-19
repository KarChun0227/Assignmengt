package RecommenderSystem;

public class Movie 
{
	private String title;
	private int year;
	private String url;
	private int ID;
	
	public Movie()
	{
	}
	
	public Movie(String title, int year, String url)
	{
		this.title = title;
		this.year = year;
		this.url =url;
		this.setID(title.hashCode());
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	
}
