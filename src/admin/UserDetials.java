package admin;
import libraryApp.*;
public class UserDetials extends library {

	private String AdminUserId;
	public UserDetials(String AdminUserId) {
		setAdminUserId(AdminUserId);
		title("User Details");
		getDetails();
	}
	
	void getDetails(){
		ConnectionManager connect = new ConnectionManager();
		try {
			String Query ="select id,name from userDetails;";
			connect.rs=connect.stmt.executeQuery(Query);
			boolean flag = false;
			int count = 0;
			while(connect.rs.next()) {
				flag = true;
				count++;
				printUser(connect.rs.getString(1),connect.rs.getString(2),count);
			}
			if(!flag) {
				System.out.println("There is no user here..!");
				backPage();
			}	
			else backPage();
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement..!");
			System.out.println("Error is : "+e.toString());
		}
	}
	
	
	void printUser(String UserId,String UserName,int count) {
		System.out.println(count+". UserId      : "+UserId);
		System.out.println("   User Name   : "+UserName);
		System.out.println("");
	}
	
	void backPage() {
		System.out.print("Press 0 back to Previous Page..!\n");
		switch(userInput()) {
		case 0:{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			backPage();
		}
		}
	}

	public String getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}

}
