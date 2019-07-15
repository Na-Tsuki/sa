package hjjf.scss.service;

import hjjf.scss.model.CourseSchedule;
import hjjf.scss.model.Schedule;

import java.util.List;

public interface CourseScheduleInterface {
	String add(CourseSchedule scd);
	int update(CourseSchedule scd);
	List<Schedule> search();
	List<CourseSchedule> scoresearch();
}
