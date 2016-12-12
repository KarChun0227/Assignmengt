package Model;

import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.Objects;

public class Movie 
{
	public String title;
	public String year;
	public String url;
	public long ID;
	static long counter;
	
	
	public Movie()
	{
	}
	
	public Movie(String title, String year, String url)
	{
		this.title = title;
		this.year = year;
		this.url =url;
		this.ID = counter++;
	}
	
	@Override
	public String toString()
	  {
	    return toStringHelper(this).addValue(title)
	                               .addValue(year)
	                               .addValue(url)
	                               .toString();
	  }
	
	 public boolean equals(final Object obj)
	 {
		if (obj instanceof Movie)
	 {
	 final Movie other = (Movie) obj;
	 	return Objects.equals(title, other.title)
	 			&& Objects.equals(year, other.year)
	 			&& Objects.equals(url, other.url);
	 }
	 else
	 {
		 return false;
	 }
	 }
	
	 @Override
	public int hashCode()  
	  {  
	     return Objects.hash(this.title, this.year, this.url);  
	  }
	
}
