package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.DepartmentDao;
import hjjf.scss.model.Department;
import hjjf.scss.service.DepartmentIterface;

public class DepartmentMgrImpl implements DepartmentIterface{

	private DepartmentDao departmentDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public String add(Department dpm) {
		// TODO Auto-generated method stub
			return (String)departmentDao.save(dpm);
			
	}

	@Override
	public int delete(Department dpm) {
		return departmentDao.delete(Department.class, dpm.getDepartmentID());	
	}

	@Override
	public int update(Department dpm) {
		Department department=(Department)departmentDao.findByID(Department.class, dpm.getDepartmentID());
		department.setDepartmentName(dpm.getDepartmentName());
		department.setRemark(dpm.getRemark());
		 return departmentDao.update(department);
	}
	
	@Override
	public List<Department> search(Department department) {
		// TODO Auto-generated method stub
		String hql = "from Department dep where dep.college.CollegeID=?";
		Object parmas[]={department.getCollege().getCollegeID()};
		return departmentDao.select(hql, parmas);
	}



}
