package hjjf.scss.service;

import hjjf.scss.model.Profession;

import java.util.List;

public interface ProfessionInterface {
	String add(Profession pro);
	int delete(Profession pro);
	int update(Profession pro);
	List<Profession> search(Profession pro);
}
