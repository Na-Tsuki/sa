package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import hjjf.scss.model.Teacher;
import hjjf.scss.service.TeacherInterface;

import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6042517650642103648L;
	private Teacher teacher;
	private TeacherInterface teacherInterface;
	HttpServletRequest request=ServletActionContext.getRequest();
	

	


	public String add(){
		teacher.setPassword("123");
		String str=teacherInterface.add(teacher);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		if(teacherInterface.delete(teacher)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		if(teacherInterface.update(teacher)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
		List<Teacher> list=teacherInterface.search(teacher);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
	
	public String login(){	
		Teacher tec=teacherInterface.TeacherLogin(teacher);
		if(tec!=null){
			 request.getSession().setAttribute("teacher",tec);
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String selfup(){
		if(teacherInterface.update(teacher)!=0){
			((Teacher)request.getSession().getAttribute("teacher")).setName(teacher.getName());
			((Teacher)request.getSession().getAttribute("teacher")).setTeacherID(teacher.getTeacherID());
			((Teacher)request.getSession().getAttribute("teacher")).setBirth(teacher.getBirth());
			((Teacher)request.getSession().getAttribute("teacher")).setSex(teacher.getSex());
			((Teacher)request.getSession().getAttribute("teacher")).setRemark(teacher.getRemark());
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String passup(){
		if(teacherInterface.Passup(teacher)!=0){
			return "success";
		}
		else{
			return "error";
		}
		
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public TeacherInterface getTeacherInterface() {
		return teacherInterface;
	}

	public void setTeacherInterface(TeacherInterface teacherInterface) {
		this.teacherInterface = teacherInterface;
	}

}
