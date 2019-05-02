//Bansri Shah
//110335850
import java.util.*;

/**
 * This class creates a follow link command object which extends Safari class
 * @author Bansri
 *
 */
public class FollowLink extends Safari implements Command{
	protected String link;
	
	/**
	 * Constructor for followlink object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public FollowLink(Scanner scanner) {
		link = scanner.next();
		link = link + scanner.nextLine();
	}
	
	/**
	 * Tells whether command can be added to stack or not based on current state of stack
	 */
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.peek() instanceof Maps) {
			return false;
		}
		
		else if(stack.isEmpty()) {
			return false;
		}
		
		else {
			return true;
		}
	}
	
	/**
	 * 
	 */
	public String toString() {
		 return link;
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "F:" + link;
	}
}
