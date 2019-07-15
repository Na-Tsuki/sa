package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.Department;
import hjjf.scss.service.DepartmentIterface;

public class DepartmentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5604091046911999150L;
	
	private Department department;
	private DepartmentIterface departmentInterface;
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

	public String add(){
		 
		String str=departmentInterface.add(department);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		 
		if(departmentInterface.delete(department)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(departmentInterface.update(department)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
		List<Department> list=departmentInterface.search(department);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}

	public DepartmentIterface getDepartmentInterface() {
		return departmentInterface;
	}

	public void setDepartmentInterface(DepartmentIterface departmentInterface) {
		this.departmentInterface = departmentInterface;
	}
	
}
