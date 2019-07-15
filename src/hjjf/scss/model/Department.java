package hjjf.scss.model;

public class Department {
	private String DepartmentID;
	private String DepartmentName;
	private String Remark;
	private College college;
	
	public String getDepartmentID() {
		return DepartmentID;
	}
	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}


}
