package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.Course;
import hjjf.scss.service.CourseInterface;

public class CourseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2884531273608085513L;
	private Course course;
	private CourseInterface courseInterface;

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseInterface getCourseInterface() {
		return courseInterface;
	}

	public void setCourseInterface(CourseInterface courseInterface) {
		this.courseInterface = courseInterface;
	}

	public String add(){
 
		String str=courseInterface.add(course);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
 
		if(courseInterface.delete(course)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
 
		if(courseInterface.update(course)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
 
		List<Course> list=courseInterface.search(course);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
