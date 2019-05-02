//Bansri Shah
//110335850

/**
 * This class is the Application class which takes in a scanner object from the driver class 
 * and looks at the first home page commands and determines where to go next.
 * It also acts as the class for remaining input for the program to run.
 * @author Bansri Shah
 */
import java.util.*;
public class Application {
	private CommandStack stack = new CommandStack();
	Scanner scanHere = new Scanner(System.in);
	Scanner temp = new Scanner(System.in);
	
	/**
	 * Empty constructor which creates an application object
	 */
	
	public Application() {
		
	}
	
	/**
	 * This method reads in the command from the driver class
	 * @param scanner
	 * Takes in a scanner object from driver class
	 * @throws EmptyStackException
	 * If stack is empty, exception is thrown
	 * @throws FullStackException
	 * If stack is full, exception is thrown
	 * @throws InvalidCommandException
	 * If incorrect input, exception is thrown
	 */
	
	public void readCommand(Scanner scanner) throws EmptyStackException, 
	FullStackException, InvalidCommandException {
		String opt = scanner.next();
		opt = opt + scanner.nextLine();
		opt = opt.toUpperCase();
		
		if(opt.equals("Q")) {
			System.out.println("Sorry to see you go, tell the iPod I said hi!");
		}
		
		while(opt.equals("Q") == false) {
		if(stack.isEmpty() == true) {
			if(opt.equals("S")) {
				Safari saf = new Safari();
				if(saf.validCommand(stack)) {
					stack.push(saf);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("M")) {
				Maps map = new Maps();
				if(map.validCommand(stack)) {
					stack.push(map);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
		}
		
		else if(opt.equals("F") && stack.peek() instanceof Maps) {
				System.out.println("Please enter a location: ");
				FindPlace fp = new FindPlace(temp);
				if(fp.validCommand(stack)) {
					stack.push(fp);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("P") && stack.peek() instanceof Maps) {
				System.out.println("Please enter a source: ");
				System.out.println("Please enter a destination: ");
				PlanRoute pr = new PlanRoute(temp);
				if(pr.validCommand(stack)) {
					stack.push(pr);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("N") && stack.peek() instanceof Maps) {
				StartNavigation sn = new StartNavigation(stack);
				if(sn.validCommand(stack) == true) {
					stack.push(sn);
					System.out.println(stack.toString());
					System.out.println(stack.getScreenCommand());
				}
				
				else if(sn.validCommand(stack) == false) {
					throw new InvalidCommandException("No route or destination!");
				}
				
				System.out.println();
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
				
				
			}
			
			else if(opt.equals("S") && stack.peek() instanceof Maps) {
				while(!stack.isEmpty()) {
					stack.pop();
				}
				
				Safari saf = new Safari();
				stack.push(saf);
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("B")) {
				goBack();
				
				if(!stack.isEmpty()) {
				if(stack.peek() instanceof Safari) {
					System.out.println(stack.toString());
					System.out.println(stack.getScreenCommand());
					System.out.println();
					System.out.println("Safari Options:");
					System.out.println("\tG) Google Something");
					System.out.println("\tF) Go to a favorite (bookmark)");
					System.out.println("\tL) Follow a link");
					System.out.println("\tH) Home Screen");
					System.out.println("\tS) Switch to Maps");
					System.out.println("\tB) Back");
					System.out.print("Please select an option: ");
					readCommand(scanHere);
				}
				
				else if(stack.peek() instanceof Maps) {
					System.out.println(stack.toString());
					System.out.println(stack.getScreenCommand());
					System.out.println();
					System.out.println("Maps Options:");
					System.out.println("\tF) Find a place");
					System.out.println("\tP) Plan a route");
					System.out.println("\tN) Start Navigation");
					System.out.println("\tH) Home Screen");
					System.out.println("\tS) Switch to Safari");
					System.out.println("\tB) Back");
					System.out.print("Please select an option: ");
					readCommand(scanHere);
				}
				}
				
				else if(stack.isEmpty() == true) {
					System.out.println();
					System.out.println("Home Options:");
					System.out.println("\tS) Safari");
					System.out.println("\tM) Maps");
					System.out.println("\tQ) Quit");
					System.out.print("Please select an option: ");
					readCommand(scanHere);
				}
			}
		
			else if(opt.equals("G") && stack.peek() instanceof Safari) {
				System.out.println("Please enter a query: ");
				GoogleSomething gs = new GoogleSomething(scanner);
				if(gs.validCommand(stack)) {
					stack.push(gs);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tQ) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("F") && stack.peek() instanceof Safari) {
				System.out.println("Please enter bookmark name: ");
				GoToBookmark gtb = new GoToBookmark(scanner);
				if(gtb.validCommand(stack)) {
					stack.push(gtb);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tQ) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("L") && stack.peek() instanceof Safari) {
				System.out.println("Please enter a link: ");
				FollowLink fl = new FollowLink(scanner);
				if(fl.validCommand(stack)) {
					stack.push(fl);
				}
				
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Safari Options:");
				System.out.println("\tG) Google Something");
				System.out.println("\tF) Go to a favorite (bookmark)");
				System.out.println("\tL) Follow a link");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Maps");
				System.out.println("\tQ) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("H")) {
				stack = new CommandStack();
				System.out.println();
				System.out.println("Home Options:");
				System.out.println("\tS) Safari");
				System.out.println("\tM) Maps");
				System.out.println("\tQ) Quit");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
			}
			
			else if(opt.equals("S") && stack.peek() instanceof Safari) {
				while(!stack.isEmpty()) {
					stack.pop();
				}
				
				Maps map = new Maps();
				stack.push(map);
				System.out.println(stack.toString());
				System.out.println(stack.getScreenCommand());
				System.out.println();
				System.out.println("Maps Options:");
				System.out.println("\tF) Find a place");
				System.out.println("\tP) Plan a route");
				System.out.println("\tN) Start Navigation");
				System.out.println("\tH) Home Screen");
				System.out.println("\tS) Switch to Safari");
				System.out.println("\tB) Back");
				System.out.print("Please select an option: ");
				readCommand(scanHere);
				
			}
		}
	}
	
	/**
	 * This method allows for application to go back one screen
	 * @throws EmptyStackException
	 */
	public void goBack() throws EmptyStackException {
		if(stack.isEmpty()) {
			throw new EmptyStackException("No command has been entered. Cannot go back!\n");
		}
		
		else {
			stack.pop();
		}
	}
	
	/**
	 * This method prints the current screen
	 * @return
	 * returns current screen
	 * @throws EmptyStackException
	 * exception ignored
	 */
	public String currentScreen() throws EmptyStackException {
		return stack.getScreenCommand();
	}
	
	/**
	 * 
	 */
	public String toString() {
		return stack.toString();
	}
}
