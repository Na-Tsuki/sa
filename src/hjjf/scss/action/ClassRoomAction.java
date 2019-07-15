package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import hjjf.scss.model.ClassRoom;
import hjjf.scss.service.ClassRoomInterface;

import com.opensymphony.xwork2.ActionSupport;

public class ClassRoomAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5951523348480989220L;
	private ClassRoom classRoom;
	private ClassRoomInterface classRoomInterface;
	public ClassRoom getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
	}

	public ClassRoomInterface getClassRoomInterface() {
		return classRoomInterface;
	}

	public void setClassRoomInterface(ClassRoomInterface classRoomInterface) {
		this.classRoomInterface = classRoomInterface;
	}

	public String add(){
		 
		String str=classRoomInterface.add(classRoom);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		 
		if(classRoomInterface.delete(classRoom)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(classRoomInterface.update(classRoom)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
		 
		List<ClassRoom> list=classRoomInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
