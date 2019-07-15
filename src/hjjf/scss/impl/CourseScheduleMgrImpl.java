package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.CourseScheduleDao;
import hjjf.scss.dao.ScheduleDao;
import hjjf.scss.model.CourseSchedule;
import hjjf.scss.model.Schedule;
import hjjf.scss.service.CourseScheduleInterface;

public class CourseScheduleMgrImpl implements CourseScheduleInterface{
	
	private CourseScheduleDao courseScheduleDao;
	private ScheduleDao scheduleDao;
	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public CourseScheduleDao getCourseScheduleDao() {
		return courseScheduleDao;
	}

	public void setCourseScheduleDao(CourseScheduleDao courseScheduleDao) {
		this.courseScheduleDao = courseScheduleDao;
	}

	@Override
	public String add(CourseSchedule scd) {
		// TODO Auto-generated method stub
		return String.valueOf(courseScheduleDao.save(scd));
	}

	@Override
	public int update(CourseSchedule scd) {
		// TODO Auto-generated method stub
		CourseSchedule courseSchedule=(CourseSchedule)courseScheduleDao.findByID(CourseSchedule.class,scd.getID());
		courseSchedule.setScoreOne(scd.getScoreOne());
		courseSchedule.setScoreTwo(scd.getScoreTwo());
		courseSchedule.setScoreThree(scd.getScoreThree());
		courseSchedule.setTotalScore(scd.getTotalScore());
		 return courseScheduleDao.update(courseSchedule);
	}

	@Override
	public List<Schedule> search() {
		// TODO Auto-generated method stub
		String hql = "from Schedule";
		return scheduleDao.select(hql);
	}
	
	@Override
	public List<CourseSchedule> scoresearch() {
		// TODO Auto-generated method stub
		String hql = "from CourseSchedule";
		return courseScheduleDao.select(hql);
	}

	


}
