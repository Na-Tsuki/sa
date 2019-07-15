package hjjf.scss.service;

import hjjf.scss.model.Schedule;
import hjjf.scss.model.TeachTask;

import java.util.List;

public interface ScheduleInterface {
	String add(Schedule scd);
	List<TeachTask> search();
}
