//Bansri Shah
//110335850

/**
 * This class creates a start navigation command object which extends Maps class
 * @author Bansri
 *
 */
public class StartNavigation extends Maps implements Command{
	private String source = "";
	private String destination = "";
	
	/**
	 * Constructor for startnavigation object which takes in scanner object and fills variables
	 * @param scanner
	 */
	public StartNavigation(CommandStack commandStack) throws EmptyStackException {
		if(!commandStack.isEmpty()) {
		if(commandStack.peek() instanceof PlanRoute) {
			source = PlanRoute.source;
			destination = PlanRoute.destination;
		}
		
		else if(commandStack.peek() instanceof FindPlace) {
			destination = FindPlace.destination;
		}
		}
		
		else if(commandStack.isEmpty()) {
			throw new EmptyStackException("No route or destination!");
		}
		
		else if(commandStack.peek() instanceof StartNavigation) {
			throw new EmptyStackException("No route or destination!");
		}
	}
	
	/**
	 * Tells whether command can be added to stack or not based on current state of stack
	 */
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.peek() instanceof FindPlace) {
			return true;
		}
		
		else if(stack.peek() instanceof PlanRoute) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	/**
	 * 
	 */
	public String toString() {
		String temp = "";
		if(source.equals("")) {
			temp = "Navigating to " + destination;
		}
		
		else if(!source.equals("")) {
			temp = "Navigating from " + source + " to " + destination;
		}
		 return temp;
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		String temp = "";
		if(source.equals("")) {
			temp = "N:" + destination;
		}
		
		else if(!source.equals("")) {
			temp = "N:" + source + "-" + destination;
		}
		 return temp;
	}
}
