package libraryApp;

import java.sql.*;

public class existUser extends library {
	ConnectionManager connect = new ConnectionManager();
	private String userid;
	private String password;
	
//	constructor
	existUser(){
		System.out.println("Enter your Credintials");
		System.out.println("----------------------");
		fetchInput();
	}
	
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
	
	void fetchInput() {
		System.out.print("Enter User Id  : ");
		setUserid(sc.next());
		System.out.print("Enter Password : ");
		setPassword(sc.next());
	}
	
	boolean validate() {
		String querry = "select name,password from userDetails where name ='"+getUserid()+"';";
		
		try {
			connect.rs = connect.stmt.executeQuery(querry);
			boolean userid = ((connect.rs.getString(1).toString()).equals(getUserid()));
			boolean password  = (connect.rs.getString(2).toString()).equals(getPassword());
			
			if( userid && password){
				System.out.println("Validation Successful...!");
//				stops hear,,,,
			}	
		} catch (SQLException e) {
			
		}
		return true;
	}
}
