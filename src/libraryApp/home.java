package libraryApp;

public class home{
	
	void homepage() {
		System.out.println("\t\tWelcome to Central Library");
		System.out.println("\t\t--------------------------");
		System.out.println("1. User Login");
		System.out.println("2. Admin Login");
		
		switch(library.userInput()) {
		case 1:{
//			User Login page
			new userLogin();
			break;
		}
		case 2:{
			
			break;
		}
		default:{
			library.wrongInput();
			homepage();
		}
//		switch end here!
		}
	}
}
