package libraryApp;

public class userLogin extends library {
	public userLogin() {
		System.out.println("User Login");
		System.out.println("----------");
		System.out.println("1. Exist User");
		System.out.println("2. New User");
		System.out.println("3. Exit");
		userlogin();
	}
	public void userlogin() {
		switch(userInput()) {
		case 1:{
//			exist user
			new existUser();
			break;
		}
		case 2:{
//			new user
			new newUser();
			break;
		}
		case 3:{
			new home().homepage();
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
