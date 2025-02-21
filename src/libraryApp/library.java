package libraryApp;
import java.util.*;
public class library {

	static Scanner sc = new Scanner(System.in); 
	
//	this method getting input from user
	public static int userInput() {
		System.out.print("\nEnter your input : ");
		int input = sc.nextInt();
		System.out.println("");
		return input;
	}
	
//	If the user enter wrong input means
	public static void wrongInput() {
		System.out.println("Enter proper Input...!");
	}
	public static void main(String[] args) {
		home in = new home();
		in.homepage();
	}

}
