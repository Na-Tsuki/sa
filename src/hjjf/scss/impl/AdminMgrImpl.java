package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.AdminDao;
import hjjf.scss.model.Admin;
import hjjf.scss.service.AdminInterface;

public class AdminMgrImpl implements AdminInterface {
	
	private AdminDao adminDao;

	@Override
	public String add(Admin adm) {
		// TODO Auto-generated method stub
		return (String) adminDao.save(adm);
	}

	@Override
	public int delete(Admin adm) {
		// TODO Auto-generated method stub
		return adminDao.delete(Admin.class, adm.getAdminID());
	}

	@Override
	public int update(Admin adm) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) adminDao.findByID(Admin.class, adm.getAdminID());
		admin.setAdminName(adm.getAdminName());
		admin.setRole(adm.getRole());
		admin.setRemark(adm.getRemark());
		return adminDao.update(admin);
	}

	@Override
	public List<Admin> search() {
		// TODO Auto-generated method stub
		String hql = "from Admin";
		return adminDao.select(hql);
	}

	@Override
	public Admin AdminLogin(Admin adm) {
		// TODO Auto-generated method stub
		String hql = "from Admin adm where adm.AdminID=? and adm.PassWord=?";
		Object[] obj = { adm.getAdminID(), adm.getPassWord() };
		Admin admin = (Admin) adminDao.findByID(Admin.class, adm.getAdminID());
		if (adminDao.select(hql, obj).size() > 0) {
			return admin;
		} else {
			return null;
		}
	}

	@Override
	public int Passup(Admin adm) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) adminDao.findByID(Admin.class, adm.getAdminID());
		if (admin.getPassWord().equals(adm.getPassWord())) {
			admin.setPassWord(adm.getNewPassWord());
			return adminDao.update(admin);
		} else {
			return 0;
		}

	}

	@Override
	public int selfup(Admin adm) {
		// TODO Auto-generated method stub
		Admin admin = (Admin) adminDao.findByID(Admin.class, adm.getAdminID());
		admin.setAdminName(adm.getAdminName());
		admin.setRole(adm.getRole());
		admin.setRemark(adm.getRemark());
		return adminDao.update(admin);
	}

	public hjjf.scss.dao.AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(hjjf.scss.dao.AdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
