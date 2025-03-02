package libraryApp;

public class userInterface extends library {
	ConnectionManager connect = new ConnectionManager();
	private String userid ;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
//	default constructor
	public userInterface(String userid){
		this.setUserid(userid);
		String greeting ="Welcome "+userid;
		System.out.println(greeting);
		for(int i=0;i<greeting.length();i++) {
			System.out.print('-');
		}
		System.out.println("");
		String features[]= {"1. My Books","2. Rent Book","3. Submit Book","4. Logout"};
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
			new buyBook(getUserid());
			break;
		}
		case 3:{
			new submitBook(getUserid());
			break;
		}
		case 4:{
			saveData();
			new userLogin();
			break;
		}
		default:{
			wrongInput();
			userMenu();
		}
		}
	}
	
	void saveData() {
		try {
			String Query ="commit";
			connect.stmt.executeUpdate(Query);
			System.out.println("Logout Successfully...!\n");
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement...!");
			System.out.println("Error is : "+e.toString());
		}
	}

}
