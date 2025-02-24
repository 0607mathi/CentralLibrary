package libraryApp;

import java.sql.SQLException;

public class buyBook extends library {
	ConnectionManager connect = new ConnectionManager();
	
	private String userid;
	private String id ;
	private String name ; 
	private String author ;
	private String price ;
	
	buyBook(String userid){
		title("Buy your faviort Book");
		String menu[] = {"1. Search via Book Id","2. Search via Book Name","3. Search via Author","4. Show all the Book","5. Exit"};
		for(String i : menu) {
			System.out.println(i);
		}
		setUserid(userid);
		search();
	}
	
//	for backspace previous folder
	 void back() {
		System.out.print("\nPress 0 back to Dashboard\n");
		switch(userInput()) {
		case 0:
		{
			new buyBook(getUserid());
			break;
		}
		default:{
			wrongInput();
			back();
		}
		}
	}
	 
//		if you exist or continue (y/n) : 
		void previous() {
			System.out.print("\nif you to buy this book (y/n) : ");
			char YorN = sc.next().charAt(0);
			switch(YorN) {
			case 'y':{
				purchaseBook();
				break;
			}
			case 'n':{
				back();
				break;
			}
			default:{
				wrongInput();
				previous();
			}
			}
		}
		
		void purchaseBook() {
			System.out.print("\nAre you confirm this book (y/n) ? : ");
			char c = sc.next().charAt(0);
			System.out.println("");
			if(c=='y') {
				try {
//					getting current user id
					String userIdQuery = "select id from userDetails where name ='"+getUserid()+"';";
					connect.rs=connect.stmt.executeQuery(userIdQuery);
					String UserID="";
					if(connect.rs.next())
						UserID=connect.rs.getString(1);
//					this is checking the book is already have or not ?
					String BookExist_Or_Not = "select bookId from rental where userId='"+UserID+"' and bookId='"+getId()+"';";
					connect.rs=connect.stmt.executeQuery(BookExist_Or_Not);
					if(!(connect.rs.next())) {
						String Query ="insert into rental (userId,bookId,bookname,BookStatus) values ("+UserID+","+getId()+",'"+getName()+"',1);";
						connect.stmt.executeUpdate(Query);
						System.out.println("Successfully Purchased...!");
						back();
					}
					else {
						System.out.println("This Book is Alraedy Purchased...!");
						back();
					}
					
				} catch (SQLException e) {
					System.out.println("Check the Sql Statement...!");
					System.out.println("Error is : "+e.toString());
				}
			}
			else if(c=='n') {
				back();
			}
			else {
				wrongInput();
				purchaseBook();
			}
		}
		
	void search() {
		switch(userInput()) {
		case 1:{
			searchId();
			break;
		}
		case 2:{
			searchBook();
			break;
		}
		case 3:{
			searchAuthor();
			break;
		}
		case 4:{
			showAllbooks();
			break;
		}
		case 5:{
			new userInterface(getUserid());
			break;
		}
		default:{
			wrongInput();
			search();
		}//switch end here!
		}
	}
	
	private void searchId() {
		System.out.print("Enter your book Id : ");
		String bookid = sc.next();
		System.out.println("");
		try {
			String Query = "select * from bookDetails where bookId='"+bookid+"'";
			connect.rs=connect.stmt.executeQuery(Query);
			
			if(connect.rs.next()) {
				title("Your Book Details");
				setId(connect.rs.getString("bookId"));
				setName(connect.rs.getString("bookname"));
				setAuthor(connect.rs.getString("Authour"));
				setPrice(connect.rs.getString("price"));
				System.out.println("Book id     : "+getId());
				System.out.println("Book Name   : "+getName());
				System.out.println("Book Author : "+getAuthor());
				System.out.println("Book Price  : "+getPrice()+"rs");
				previous();
			}
			else {
				System.out.println("Book id is does not exist...!");
				back();
			}
		}catch(Exception e) {
			System.out.println("Check the Sql Statement...!");
			System.out.println("Error is : "+e.toString());
		}
	}
	
	private void searchBook() {
		System.out.print("Enter your book name : ");
		sc.nextLine(); // Consume the leftover newline
		String bookname = sc.nextLine().trim();
		System.out.println("");
		try {
			String Query = "select * from bookDetails where bookname='"+bookname+"'";
			connect.rs=connect.stmt.executeQuery(Query);
			
			if(connect.rs.next()) {
				title("Your Book Details");
				setId(connect.rs.getString("bookId"));
				setName(connect.rs.getString("bookname"));
				setAuthor(connect.rs.getString("Authour"));
				setPrice(connect.rs.getString("price"));
				System.out.println("Book id     : "+getId());
				System.out.println("Book Name   : "+getName());
				System.out.println("Book Author : "+getAuthor());
				System.out.println("Book Price  : "+getPrice()+"rs");
				previous();
			}
			else {
				System.out.println("Book name is does not exist...!");
				back();
			}
		}catch(Exception e) {
			System.out.println("Check the Sql Statement...!");
			System.out.println("Error is : "+e.toString());
		}
	}
	
	private void searchAuthor() {
		
		System.out.print("Enter your Author name : ");
		sc.nextLine(); // Consume the leftover newline
		String Authour = sc.nextLine().trim();
		System.out.println("");
		try {
			String Query = "select * from bookDetails where Authour='"+Authour+"'";
			connect.rs=connect.stmt.executeQuery(Query);
			boolean flag = false;
			int count =0;
			while(connect.rs.next()) {
				title("Your Book Details");
				setId(connect.rs.getString(1));
				setName(connect.rs.getString(2));
				setAuthor(connect.rs.getString(3));
				setPrice(connect.rs.getString(4));
				count++;
				System.out.println(count+"."+" Book Id : "+getId());
				System.out.println("   Name    : "+getName());
				System.out.println("   Author  : "+getAuthor());
				System.out.println("   Price   : "+getPrice());
				System.out.println("");
				flag = true;
			}
			if(flag) {
				previous();
			}
			else {
				System.out.println("Author name is does not exist...!");
				back();
			}
		}catch(Exception e) {
			System.out.println("Check the Sql Statement...!");
			System.out.println("Error is : "+e.toString());
		}
	}
	
	private void  showAllbooks() {
		title("Central Library Books");
		String Query = "select * from bookDetails";
		try {
			connect.rs=connect.stmt.executeQuery(Query);
			System.out.println("");
				int count =0;
			while(connect.rs.next()) {
				setId(connect.rs.getString(1));
				setName(connect.rs.getString(2));
				setAuthor(connect.rs.getString(3));
				setPrice(connect.rs.getString(4));
				count++;
				System.out.println(count+"."+" Book Id : "+getId());
				System.out.println("   Name    : "+getName());
				System.out.println("   Author  : "+getAuthor());
				System.out.println("   Price   : "+getPrice());
				System.out.println("");
			}
			previous();
		}
		catch(Exception e) {
			System.out.println("Error in Sql Query...!");
			System.out.println("Erro is : "+e.toString());
		}
		
	}
	
//	Getter and setter methods for global private instance variables
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid=userid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
