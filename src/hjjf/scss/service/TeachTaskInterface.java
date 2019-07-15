package hjjf.scss.service;

import hjjf.scss.model.TeachTask;

import java.util.List;

public interface TeachTaskInterface {
	String add(TeachTask ttk);
	int delete(TeachTask ttk);
	List<TeachTask> search();
}
