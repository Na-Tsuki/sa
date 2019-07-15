package hjjf.scss.service;

import hjjf.scss.model.ClassRoom;

import java.util.List;

public interface ClassRoomInterface {
	String add(ClassRoom cr);
	int delete(ClassRoom cr);
	int update(ClassRoom cr);
	List<ClassRoom> search();
}
