package libraryApp;
import admin.*;
public class home extends library{
	
	public void homepage()  {
		title("Welcome to Central Library");
		System.out.println("1. User Login");
		System.out.println("2. Admin Login");
		
		switch(userInput()) {
		case 1:{
//			User Login page
			new userLogin();
			break;
		}
		case 2:{
			new AdminLogin();
			break;
		}
		default:{
			wrongInput();
			homepage();
		}
//		switch end here!
		}
	}
}
