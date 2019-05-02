//Bansri Shah
//110335850

/**
 * Main driver class which starts running the program by asking user options for home screen
 * @author Bansri
 */
import java.util.*;
public class iCatchUp {
	public static void main (String [] args) throws EmptyStackException, FullStackException, 
	InvalidCommandException {
		Application app = new Application();
		String opt = "";
		boolean map = false;
		boolean saf = false;
		
		Scanner scan = new Scanner(System.in);
		
		try {
		System.out.println("Welcome to the iPhony pocket telegraph simulator. You are on the home screen.");
		System.out.println();
		System.out.println("Home Options:");
		System.out.println("\tS) Safari");
		System.out.println("\tM) Maps");
		System.out.println("\tQ) Quit");
		System.out.print("Please select an option: ");
		app.readCommand(scan);
		}
		
		catch(EmptyStackException e) {
			System.out.println(e.getMessage());
		}
		catch(FullStackException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidCommandException e) {
			System.out.println(e.getMessage());
		}
	}
	}
