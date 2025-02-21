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
		validate();
	}
	
//	if you exist or continue (y/n) : 
	void previous() {
		System.out.print("if you exist or continue (y/n) : ");
		char YorN = sc.next().charAt(0);
		System.out.println("");
		switch(YorN) {
		case 'y':{
			fetchInput();
			break;
		}
		case 'n':{
			new userLogin();
			break;
		}
		default:{
			wrongInput();
		}
		}
	}
	
	void validate() {
		
		try {
			String Query = "select name,password from userDetails where name ='"+getUserid()+"';";
//			System.out.println(Query);
			
			connect.rs = connect.stmt.executeQuery(Query);

			if (connect.rs.next()) {  
				// Move to the first row
//				System.out.println((connect.rs.getString("name")));
//				System.out.println((connect.rs.getString("password")));
				
				boolean userid = (connect.rs.getString("name")).equals(getUserid());
				boolean password = (connect.rs.getString("password")).equals(getPassword());
				
//				System.out.print(userid);
//				System.out.print(password);
				
			     if( userid && password){
			     System.out.println("\nValidation Successful...!\n");
//			     user interface will come here! 
			     new userInterface(getUserid());
			     }
			     else {
			    		System.out.println("\nUserid or Password doesn't match...!\n");
						previous();
			     }
			}
			else {
//				Here is no name match in database
	    		System.out.println("\nUser name Doesn't exist please register...!\n");
//	    		if you exist or continue (y/n) : 
	    		previous();	
	     }
			
		} 
		catch (SQLException e) {
			System.out.print("Error in SQL Query...!");
			System.out.println("Error is : "+e.toString());
		}
	} // validation ends here!
}
