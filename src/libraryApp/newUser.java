package libraryApp;
import java.sql.*;
public class newUser extends library {

	private String userid;
	private String password;
	
	ConnectionManager connect = new ConnectionManager();
	ResultSet rs = null;
	
	newUser(){
		System.out.println("Register User Details");
		System.out.println("---------------------");
		fetchInput();
	}
	
//	getter and setter method
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	getting input from user 
	void fetchInput() {
		System.out.print("Enter User Id  : ");
		setUserid(sc.next());
		System.out.print("Enter Password : ");
		setPassword(sc.next());
		storingData();
	}
	
//	this method for duplicate entry page continue or exist
	void previous() {
		switch(userInput()) {
		case 1:{
			fetchInput();
			break;
		}
		case 2:{
			new userLogin();
			break;
		}
		default : {
			wrongInput();
			previous();
		}
//		switch end here!
		}
	}
	
// Storing the data into database 
	void storingData() {
		String query = "insert into userDetails(name,password) values ('"+getUserid()+"','"+getPassword()+"');";
		try {
			connect.stmt.executeUpdate(query);
			System.out.println("\nRegistration Successful....!\n");
			new userLogin();
		}
		catch(SQLIntegrityConstraintViolationException e) {
			if(e.toString().contains("Duplicate entry"))
				System.out.println("\nUser name is alraedy Existed...!\n");
			System.out.println("1. Continue");
			System.out.println("2. Exit");
			previous();
		}
		catch(Exception e) {
			System.out.println("Check the Querry...!");
			System.out.println("Error is : "+e.toString());
		}
	}
}
