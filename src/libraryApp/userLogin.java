package libraryApp;

public class userLogin extends library {
	public userLogin() {
		System.out.println("User Login");
		System.out.println("----------");
		System.out.println("1. Exist User");
		System.out.println("2. New User");
		userlogin();
	}
	public void userlogin() {
		switch(userInput()) {
		case 1:{
			
			break;
		}
		case 2:{
			new newUser();
			break;
		}
		default :{
			wrongInput();
			userlogin();
		}
//		end here!
		}
	}
}
