package hjjf.scss.impl;


import java.util.List;

import hjjf.scss.dao.ClassDao;
import hjjf.scss.model.Class;
import hjjf.scss.service.ClassInterface;

public class ClassMgrImpl implements ClassInterface{
	
	private ClassDao classDao;
	public ClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(ClassDao classDao) {
		this.classDao = classDao;
	}

	@Override
	public String add(Class cls) {
		// TODO Auto-generated method stub
		return (String)classDao.save(cls);
	}

	@Override
	public int delete(Class cls) {
		// TODO Auto-generated method stub
	return classDao.delete(Class.class, cls.getClassID());
	}

	@Override
	public int update(Class cls) {
		// TODO Auto-generated method stub
		Class classs=(Class)classDao.findByID(Class.class, cls.getClassID());
		classs.setGradeName(cls.getGradeName());
		classs.setYearName(cls.getYearName());
		classs.setRemark(cls.getRemark());
		 return classDao.update(classs);
	}

	@Override
	public List<Class> search(Class cls) {
		// TODO Auto-generated method stub
		String hql = "from Class cls where cls.profession.ProfessionID=?";
		Object parmas[]={cls.getProfession().getProfessionID()};
		return classDao.select(hql, parmas);
	}
	
}
