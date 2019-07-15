package hjjf.scss.model;

public class Admin {
	private String AdminID;
	private String AdminName;
	private String PassWord;
	private String NewPassWord;
	private String Role;
	private String Photo;
	private String Remark;
	
	public String getNewPassWord() {
		return NewPassWord;
	}
	public void setNewPassWord(String newPassWord) {
		NewPassWord = newPassWord;
	}
	public String getAdminID() {
		return AdminID;
	}
	public void setAdminID(String adminID) {
		AdminID = adminID;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
