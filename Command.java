//Bansri Shah
//110335850

/**
 * This interface is implemented in individual command classes
 * @author Bansri
 *
 */
public interface Command {
	public boolean validCommand(CommandStack stack) throws EmptyStackException;
	
	public String toString();
	
	public String toShortString();
}
