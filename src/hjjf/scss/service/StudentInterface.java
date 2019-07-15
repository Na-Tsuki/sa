package hjjf.scss.service;

import hjjf.scss.model.Student;

import java.util.List;

public interface StudentInterface {
	String add(Student stu);
	int delete(Student stu);
	int update(Student stu);
	Student StudentLogin(Student stu);
	int Passup(Student stu);
	List<Student> search(Student stu);
	int selfup(Student stu);
}
