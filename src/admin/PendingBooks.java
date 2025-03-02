package admin;
import libraryApp.*;

public class PendingBooks extends library {
	

	private String AdminUserId;
	
	public PendingBooks(String AdminUserId){
		setAdminUserId(AdminUserId);
		title("Pending Book Details");
		pendingBookDetail();
	}
	
	void pendingBookDetail(){
		ConnectionManager connect = new ConnectionManager();
		try {
			String Query ="select userId,bookId,bookname,BookStatus from rental where BookStatus=1 ;";
			connect.rs=connect.stmt.executeQuery(Query);
			boolean flag = false;
			int count = 0;
			while(connect.rs.next()) {
				flag = true;
				count++;
				printBook(connect.rs.getString(1),connect.rs.getString(2),connect.rs.getString(3),(Integer.parseInt(connect.rs.getString(4))),count);
			}
			if(!flag) {
				System.out.println("There is no book user purchased..!");
				backPage();
			}	
			else backPage();
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement..!");
			System.out.println("Error is : "+e.toString());
		}
	}
	
	String Username(String userId) {
		ConnectionManager connect = new ConnectionManager();
		String username = "";
		try {
		String userNameQuery="select name from userDetails where id="+userId+";";
		connect.rs=connect.stmt.executeQuery(userNameQuery);
		if(connect.rs.next())
			username=connect.rs.getString("name");
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement..!");
			System.out.println("Error is : "+e.toString());
		}
		return username;
	}
	
	void printBook(String UserId,String BookId,String BookName,int BookStatus,int count) {
		System.out.println(count+". UserId      : "+UserId);
		System.out.println("   User Name   : "+Username(UserId));
		System.out.println("   BookId      : "+BookId);
		System.out.println("   Book Name   : "+BookName);
		if(BookStatus==1) {
		System.out.println("   Book Status : Not Submitted");
		}
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
			System.out.println("");
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
