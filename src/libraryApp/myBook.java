package libraryApp;

import java.sql.SQLException;

public class myBook {
	ConnectionManager connect = new ConnectionManager();
	myBook(){
		System.out.println("My Books");
		System.out.println("--------");
	}
	
	void getBooks() {
		String Query = "";
		try {
			connect.rs = connect.stmt.executeQuery(Query);
		} catch (SQLException e) {
			System.out.println("Error in Sql Query...!");
			System.out.println("Error is : "+e.toString());
		}
	}
}
