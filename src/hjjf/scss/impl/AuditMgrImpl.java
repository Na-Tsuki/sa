package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.AuditDao;
import hjjf.scss.dao.TeachTaskDao;
import hjjf.scss.model.Audit;
import hjjf.scss.model.TeachTask;
import hjjf.scss.service.AuditInterface;

public class AuditMgrImpl implements AuditInterface {
	
private AuditDao auditDao;
private TeachTaskDao teachtaskDao;

	public TeachTaskDao getTeachtaskDao() {
	return teachtaskDao;
}

public void setTeachtaskDao(TeachTaskDao teachtaskDao) {
	this.teachtaskDao = teachtaskDao;
}

	public AuditDao getAuditDao() {
	return auditDao;
}

public void setAuditDao(AuditDao auditDao) {
	this.auditDao = auditDao;
}

	@Override
	public String add(Audit tec) {
		// TODO Auto-generated method stub
		return String.valueOf(auditDao.save(tec));
	}

	@Override
	public int update(Audit tec) {
		// TODO Auto-generated method stub
		System.out.println(tec.getTeachTask().getID());
		TeachTask teachTask=(TeachTask)teachtaskDao.findByID(TeachTask.class,tec.getTeachTask().getID());
		teachTask.setAuditing(tec.getTeachTask().getAuditing());
		 return teachtaskDao.update(teachTask);
	}

	@Override
	public List<Audit> search() {
		// TODO Auto-generated method stub
		String hql = "from TeachTask";
		return auditDao.select(hql);
	}


}
