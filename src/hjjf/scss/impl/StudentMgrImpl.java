package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.StudentDao;
import hjjf.scss.model.Student;
import hjjf.scss.service.StudentInterface;

public class StudentMgrImpl implements StudentInterface {
	private StudentDao studentDao;
	
	@Override
	public String add(Student stu) {
		// TODO Auto-generated method stub
		return (String) studentDao.save(stu);
	}

	@Override
	public int delete(Student stu) {
		// TODO Auto-generated method stub
		return studentDao.delete(Student.class, stu.getStuID());
	}

	@Override
	public int update(Student stu) {
		// TODO Auto-generated method stub
		Student student = (Student) studentDao.findByID(Student.class, stu.getStuID());
		student.setName(stu.getName());
		student.setSex(stu.getName());
		student.setBirth(stu.getBirth());
		student.setRemark(stu.getRemark());
		return studentDao.update(student);
	}

	@Override
	public List<Student> search(Student stu) {
		// TODO Auto-generated method stub
		String hql = "from Student stu where stu.Classs.ClassID=?";
		Object parmas[] = { stu.getClasss().getClassID() };
		return studentDao.select(hql, parmas);
	}

	@Override
	public Student StudentLogin(Student stu) {
		// TODO Auto-generated method stub
		String hql = "from Student tec where tec.StuID=? and tec.Password=?";
		Object[] obj = { stu.getStuID(), stu.getPassword() };
		Student student = (Student) studentDao.findByID(Student.class, stu.getStuID());
		if (studentDao.select(hql, obj).size() > 0) {
			return student;
		} else {
			return null;
		}
	}

	@Override
	public int Passup(Student stu) {
		// TODO Auto-generated method stub
		Student student = (Student) studentDao.findByID(Student.class, stu.getStuID());
		if (student.getPassword().equals(stu.getPassword())) {
			student.setPassword(stu.getNewPassword());
			return studentDao.update(student);
		} else {
			return 0;
		}
	}

	@Override
	public int selfup(Student stu) {
		// TODO Auto-generated method stub
		Student student = (Student) studentDao.findByID(Student.class, stu.getStuID());
		student.setName(stu.getName());
		student.setSex(stu.getSex());
		student.setBirth(stu.getBirth());
		student.setRemark(stu.getRemark());
		return studentDao.update(student);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

}
