package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.Profession;
import hjjf.scss.service.ProfessionInterface;

public class ProfessionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7825841903064754379L;
	private Profession profession;
	private ProfessionInterface professionInterface;
	
	
	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public ProfessionInterface getProfessionInterface() {
		return professionInterface;
	}

	public void setProfessionInterface(ProfessionInterface professionInterface) {
		this.professionInterface = professionInterface;
	}

	public String add(){
		 
		String str=professionInterface.add(profession);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		 
		if(professionInterface.delete(profession)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(professionInterface.update(profession)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public void search() throws IOException{
		 
		List<Profession> list=professionInterface.search(profession);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
