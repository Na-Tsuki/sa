package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import hjjf.scss.model.Class;
import hjjf.scss.service.ClassInterface;

import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6485076582468281366L;
	private Class classs;
	private ClassInterface classInterface;
	
	
	public Class getClasss() {
		return classs;
	}

	public void setClasss(Class classs) {
		this.classs = classs;
	}



	public ClassInterface getClassInterface() {
		return classInterface;
	}

	public void setClassInterface(ClassInterface classInterface) {
		this.classInterface = classInterface;
	}

	public String add(){
		 
		String str=classInterface.add(classs);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		 
		if(classInterface.delete(classs)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(classInterface.update(classs)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
		 
		List<Class> list=classInterface.search(classs);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
