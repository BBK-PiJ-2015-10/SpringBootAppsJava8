import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;

public class PalindromeService {
	
	private Logger LOGGER = Logger.getLogger(PalindromeService.class.getName());
	
	public boolean isPalindrome(String word){
		if (word== null || word.isEmpty()){
			return false;
		}
		return isPalindrome(word,0,word.length()-1);
	}
	
	private boolean isPalindrome(String word, int beg, int end){
		char beginning = word.charAt(beg);
		char ending = word.charAt(end);
		String message = "Compare characters of " +word +" on position " +beg +" with value " + beginning + " with character on position"
			+ end +" with value " + ending;			
		LOGGER.log(Level.INFO,"Starting to " +message);
		
		if (! (beginning == ending)){
			return false;
		}
		if (end-beg>1){
			return isPalindrome(word,beg+1,end-1);
		}
		else {
			return true;
		}
		
	}
	
	
	
	

}
