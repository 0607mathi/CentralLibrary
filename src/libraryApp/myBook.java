package libraryApp;

import java.sql.SQLException;

public class myBook extends library{
	ConnectionManager connect = new ConnectionManager();
	
	private String userid ;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	myBook(String userid){
		title("My Books");
		this.setUserid(userid);
		getBooks();
	}
	
	boolean tableHeading(boolean flag) throws SQLException {
		System.out.println("Book Id\tBook name");
		System.out.println("-------\t---------");
		while(connect.rs.next()) {
			flag = true;
			System.out.println( connect.rs.getString(1)+"\t"+connect.rs.getString(2));
		}
		return flag;
	}
//	for backspace previous folder
	 void back() {
		System.out.print("\nPress 0 back to Dashboard\n");
		switch(userInput()) {
		case 0:
		{
			new userInterface(getUserid());
			break;
		}
		default:{
			wrongInput();
			back();
		}
		}
	}
	void getBooks() {
//		System.out.println("Current userid : "+getUserid());
		
		try {
			String Query = "select bookId,bookname from rental where userId=(select id from userDetails where name='"+getUserid()+"');";
//			System.out.println(Query);
			connect.rs = connect.stmt.executeQuery(Query);
			boolean flag = false;
//			this condition checks the book is present or not in the table
			if(!(tableHeading(flag)))
				System.out.println("\nThere is no book...!");
//			for backspace previous folder
			back();
		} catch (SQLException e) {
			System.out.println("Error in Sql Query...!");
			System.out.println("Error is : "+e.toString());
		}
	}

	
}
