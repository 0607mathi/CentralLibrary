package admin;
import libraryApp.*;
import java.util.*;
public class GetAllBookDetails extends library {
	Scanner sc = new Scanner(System.in);
	private String AdminUserId;
	public GetAllBookDetails(String AdminUserId ){
		setAdminUserId(AdminUserId);
		title("Central Library Books and Details");
		showAllBook();
	}
	
	void showAllBook(){
		ConnectionManager connect = new ConnectionManager();
		try {
			String Query = "select * from bookDetails";
			connect.rs=connect.stmt.executeQuery(Query);
			System.out.println("");
				int count =0;
			while(connect.rs.next()) {
				count++;
				System.out.println(count+"."+" Book Id : "+connect.rs.getString(1));
				System.out.println("   Name    : "+connect.rs.getString(2));
				System.out.println("   Author  : "+connect.rs.getString(3));
				System.out.println("   Price   : "+connect.rs.getString(4));
				System.out.println("");
			}
			back();
		}
		catch(Exception e) {
			System.out.println("Error in Sql Query...!");
			System.out.println("Erro is : "+e.toString());
		}
	}
	
	void back(){
		System.out.print("Press 0 for Exit...!\n");
		switch(userInput()) {
		case 0:{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			back();
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
