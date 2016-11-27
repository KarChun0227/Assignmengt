package Model;

import java.util.Objects;
import static com.google.common.base.MoreObjects.toStringHelper;

public class User implements Comparable<User>
{
	private String firstName;
	private String lastName;
	private String age;
	private String gender;
	private String occupation;
	private Long ID;
	static Long counter;
	
	public User()
	{
	}
	
	public User(String firstName, String lastName, String age, String gender, String occupation)
	{
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation; 
		this.ID = counter++;
	}
	
	@Override
	 public boolean equals(final Object obj)
	 {
	 if (obj instanceof User)
	 {
	 final User other = (User) obj;
	 return Objects.equals(firstName, other.firstName)
	 && Objects.equals(lastName, other.lastName)
	 && Objects.equals(gender, other.gender)
	 && Objects.equals(age, other.age)
	 && Objects.equals(occupation, other.occupation);
	 }
	 else
	 {
	 return false;
	 }
	 }
	
	@Override
	public String toString()
	  {
	    return toStringHelper(this).addValue(firstName)
	                               .addValue(lastName)
	                               .addValue(gender)
	                               .addValue(age)
	                               .addValue(occupation)
	                               .toString();
	  }
	
	@Override  
	  public int hashCode()  
	  {  
	     return Objects.hashCode(this.lastName, this.firstName, this.gender, this.age, this.occupation);  
	  }  
	
}