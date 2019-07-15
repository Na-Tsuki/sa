package hjjf.scss.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.TeachTask;
import hjjf.scss.model.Teacher;
import hjjf.scss.service.TeachTaskInterface;
import hjjf.scss.util.util;

public class TeachTaskAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7192161405970543799L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private TeachTask teachtask;
	private TeachTaskInterface teachtaskInterface;

	

	public TeachTask getTeachtask() {
		return teachtask;
	}

	public void setTeachtask(TeachTask teachtask) {
		this.teachtask = teachtask;
	}

	public TeachTaskInterface getTeachtaskInterface() {
		return teachtaskInterface;
	}

	public void setTeachtaskInterface(TeachTaskInterface teachtaskInterface) {
		this.teachtaskInterface = teachtaskInterface;
	}

	public String add() {
		Teacher ter = new Teacher();
		ter.setTeacherID(((Teacher) request.getSession()
				.getAttribute("teacher")).getTeacherID());
		teachtask.setTeacher(ter);
		teachtask.setCurricula(util.getcoursetime());
		teachtask.setAuditing("Œ¥…Û∫À");

		String str = teachtaskInterface.add(teachtask);
		if (str != null) {
			return "success";
		} else {
			return "error";
		}
	}

	public String delete() {

		if (teachtaskInterface.delete(teachtask) != 0) {
			return "success";
		} else {
			return "error";
		}
	}

	public void search() throws IOException {

		List<TeachTask> list = teachtaskInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}
}
