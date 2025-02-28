package admin;
import libraryApp.*;
public class GetAllBookDetails extends library {
	private String AdminUserId;
	public GetAllBookDetails(String AdminUserId ){
		setAdminUserId(AdminUserId);
		title("Central Library Books and Details");
		
	}
	
	void showAllBook(){
		
	}
	public String getAdminUserId() {
		return AdminUserId;
	}
	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}
}
