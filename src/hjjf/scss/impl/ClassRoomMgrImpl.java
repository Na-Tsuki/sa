package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.ClassRoomDao;
import hjjf.scss.model.ClassRoom;
import hjjf.scss.service.ClassRoomInterface;

public class ClassRoomMgrImpl implements ClassRoomInterface {
 private ClassRoomDao classRoomDao;
	 
	public ClassRoomDao getClassRoomDao() {
	return classRoomDao;
}

public void setClassRoomDao(ClassRoomDao classRoomDao) {
	this.classRoomDao = classRoomDao;
}

	@Override
	public String add(ClassRoom cr) {
		// TODO Auto-generated method stub
		return (String) classRoomDao.save(cr);
	}

	@Override
	public int delete(ClassRoom cr) {
		// TODO Auto-generated method stub
		return classRoomDao.delete(ClassRoom.class, cr.getID());
	}

	@Override
	public int update(ClassRoom cr) {
		// TODO Auto-generated method stub
		ClassRoom classRoom = (ClassRoom) classRoomDao.findByID(ClassRoom.class,
				cr.getID());
		classRoom.setClassRoomName(cr.getClassRoomName());
		classRoom.setClassRoomCategory(cr.getClassRoomCategory());
		classRoom.setRemark(cr.getRemark());
		return classRoomDao.update(classRoom);
	}

	@Override
	public List<ClassRoom> search() {
		// TODO Auto-generated method stub
		String hql = "from ClassRoom";
		return classRoomDao.select(hql);

	}

}
