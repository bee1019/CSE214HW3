//Bansri Shah
//110335850

/**
 * This is the parent class for all Safari commands
 * @author Bansri
 *
 */
public class Safari extends Application implements Command{
	
	/**
	 * Empty constructor creating a safari object
	 */
	public Safari() {
		
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
		return "SafariHome";
	}

	/**
	 * Safari command is always valid by default, required because this class implements Command interface
	 */
	@Override
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.isEmpty()) {
			return true;
			}
			
			return false;
	}
}
