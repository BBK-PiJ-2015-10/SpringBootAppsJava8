import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeServiceTest {
	
	private PalindromeService palindromeService = new PalindromeService();
	
	@Test
	public void givenAPalindromeWhenIsPalindromeReturnTrue () {
		
		// set-up
		String word = "level";
		
		// execute
		
		boolean result = palindromeService.isPalindrome(word);
		
		// verify

		assertEquals(true,result);
		
	}
	
	@Test
	public void givenANonPalindromeWhenIsPalindromeReturnTrue () {
		
		// set-up
		String word = "levl";
		
		// execute
		
		boolean result = palindromeService.isPalindrome(word);
		
		// verify

		assertEquals(false,result);
		
	}
	

}
