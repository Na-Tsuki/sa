package hjjf.scss.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import hjjf.scss.model.Student;
import hjjf.scss.service.StudentInterface;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	private Student student;
	private StudentInterface studentInterface;


	public String add() {
		String str = studentInterface.add(student);
		if (str != null) {
			return "success";
		} else {
			return "error";
		}
	}

	public String delete() {
		if (studentInterface.delete(student) != 0) {
			return "success";
		} else {
			return "error";
		}
	}

	public String update() {
		if (studentInterface.update(student) != 0) {
			return "success";
		} else {
			return "error";
		}
	}

	public void search() throws IOException {
		List<Student> list = studentInterface.search(student);
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	public String login() {
		Student stu = studentInterface.StudentLogin(student);
		if (stu != null) {
			request.getSession().setAttribute("student", stu);
			return "success";
		} else {
			return "error";
		}
	}

	public String selfup() {
		if (studentInterface.update(student) != 0) {
			((Student) request.getSession().getAttribute("student"))
					.setName(student.getName());
			((Student) request.getSession().getAttribute("student"))
					.setStuID(student.getStuID());
			((Student) request.getSession().getAttribute("student"))
					.setBirth(student.getBirth());
			((Student) request.getSession().getAttribute("student"))
					.setSex(student.getSex());
			((Student) request.getSession().getAttribute("student"))
					.setRemark(student.getRemark());
			return "success";
		} else {
			return "error";
		}
	}

	public String passup() {
		if (studentInterface.Passup(student) != 0) {
			return "success";
		} else {
			return "error";
		}

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentInterface getStudentInterface() {
		return studentInterface;
	}

	public void setStudentInterface(StudentInterface studentInterface) {
		this.studentInterface = studentInterface;
	}
}
