package hjjf.scss.service;

import hjjf.scss.model.Teacher;

import java.util.List;

public interface TeacherInterface {
	String add(Teacher tec);
	int delete(Teacher tec);
	int update(Teacher tec);
	Teacher TeacherLogin(Teacher tec);
	int Passup(Teacher tec);
	List<Teacher> search(Teacher tec);
	int selfup(Teacher tea);
}
