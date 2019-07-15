package hjjf.scss.service;

import hjjf.scss.model.Class;

import java.util.List;

public interface ClassInterface {
	String add(Class pro);
	int delete(Class pro);
	int update(Class pro);
	List<Class> search(Class cls);
}
