package hjjf.scss.model;

public class TeachTask {
	private int ID;
	private Teacher teacher;
	private Course course;
	private String Curricula;
	private String Auditing;
	private String Remarks;
//	private CourseSchedule courseSchedule;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCurricula() {
		return Curricula;
	}
	public void setCurricula(String curricula) {
		Curricula = curricula;
	}
	public String getAuditing() {
		return Auditing;
	}
	public void setAuditing(String auditing) {
		Auditing = auditing;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
//	public CourseSchedule getCourseSchedule() {
//		return courseSchedule;
//	}
//	public void setCourseSchedule(CourseSchedule courseSchedule) {
//		this.courseSchedule = courseSchedule;
//	}
	
	
}
