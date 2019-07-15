package hjjf.scss.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import hjjf.scss.model.Admin;
import hjjf.scss.service.AdminInterface;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Admin admin;
	private AdminInterface adminInterface;

	HttpServletRequest request = ServletActionContext.getRequest();

	public String add() {
		admin.setPassWord("123");
		String str = adminInterface.add(admin);
		if (str != null) {
			return "success";
		} else {
			return "error";
		}
	}

	public String delete() {
		if (adminInterface.delete(admin) != 0) {
			return "success";
		} else {
			return "error";
		}
	}

	public String update() {
		if (adminInterface.update(admin) != 0) {
			((Admin) request.getSession().getAttribute("admin"))
					.setAdminName(admin.getAdminName());
			return "success";
		} else {
			return "error";
		}
	}

	public String selfup() {
		if (adminInterface.update(admin) != 0) {
			((Admin) request.getSession().getAttribute("admin"))
					.setAdminName(admin.getAdminName());
			((Admin) request.getSession().getAttribute("admin"))
					.setAdminID(admin.getAdminID());
			((Admin) request.getSession().getAttribute("admin")).setRole(admin
					.getRole());
			((Admin) request.getSession().getAttribute("admin"))
					.setRemark(admin.getRemark());
			return "success";
		} else {
			return "error";
		}
	}

	public void search() throws IOException {
		List<Admin> list = adminInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();
	}

	public String login() {
		Admin adm = adminInterface.AdminLogin(admin);
		if (adm != null) {
			request.getSession().setAttribute("admin", adm);
			return "success";
		} else {
			return "error";
		}
	}

	public String passup() {
		if (adminInterface.Passup(admin) != 0) {
			return "success";
		} else {
			return "error";
		}

	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public AdminInterface getAdminInterface() {
		return adminInterface;
	}

	public void setAdminInterface(AdminInterface adminInterface) {
		this.adminInterface = adminInterface;
	}

}
