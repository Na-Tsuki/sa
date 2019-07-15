package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.TeacherDao;
import hjjf.scss.model.Teacher;
import hjjf.scss.service.TeacherInterface;

public class TeacherMgrImpl implements TeacherInterface {

		private TeacherDao teacherDao;
	@Override
	public String add(Teacher tec) {
		// TODO Auto-generated method stub
		return (String) teacherDao.save(tec);
	}

	@Override
	public int delete(Teacher tec) {
		// TODO Auto-generated method stub
		return teacherDao.delete(Teacher.class, tec.getTeacherID());
	}

	@Override
	public int update(Teacher tec) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) teacherDao.findByID(Teacher.class,
				tec.getTeacherID());
		teacher.setName(tec.getName());
		teacher.setSex(tec.getSex());
		teacher.setBirth(tec.getBirth());
		teacher.setRemark(tec.getRemark());
		return teacherDao.update(teacher);
	}

	@Override
	public List<Teacher> search(Teacher tec) {
		// TODO Auto-generated method stub
		String hql = "from Teacher tec where tec.college.CollegeID=?";
		Object parmas[] = { tec.getCollege().getCollegeID() };
		return teacherDao.select(hql, parmas);
	}

	@Override
	public Teacher TeacherLogin(Teacher tec) {
		// TODO Auto-generated method stub
		String hql = "from Teacher tec where tec.TeacherID=? and tec.Password=?";
		Object[] obj = { tec.getTeacherID(), tec.getPassword() };
		Teacher teacher = (Teacher) teacherDao.findByID(Teacher.class,
				tec.getTeacherID());
		if (teacherDao.select(hql, obj).size() > 0) {
			return teacher;
		} else {
			return null;
		}
	}

	@Override
	public int Passup(Teacher tec) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) teacherDao.findByID(Teacher.class,
				tec.getTeacherID());
		if (teacher.getPassword().equals(tec.getPassword())) {
			teacher.setPassword(tec.getNewPassword());
			return teacherDao.update(teacher);
		} else {
			return 0;
		}
	}

	@Override
	public int selfup(Teacher tea) {
		// TODO Auto-generated method stub
		Teacher teacher = (Teacher) teacherDao.findByID(Teacher.class,
				tea.getTeacherID());
		teacher.setName(tea.getName());
		teacher.setSex(tea.getSex());
		teacher.setBirth(tea.getBirth());
		teacher.setRemark(tea.getRemark());
		return teacherDao.update(teacher);
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}


	
}
