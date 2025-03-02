package libraryApp;

import java.sql.*;

public class submitBook extends library {
	ConnectionManager connect  = new ConnectionManager();
	submitBook(String userId){
		title("Submit your Book");
		submit(userId);
	}
	
//	for backspace previous folder
	 void back(String userId) {
		System.out.print("\nPress 0 back to Previous Page\n");
		switch(userInput()) {
		case 0:
		{
			new userInterface(userId);
			break;
		}
		default:{
			wrongInput();
			back(userId);
		}
		}
	}
	
//		if you exist or continue (y/n) : 
		void previous(String userId) {
			System.out.print("\nif you to Continue (y/n) : ");
			char YorN = sc.next().charAt(0);
			switch(YorN) {
			case 'y':{
				submit(userId);
				break;
			}
			case 'n':{
				back(userId);
				break;
			}
			default:{
				wrongInput();
				previous(userId);
			}
			}
		}
	 
//	Are you sure to submit (y/n) : 
	void conformation(String userId,String bookId) {
		System.out.print("\nAre you sure to submit (y/n) : ");
		char YorN = sc.next().charAt(0);
		switch(YorN) {
		case 'y':{
			try {
				String bookis = "select userId from rental where bookId="+bookId+";";
				connect.rs=connect.stmt.executeQuery(bookis);
//				System.out.println(connect.rs.next());
				if(connect.rs.next()) {
					if(connect.rs.getString("id")==bookId) {
						String subQuery= "select id from userDetails where name='"+userId+"'";
						String Query ="delete from rental where userId=("+subQuery+") and bookId="+bookId+";";
						connect.stmt.executeUpdate(Query);
						System.out.println("\nBook Submitted Successfully...!");
					}
				}
				else {
					System.out.println("\nEnter a Valid Book ID...!");
					previous(userId);
				}
			}
			catch(SQLSyntaxErrorException e) {
				System.out.println("\nInvalid Book Id...!");
				previous( userId);
			}
			catch(Exception e) {
				System.out.println("Error in Sql Statement...!");
				System.out.println("Error is : "+e.toString());
			}
			
			break;
		}
		case 'n':{
			back(userId);
			break;
		}
		default:{
			wrongInput();
			conformation(userId,bookId);
		}
		}
	}
	
// 	getting input from user for submitting a book
	void submit(String userId) {
		System.out.print("\nEnter your Book Id : ");
		String bookId =sc.next();
		conformation(userId,bookId);
	}
}
