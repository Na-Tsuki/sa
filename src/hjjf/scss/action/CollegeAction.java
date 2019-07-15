package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import hjjf.scss.model.College;
import hjjf.scss.service.CollegeInterface;

import com.opensymphony.xwork2.ActionSupport;

public class CollegeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4774408719386721246L;
	private College college;
	private CollegeInterface collegeInterface;
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public CollegeInterface getCollegeInterface() {
		return collegeInterface;
	}

	public void setCollegeInterface(CollegeInterface collegeInterface) {
		this.collegeInterface = collegeInterface;
	}


	
	public String add(){
		String str=collegeInterface.add(college);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){ 
		if(collegeInterface.delete(college)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){ 
		if(collegeInterface.update(college)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{ 
		List<College> list=collegeInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
