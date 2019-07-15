package hjjf.scss.service;

import hjjf.scss.model.Admin;

import java.util.List;

public interface AdminInterface {
	String add(Admin adm);
	int delete(Admin adm);
	int update(Admin adm);
	int selfup(Admin adm);
	List<Admin> search();
	Admin AdminLogin(Admin adm);
	int Passup(Admin adm);
}
