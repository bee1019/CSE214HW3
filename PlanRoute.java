//Bansri Shah
//110335850

/**
 * This class creates a plan route command object which extends Maps class
 * @author Bansri
 *
 */
import java.util.*;
public class PlanRoute extends Maps implements Command{
	protected static String source;
	protected static String destination;
	
	/**
	 * Constructor for planroute object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public PlanRoute(Scanner scanner) {
		source = scanner.next();
		source = source + " " + scanner.nextLine();
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
		 return "Planning route from " + source + " to " + destination;
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "P:" + source + "-" + destination;
	}
}
