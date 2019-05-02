//Bansri Shah
//110335850

/**
 * This is the parent class for all Maps commands
 * @author Bansri
 *
 */
public class Maps extends Application implements Command{
	
	/**
	 * Empty constructor creating a maps object
	 */
public Maps() {
		
	}
	
	/**
	 * 
	 */
	public String toString() {
		 return "Maps Home";
	}
	
	/**
	 * Prints stack
	 */
	public String toShortString() {
		return "MapsHome";
	}

	/**
	 * Maps command is always valid by default, required because this class implements Command interface
	 */
	@Override
	public boolean validCommand(CommandStack stack) throws EmptyStackException {
		if(stack.isEmpty()) {
		return true;
		}
		
		return false;
	}
}
