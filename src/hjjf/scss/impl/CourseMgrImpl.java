package hjjf.scss.impl;


import java.util.List;

import hjjf.scss.dao.CourseDao;
import hjjf.scss.model.Course;
import hjjf.scss.service.CourseInterface;

public class CourseMgrImpl implements CourseInterface{
	
	private CourseDao courseDao;
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public String add(Course cos) {
		// TODO Auto-generated method stub
		return (String)courseDao.save(cos);
	}

	@Override
	public int delete(Course cos) {
		// TODO Auto-generated method stub
		return courseDao.delete(Course.class, cos.getCourseID());
	}

	@Override
	public int update(Course cos) {
		// TODO Auto-generated method stub
		Course course=(Course)courseDao.findByID(Course.class, cos.getCourseID());
		course.setCourse(cos.getCourse());
		course.setCredit(cos.getCredit());
		course.setCurriculumTime(cos.getCurriculumTime());
		course.setStudyTime(cos.getStudyTime());
		course.setRemark(cos.getRemark());
		 return courseDao.update(course);
	}

	@Override
	public List<Course> search(Course cos) {
		// TODO Auto-generated method stub
		String hql = "from Course cou where cou.profession.ProfessionID=?";
		Object parmas[]={cos.getProfession().getProfessionID()};
		return courseDao.select(hql, parmas);
	}

}
