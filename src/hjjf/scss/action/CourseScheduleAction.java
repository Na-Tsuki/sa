package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.CourseSchedule;
import hjjf.scss.model.Schedule;
import hjjf.scss.model.Student;
import hjjf.scss.service.CourseScheduleInterface;


public class CourseScheduleAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1048197001181923840L;
	HttpServletRequest request=ServletActionContext.getRequest();
	private CourseSchedule courseSchedule;
	private CourseScheduleInterface courseScheduleInterface;

	

	
	public CourseSchedule getCourseSchedule() {
		return courseSchedule;
	}

	public void setCourseSchedule(CourseSchedule courseSchedule) {
		this.courseSchedule = courseSchedule;
	}

	public CourseScheduleInterface getCourseScheduleInterface() {
		return courseScheduleInterface;
	}

	public void setCourseScheduleInterface(
			CourseScheduleInterface courseScheduleInterface) {
		this.courseScheduleInterface = courseScheduleInterface;
	}

	public String add(){
		Student stu=new Student();
		stu.setStuID(((Student)request.getSession().getAttribute("student")).getStuID());
		courseSchedule.setStudent(stu);
		 
		String str=courseScheduleInterface.add(courseSchedule);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(courseScheduleInterface.update(courseSchedule)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	
	public void search() throws IOException{
		 
		List<Schedule> list=courseScheduleInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
	
	public void scoresearch() throws IOException{
		 
		List<CourseSchedule> list=courseScheduleInterface.scoresearch();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
