package hjjf.scss.model;

public class Course {
	private String CourseID;
	private String Course;
	private Profession profession;
	private String StudyTime;
	private String Credit;
	private String CurriculumTime;
	private String Remark;
	public String getCourseID() {
		return CourseID;
	}
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public String getStudyTime() {
		return StudyTime;
	}
	public void setStudyTime(String studyTime) {
		StudyTime = studyTime;
	}
	
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	public String getCurriculumTime() {
		return CurriculumTime;
	}
	public void setCurriculumTime(String curriculumTime) {
		CurriculumTime = curriculumTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
}
