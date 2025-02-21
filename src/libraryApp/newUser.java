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
	
// Storing the data into database 
	void storingData() {
		String query = "insert into userDetails(id,name,password) values (1001,'"+getUserid()+"','"+getPassword()+"');";
		try {
			connect.stmt.executeUpdate(query);
			System.out.println("\nRegistration Successful....!\n");
			new userLogin();
		}
		catch(Exception e) {
			System.out.println("Check the Querry...!");
			System.out.println("Error is : "+e.toString());
		}
	}
}
