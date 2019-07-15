package hjjf.scss.service;

import hjjf.scss.model.Audit;

import java.util.List;

public interface AuditInterface {
	String add(Audit tec);
	int update(Audit tec);
	List<Audit> search();
}
