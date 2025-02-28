package admin;
import libraryApp.*;
import java.util.*;

public class AdminLogin extends library {
	ConnectionManager connect = new ConnectionManager();
	static Scanner sc = new Scanner(System.in);
	
	private String adminId;
	private String password;
	
	public AdminLogin(){
		title("Admin login");
		adminLogin();
	}
//	getting input from admin and validate the details
	void adminLogin() {
		System.out.print("Enter Admin User Id  : ");
		setAdminId(sc.next());
		System.out.print("Enter Admin Password : ");
		  setPassword(sc.next());
		  validate();
	}
	
//	validation method
	void validate() {
		try {
			String Query = "select Username,password from Admin where Username='"+getAdminId()+"' and password='"+getPassword()+"';";
			connect.rs = connect.stmt.executeQuery(Query);
			if(connect.rs.next()) {
				
//				debugging
//				System.out.println(connect.rs.getString("Username"));
//				System.out.println(connect.rs.getString("password"));
				
				if((connect.rs.getString("Username").equals(getAdminId())) && (connect.rs.getString("password").equals(getPassword()))) {
					System.out.println("\nValidation Successfull....!");
//					goes to Admin Interface
//					System.out.println("-----");
					new AdminInterface(getAdminId());
				}
				else {
					System.out.println("\nUsername or password is incorrect...!");
					previous();
				}
			}
			else {
				System.out.println("\nThis User ID is doesn't exist...!");
//				ask continue or previous page
				previous();
			}
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement");
			System.out.println("Error is : "+e.toString());
		}
	}
	
//	previous page
	void previous() {
		System.out.print("\nIf you want to Continue or Previous page (y/n) : ");
		char input = sc.next().charAt(0);
		System.out.println("");
		switch(input) {
		case 'y':{
			adminLogin();
			break;
		}
		case 'n':{
			new home().homepage();
			break;
		}
		default:{
			wrongInput();
			previous();
		}
		}
	}

//	getter setter function for the private states
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
