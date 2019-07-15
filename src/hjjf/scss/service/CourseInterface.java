package hjjf.scss.service;

import hjjf.scss.model.Course;

import java.util.List;

public interface CourseInterface {
	String add(Course cos);
	int delete(Course cos);
	int update(Course cos);
	List<Course> search(Course cos);
}
