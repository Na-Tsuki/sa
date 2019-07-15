package hjjf.scss.impl;


import java.util.List;

import hjjf.scss.dao.CollegeDao;
import hjjf.scss.model.College;
import hjjf.scss.service.CollegeInterface;

public class CollegeMgrImpl implements CollegeInterface {
	
	private CollegeDao collegeDao;
	
	

	public CollegeDao getCollegeDao() {
		return collegeDao;
	}

	public void setCollegeDao(CollegeDao collegeDao) {
		this.collegeDao = collegeDao;
	}

	@Override
	public String add(College clg) {
		// TODO Auto-generated method stub
		return (String)collegeDao.save(clg);
		
	}

	@Override
	public int delete(College clg) {
		// TODO Auto-generated method stub
		return collegeDao.delete(College.class, clg.getCollegeID());
	}

	@Override
	public int update(College clg) {
		// TODO Auto-generated method stub
		College college=(College)collegeDao.findByID(College.class, clg.getCollegeID());
		 college.setCollegeName(clg.getCollegeName());
		 college.setRemark(clg.getRemark());
		 return collegeDao.update(college);
	}

	@Override
	public List<College> search() {
		// TODO Auto-generated method stub
		String hql = "from College";
		return collegeDao.select(hql);

	}

	

}
