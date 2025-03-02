package admin;
import java.util.*;
import libraryApp.*;
public class AddBook extends library {
	Scanner sc = new Scanner(System.in);
	ConnectionManager connect = new ConnectionManager();
	private String BookName;
	private String BookAuthor;
	private double BookPrice;
	private String AdminUserId;
	AddBook(String AdminUserId){
		setAdminUserId(AdminUserId);
		addBook();
	}
	
	void addBook() {
		title("Add a Book");
		System.out.print("Enter the Book Name     : ");
		setBookName(sc.nextLine());
		System.out.print("Enter the Author Name   : ");
		setBookAuthor(sc.nextLine());
		try {
			System.out.print("Enter Price of the Book : ");
			setBookPrice(sc.nextDouble());
		}catch(Exception e) {
			System.out.println("\nEnter Valid Input for Book Price\n");
			sc.nextLine();
			addBook();
		}
		insertBook();
	}
	
	void BookAdditionLoop(){
		System.out.print("\nAdd next Book or Exit (y/n) : ");
		char input= sc.next().charAt(0);
		sc.nextLine();
		System.out.println("");
		switch(input) {
		case 'y':{
			addBook();
			break;
		}
		case 'n':{
			new AdminInterface(getAdminUserId());
			break;
		}
		default:{
			wrongInput();
			BookAdditionLoop();
		}
		}
	}
	
	void insertBook() {
		try {
			String Query = "insert into bookDetails (bookname,Authour,price) values ('"+getBookName()+"','"+getBookAuthor()+"',"+getBookPrice()+");";
			connect.stmt.executeUpdate(Query);
			System.out.println("\nSucessfully Uploaded...!");
//			ask continue or exit for adding process
			BookAdditionLoop();
		}
		catch(Exception e) {
			if(e.toString().contains("Duplicate entry")) {
				System.out.println("\nThis book is Already Registered..!");
				BookAdditionLoop();
			}else {
			System.out.println("\nError in SQL Query...!");
			System.out.println("\nError is : "+e.toString());
			}
		}
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}

	public Double getBookPrice() {
		return BookPrice;
	}

	public void setBookPrice(double bookPrice) {
		BookPrice = bookPrice;
	}

	public String getAdminUserId() {
		return AdminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}
}
