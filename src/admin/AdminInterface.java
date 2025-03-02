package admin;
import libraryApp.*;
public class AdminInterface extends library {
	ConnectionManager connect = new ConnectionManager();
	public AdminInterface(String AdminUserId){
		System.out.println("");
		title("Welcome "+AdminUserId);
		String AdminMenu[]= {"1. Add Book","2. Remove Book","3. Alter Book Details","4. Pending Book","5. User Details","6. Show All Book Details","7. Logout"};
		for(String menu : AdminMenu) {
			System.out.println(menu);
		}
		AdminMenu(AdminUserId);
	}
	
	void AdminMenu(String AdminUserId) {
		switch(userInput()) {
		case 1:{
			new AddBook(AdminUserId);
			break;
		}
		case 2:{
			new RemoveBook(AdminUserId);
			break;
		}
		case 3:{
			new AlterBookDetails(AdminUserId);
			break;
		}
		case 4:{
			new PendingBooks(AdminUserId);
			break;
		}
		case 5:{
			new UserDetials(AdminUserId);
			break;
		}
		case 6:{
			new GetAllBookDetails(AdminUserId);
			break;
		}
		case 7:{
			saveData();
			System.out.println(AdminUserId+" Logout Successfully...!\n");
			new home().homepage();
			break;
		}
		default:{
			wrongInput();
			AdminMenu(AdminUserId);
		}
		}
	}
	
	void saveData() {
		try {
			String Query ="commit";
			connect.stmt.executeUpdate(Query);
		}
		catch(Exception e) {
			System.out.println("Error in Sql Statement...!");
			System.out.println("Error is : "+e.toString());
		}
	}
}
