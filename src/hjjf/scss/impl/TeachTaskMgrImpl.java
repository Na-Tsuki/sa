package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.TeachTaskDao;
import hjjf.scss.model.TeachTask;
import hjjf.scss.service.TeachTaskInterface;

public class TeachTaskMgrImpl implements TeachTaskInterface{
	
	private TeachTaskDao teachtaskDao;
	public TeachTaskDao getTeachtaskDao() {
		return teachtaskDao;
	}

	public void setTeachtaskDao(TeachTaskDao teachtaskDao) {
		this.teachtaskDao = teachtaskDao;
	}

	@Override
	public String add(TeachTask ttk) {
		// TODO Auto-generated method stub
		return String.valueOf(teachtaskDao.save(ttk));
	}

	@Override
	public int delete(TeachTask ttk) {
		// TODO Auto-generated method stub
		return teachtaskDao.delete(TeachTask.class, ttk.getID());
	}

	@Override
	public List<TeachTask> search() {
		// TODO Auto-generated method stub
		String hql = "from TeachTask";
		return teachtaskDao.select(hql);

	}
}
