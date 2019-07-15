package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.Schedule;
import hjjf.scss.model.TeachTask;
import hjjf.scss.service.ScheduleInterface;


public class ScheduleAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2954425396733566030L;
	private Schedule schedule;
	private ScheduleInterface scheduleInterface;
	


	public Schedule getSchedule() {
		return schedule;
	}


	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}


	public ScheduleInterface getScheduleInterface() {
		return scheduleInterface;
	}


	public void setScheduleInterface(ScheduleInterface scheduleInterface) {
		this.scheduleInterface = scheduleInterface;
	}


	HttpServletRequest request=ServletActionContext.getRequest();
	
	
	
	public String add(){
		 
		String str=scheduleInterface.add(schedule);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	
	public void search() throws IOException{
		 
		List<TeachTask> list=scheduleInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
