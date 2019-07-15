package hjjf.scss.model;

public class CourseSchedule {
	private int ID;
	private Student student;
	private TeachTask teachTask;
	private float ScoreOne;
	private float ScoreTwo;
	private float ScoreThree;
	private float TotalScore;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TeachTask getTeachTask() {
		return teachTask;
	}
	public void setTeachTask(TeachTask teachTask) {
		this.teachTask = teachTask;
	}
	public float getScoreOne() {
		return ScoreOne;
	}
	public void setScoreOne(float scoreOne) {
		ScoreOne = scoreOne;
	}
	public float getScoreTwo() {
		return ScoreTwo;
	}
	public void setScoreTwo(float scoreTwo) {
		ScoreTwo = scoreTwo;
	}
	public float getScoreThree() {
		return ScoreThree;
	}
	public void setScoreThree(float scoreThree) {
		ScoreThree = scoreThree;
	}
	public float getTotalScore() {
		return TotalScore;
	}
	public void setTotalScore(float totalScore) {
		TotalScore = totalScore;
	}
	
}
