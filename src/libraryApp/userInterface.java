package libraryApp;

public class userInterface extends library {
	
	private String userid ;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
//	default constructor
	userInterface(String userid){
		this.setUserid(userid);
		String greeting ="Welcome "+userid;
		System.out.println(greeting);
		for(int i=0;i<greeting.length();i++) {
			System.out.print('-');
		}
		System.out.println("");
		String features[]= {"1. My Books","2. Buy Book","3. Rent Book","4. Submit Book","5. Logout"};
		for(String i : features) {
			System.out.println(i);
		}
		userMenu();
	}
	
	void userMenu() {
		switch(userInput()) {
		case 1:{
			new myBook(getUserid());
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
			new userLogin();
			break;
		}
		default:{
			wrongInput();
			userMenu();
		}
		}
	}

}
