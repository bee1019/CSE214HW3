//Bansri Shah
//110335850

/**
 * This class creates a stack object for commands and is extended by using an array
 * @author Bansri Shah
 */
import java.util.*;
public class CommandStack {
	private Command [] comArr;
	private int top;
	private int capacity = 1000;
	
	/**
	 * Constructor creating an empty array stack
	 */
	public CommandStack() {
		top = -1;
		comArr = new Command[capacity];
	}
	
	/**
	 * This method pushes a command onto top of stack
	 * @param command
	 * Takes in a command object
	 * @throws FullStackException
	 * If stack is full, exception thrown
	 * @throws InvalidCommandException
	 * If command is null or non existent, exception is thrown
	 * @throws EmptyStackException
	 * If stack is empty, exception is thrown
	 */
	
	public void push(Command command) throws FullStackException, InvalidCommandException, EmptyStackException{
		if(top == capacity -1) {
			throw new FullStackException("Command cannot be added. Stack is full.\n");
		}
		
		else if(command.validCommand(this) == false) {
			throw new InvalidCommandException("Command cannot be done at this time.");
		}
		
		else {
			top++;
			comArr[top] = command;
		}
	}
	
	/**
	 * This method removes a command from top of stack
	 * @return
	 * returns the removed command
	 * @throws EmptyStackException
	 * If stack is empty, exception is thrown
	 */
	public Command pop() throws EmptyStackException{
		Command temp;
		
		if(top == -1) {
			throw new EmptyStackException("Stack is empty.\n");
		}
		
		else {
			temp = comArr[top];
			top--;
			return temp;
		}
	}
	
	/**
	 * This method tells us what the object at top of stack is
	 * @return
	 * returns the object at top of stack
	 * @throws EmptyStackException
	 * If stack is empty, exception is thrown
	 */
	public Command peek() throws EmptyStackException{
		Command temp;
		
		if(top == -1) {
			throw new EmptyStackException("Stack is empty.");
		}
		
		else {
			temp = comArr[top];
			return temp;
		}
	}
	
	/**
	 * This method tells if stack is empty
	 * @return
	 * returns boolean value, true or false
	 */
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	/**
	 * This method prints the current screen
	 * @return
	 * returns current screen
	 * @throws EmptyStackException
	 * exception ignored
	 */
	public String getScreenCommand() throws EmptyStackException {
		return "Current Screen: " + peek().toString();
	}
	
	/**
	 * 
	 */
	public String toString() {
		String commands = "[Home";
		if(!isEmpty()) {
		for(int i = 0; i <= top; i++) {
			commands = commands + "->" + comArr[i].toShortString();
		}
		}
		return "Stack Debug:\n" + commands;
	}
}
