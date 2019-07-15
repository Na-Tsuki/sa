package hjjf.scss.impl;


import java.util.List;
 

import hjjf.scss.dao.ProfessionDao;
import hjjf.scss.model.Profession;
import hjjf.scss.service.ProfessionInterface;

public class ProfessionMgrImpl implements ProfessionInterface{
	
	private ProfessionDao professionDao;

	public ProfessionDao getProfessionDao() {
		return professionDao;
	}

	public void setProfessionDao(ProfessionDao professionDao) {
		this.professionDao = professionDao;
	}

	@Override
	public String add(Profession pro) {
		return (String)professionDao.save(pro);
	}

	@Override
	public int delete(Profession pro) {
		return professionDao.delete(Profession.class, pro.getProfessionID());
	}

	@Override
	public int update(Profession pro) {
		// TODO Auto-generated method stub
		Profession profession=(Profession)professionDao.findByID(Profession.class, pro.getProfessionID());
		profession.setProfessionName(pro.getProfessionName());
		profession.setRemark(pro.getRemark());
		 return professionDao.update(profession);
	}

	@Override
	public List<Profession> search(Profession pro) {
		// TODO Auto-generated method stub
		String hql = "from Profession pro where pro.department.DepartmentID=?";
		Object parmas[]={pro.getDepartment().getDepartmentID()};
		return professionDao.select(hql, parmas);
	}
}
