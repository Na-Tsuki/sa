package hjjf.scss.model;

public class Schedule {
private int ID;
private TeachTask teachTask;
private ClassRoom classRoom;
private String ClassTime;
private String Lesson;
private String Remark;


public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public TeachTask getTeachTask() {
	return teachTask;
}
public void setTeachTask(TeachTask teachTask) {
	this.teachTask = teachTask;
}
public ClassRoom getClassRoom() {
	return classRoom;
}
public void setClassRoom(ClassRoom classRoom) {
	this.classRoom = classRoom;
}
public String getClassTime() {
	return ClassTime;
}
public void setClassTime(String classTime) {
	ClassTime = classTime;
}
public String getLesson() {
	return Lesson;
}
public void setLesson(String lesson) {
	Lesson = lesson;
}
public String getRemark() {
	return Remark;
}
public void setRemark(String remark) {
	Remark = remark;
}
}
