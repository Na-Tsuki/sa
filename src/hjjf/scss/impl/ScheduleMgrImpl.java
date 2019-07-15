package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.ScheduleDao;
import hjjf.scss.dao.TeachTaskDao;
import hjjf.scss.model.Schedule;
import hjjf.scss.model.TeachTask;
import hjjf.scss.service.ScheduleInterface;

public class ScheduleMgrImpl implements ScheduleInterface{

	private ScheduleDao scheduleDao;
	private TeachTaskDao teachtaskDao;
	public TeachTaskDao getTeachtaskDao() {
		return teachtaskDao;
	}

	public void setTeachtaskDao(TeachTaskDao teachtaskDao) {
		this.teachtaskDao = teachtaskDao;
	}

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Override
	public String add(Schedule scd) {
		// TODO Auto-generated method stub
		return String.valueOf(scheduleDao.save(scd));
	}

	@Override
	public List<TeachTask> search() {
		// TODO Auto-generated method stub
			String hql = "from TeachTask";
			return teachtaskDao.select(hql);
	}


	
}
