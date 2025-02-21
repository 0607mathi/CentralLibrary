package libraryApp;

public class userInterface extends library {
//	default constructor
	userInterface(String userid){
		String greeting ="Welcome "+userid;
		System.out.println(greeting);
		for(int i=0;i<greeting.length();i++) {
			System.out.print('-');
		}
		System.out.println("");
		String features[]= {"1. My Books","2. Buy Book","3. Rent Book","4. Submit Book","5. Logout","6. Exit"};
		for(String i : features) {
			System.out.println(i);
		}
	}
	
	void userMenu() {
		switch(userInput()) {
		case 1:{
			
			break;
		}
		case 2:{
			break;
		}
		case 3:{
			break;
		}
		case 4:{
			break;
		}
		case 5:{
			break;
		}
		default:{
			wrongInput();
			userMenu();
		}
		}
	}
}
