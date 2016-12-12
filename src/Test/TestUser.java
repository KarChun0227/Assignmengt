package Test;

import static org.junit.Assert.*;


import org.junit.Test;

import Model.User;

public class TestUser 
{

		User homer = new User ("homer", "simpson", "31", "L",  "secret");
	
		@Test
		public void testCreate()
		{
			assertEquals("homer",		homer.firstName);	
			assertEquals("simpsin",		homer.lastName);
			assertEquals("23", 			homer.age);
			assertEquals("secret", 		homer.occupation);	
		}
		
//		@Test void testIds()
//		{
//			Set<Long> ids = new HashSet<>();
//			
//			for (User user: userIndex)
//			{
//				ids.add(user.ID);
//			}
//			assertEquals(userIndex.size, ids.size());
//		}
//		

}
