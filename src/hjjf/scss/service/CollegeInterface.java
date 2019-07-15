package hjjf.scss.service;

import hjjf.scss.model.College;

import java.util.List;

public interface CollegeInterface {
	String add(College clg);
	int delete(College clg);
	int update(College clg);
	List<College> search();
}
