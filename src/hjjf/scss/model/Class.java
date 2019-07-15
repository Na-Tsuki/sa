package hjjf.scss.model;

public class Class {
	private String ClassID;
	private String GradeName;
	private String YearName;
	private Profession profession;
	private String Remark;
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String classID) {
		ClassID = classID;
	}
	public String getGradeName() {
		return GradeName;
	}
	public void setGradeName(String gradeName) {
		GradeName = gradeName;
	}
	public String getYearName() {
		return YearName;
	}
	public void setYearName(String yearName) {
		YearName = yearName;
	}

	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	
	
}
