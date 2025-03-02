package admin;
import libraryApp.*;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
public class RemoveBook extends library {
	Scanner sc = new Scanner(System.in);
	ConnectionManager connect = new ConnectionManager(); 
	private String AdminUserId;
	private String BookId; 
	
	public RemoveBook(String AdminUserId){
		setAdminUserId(AdminUserId);
		title("Remove Book");
		fetchingData();
	}
	
	void confirmBook(){
		System.out.print("\nAre you Confirm this Book (y/n) : ");
		char input= sc.next().charAt(0);
		sc.nextLine();
		System.out.println("");
		switch(input) {
		case 'y':{
			removeBook();
			break;
		}
		case 'n':{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			confirmBook();
		}
		}
	}
	
	void removeLoop() {
		System.out.print("\nContinue or Previous Page (y/n) : ");
		char input= sc.next().charAt(0);
		sc.nextLine();
		System.out.println("");
		switch(input) {
		case 'y':{
			fetchingData();
			break;
		}
		case 'n':{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			removeLoop();
		}
		}
	}
	
	void removeBook() {
		try {
			String Query ="delete from bookDetails where bookId="+getBookId()+";";
			connect.stmt.executeUpdate(Query);
			System.out.println("Book Removed Successfully...!");
			removeLoop();
		}
		catch(Exception e) {
			System.out.println("Error in SQl Query Statement...!");
			System.out.println("Error is  : "+e.toString());
		}
	}
	
	void fetchingData() {
		System.out.print("Enter the Book id : ");
		setBookId(sc.next());
//		String bookId = sc.next();
		System.out.println("");
		try {
			String getBookQuery = "select * from bookDetails where bookId="+getBookId()+";";
			connect.rs=connect.stmt.executeQuery(getBookQuery);
			if(connect.rs.next()) {
				System.out.println("Book Id     : "+connect.rs.getString("bookId"));
				System.out.println("Book Name   : "+connect.rs.getString("bookname"));
				System.out.println("Book Author : "+connect.rs.getString("Authour"));
				System.out.println("Book Price  : "+connect.rs.getString("price"));
				confirmBook();
			}
			else {
				System.out.println("Enter Valid Book Id..!");
				removeLoop();
			}
			System.out.println("");
		}
		catch(SQLSyntaxErrorException e) {
			System.out.println("Enter Valid Book Id..!");
			removeLoop();
		}
		catch(Exception e) {
			System.out.println("Error in SQl Query Statement...!");
			System.out.println("Error is  : ---"+e.toString());
		}
	}

	public String getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}

}
