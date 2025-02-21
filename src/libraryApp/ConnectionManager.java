package libraryApp;
import java.sql.*;
public class ConnectionManager {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
//	Constructor
	 ConnectionManager(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			stmt=con.createStatement();
		}
		catch(Exception e) {
			System.out.println("Database Connection Failed...!");
			System.out.println("Error : "+e.toString());
		}
	}
}
