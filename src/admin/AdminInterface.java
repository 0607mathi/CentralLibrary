package admin;
import libraryApp.*;
public class AdminInterface extends library {
	
	AdminInterface(String AdminUserId){
		System.out.println("");
		title("Welcome "+AdminUserId);
		String AdminMenu[]= {"1. Add Book","2. Remove Book","3. Alter Book Details","4. Pending Book","5. User Details","6. Logout"};
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
			break;
		}
		case 3:{
			break;
		}
		case 4:{
			break;
		}
		case 5:{
			break;
		}
		case 6:{
			System.out.println(AdminUserId+"Logout Successfully...!\n");
			new home().homepage();
			break;
		}
		default:{
			wrongInput();
			AdminMenu(AdminUserId);
		}
		}
	}
}
