import java.util.*;

//Bansri Shah
//110335850

/**
 * This class creates a find place command object which extends Maps class
 * @author Bansri
 *
 */
public class FindPlace extends Maps implements Command{
	protected static String destination;
	
	/**
	 * Constructor for findplace object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public FindPlace(Scanner scanner) {
		destination = scanner.next();
		destination = destination + scanner.nextLine();
	}
	
	/**
	 * Tells whether command can be added to stack or not based on current state of stack
	 */
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.peek() instanceof Safari) {
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
		 return "Showing results for " + destination;
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "F:" + destination;
	}
	
}
