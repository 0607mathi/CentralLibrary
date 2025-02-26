package libraryApp;
import java.sql.*;
public class ConnectionManager {
	public Connection con = null;
	public Statement stmt = null;
	public ResultSet rs = null;
//	Constructor
	 public ConnectionManager(){
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
