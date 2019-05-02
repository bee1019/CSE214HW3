import java.util.Scanner;

//Bansri Shah
//110335850

/**
 * This class creates a google something command object which extends Safari class
 * @author Bansri
 *
 */
public class GoogleSomething extends Safari implements Command{
	protected String query;
	
	/**
	 * Constructor for googlesomething object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public GoogleSomething(Scanner scanner) {
		query = scanner.next();
		query = query + scanner.nextLine();
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
		 return "Google: " + query;
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "F:" + query;
	}
}
