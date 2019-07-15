package hjjf.scss.service;

import hjjf.scss.model.Department;

import java.util.List;

public interface DepartmentIterface {
	String add(Department dpm);
	int delete(Department dpm);
	int update(Department dpm);
	List<Department> search(Department department);
}
