//Bansri Shah
//110335850

/**
 * This class creates a go to bookmark command object which extends Safari class
 * @author Bansri
 */
import java.util.*;
public class GoToBookmark extends Safari implements Command{
	protected String bookmark;
	
	/**
	 * Constructor for gotobookmark object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public GoToBookmark(Scanner scanner) {
		bookmark = scanner.next();
		bookmark = bookmark + scanner.nextLine();
	}
	
	/**
	 * Tells whether command can be added to stack or not based on current state of stack
	 */
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.peek() instanceof Maps) {
			return false;
		}
		
		else if(stack.isEmpty()) {
			return true;
		}
		
		else {
			return true;
		}
	}
	
	/**
	 * 
	 */
	public String toString() {
		 return "Safari Home";
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "F:" + bookmark;
	}
}
