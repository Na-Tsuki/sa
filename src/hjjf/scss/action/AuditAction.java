package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import hjjf.scss.model.Admin;
import hjjf.scss.model.Audit;
import hjjf.scss.service.AuditInterface;
import hjjf.scss.util.util;


public class AuditAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2206332341183125007L;
	HttpServletRequest request=ServletActionContext.getRequest();
	private Audit audit;
	private AuditInterface auditInterface;
	
	

	
	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public AuditInterface getAuditInterface() {
		return auditInterface;
	}

	public void setAuditInterface(AuditInterface auditInterface) {
		this.auditInterface = auditInterface;
	}

	public String add(){
		Admin adm=new Admin();
		adm.setAdminID(((Admin)request.getSession().getAttribute("admin")).getAdminID());
		audit.setAdmin(adm);
		audit.setAuditDate(util.getNowTime());
 
		String str=auditInterface.add(audit);
		if(str!=null){
			update();
			return "success";			
		}
		else{
			return "error";
		}
	}
	
	public String update(){
	 
		if(auditInterface.update(audit)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	

	
	public void search() throws IOException{
		 
		List<Audit> list=auditInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
}
