package admin;
import libraryApp.*;
import java.util.*;

public class AlterBookDetails extends library {
	ConnectionManager connect = new ConnectionManager();
	Scanner sc = new Scanner(System.in);
	private String AdminUserId;
	private String BookId ;
	public AlterBookDetails(String AdminUserId) {
		setAdminUserId(AdminUserId);
		title("Book Data Modification");
		System.out.print("\nEnter the Book Id :");
		setBookId(sc.next());
		displayBook();
		chooseModification();
	}
	
	void chooseModification() {
		title("Choose what you want to modify");
		String via []= {"1. Book Name","2. Book Author","3. Book Price","4. Exit"};
		for(String menu : via) {
			System.out.println(menu);
		}
		switch(userInput()) {
		case 1:{
//			change bookName
			changeBookname();
			break;
		}
		case 2:{
//			change Author
			changeBookAuthor();
			break;
		}
		case 3:{
//			change Price
			changeBookPrice();
			break;
		}
		case 4:{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			previousPage();
		}
		}
	}

	void changeBookname() {
		System.out.print("Enter Book Name : ");
		sc.nextLine();
		String bookname = sc.nextLine();
		try {
			System.out.print("\nAre you Sure to Change (y/n) : ");
			char input = sc.next().charAt(0);
			switch(input) {
			case 'y':{
				String Query ="update bookDetails set bookname = '"+bookname+"' where bookId = "+getBookId()+";";
				connect.stmt.executeUpdate(Query);
				System.out.println("\nBook name Changed...!\n");
				displayBook();
				previousPage();
				break;
			}
			case 'n':{
				chooseModification();
				break;
			}
			default:{
				wrongInput();
				changeBookname();
			}
			}
		}catch(Exception e) {
			if(e.toString().contains("Duplicate entry")) {
				System.out.println("\nThis book name is already exist please check your book name...!");
				previousPage();
			}
			else {
			System.out.println("\nError in SQL Query...!");
			System.out.println("\nError is : "+e.toString());
			}
		}
	}
	
	void changeBookAuthor() {
		System.out.print("Enter Author Name : ");
		sc.nextLine();
		String Author = sc.nextLine();
		try {
			System.out.print("\nAre you Sure to Change (y/n) : ");
			char input = sc.next().charAt(0);
			switch(input) {
			case 'y':{
				String Query ="update bookDetails set Authour = '"+Author+"' where bookId = "+getBookId()+";";
				connect.stmt.executeUpdate(Query);
				System.out.println("\nAuthor name Changed...!\n");
				displayBook();
				previousPage();
				break;
			}
			case 'n':{
				chooseModification();
				break;
			}
			default:{
				wrongInput();
				changeBookname();
			}
			}
		}catch(Exception e) {
			System.out.println("\nError in SQL Query...!");
			System.out.println("\nError is : "+e.toString());
		}
	}
	
	void changeBookPrice() {
		System.out.print("Enter Book Price : ");
		double price = sc.nextDouble();
		try {
			System.out.print("\nAre you Sure to Change (y/n) : ");
			char input = sc.next().charAt(0);
			switch(input) {
			case 'y':{
				String Query ="update bookDetails set price = '"+price+"' where bookId = "+getBookId()+";";
				connect.stmt.executeUpdate(Query);
				System.out.println("\nBook Price Changed...!\n");
				displayBook();
				previousPage();
				break;
			}
			case 'n':{
				chooseModification();
				break;
			}
			default:{
				wrongInput();
				changeBookname();
			}
			}
		}catch(Exception e) {
			System.out.println("\nError in SQL Query...!");
			System.out.println("\nError is : "+e.toString());
		}
	}
	
	void previousPage() {
		System.out.print("\nContinue or previous page (y/n) : ");
		char input = sc.next().charAt(0);
		System.out.println("");
		switch(input) {
		case 'y':{
			chooseModification();
			break;
		}
		case 'n':{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			previousPage();
		}
		}
	}
	
	void displayBook() {
		ConnectionManager connect = new ConnectionManager();
		try {
			String Query="select * from bookDetails where bookId="+getBookId()+";";
			connect.rs=connect.stmt.executeQuery(Query);
			if(connect.rs.next()) {
				title("Book Details");
				System.out.println("Book Id     : "+connect.rs.getString("bookId"));
				System.out.println("User Name   : "+connect.rs.getString("bookname"));
				System.out.println("Book Author : "+connect.rs.getString("Authour"));
				System.out.println("Book Price  : "+connect.rs.getString("price"));
				System.out.println("");
			}
			else {
				System.out.println("\nEnter a valid BookId...!");
				back();
			}
		}
		catch(Exception e) {
			System.out.println("\nError in SQL Query...!");
			System.out.println("\nError is : "+e.toString());
		}
	}
	
	void back(){
		System.out.print("\nContinue or Exit (y/n) : ");
		char input = sc.next().charAt(0);
		System.out.println("");
		switch(input) {
		case 'y':{
			new AlterBookDetails(getAdminUserId());
			break;
		}
		case 'n':{
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

	public String getBookId() {
		return BookId;
	}

	public void setBookId(String bookId) {
		BookId = bookId;
	}
	
}
