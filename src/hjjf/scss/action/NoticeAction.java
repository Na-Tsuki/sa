package hjjf.scss.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import hjjf.scss.model.Admin;
import hjjf.scss.model.Notice;
import hjjf.scss.service.NoticeInterface;
import hjjf.scss.util.util;


public class NoticeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6315033807073698393L;
	private Notice notice;
	private NoticeInterface noticeInterface;
	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public NoticeInterface getNoticeInterface() {
		return noticeInterface;
	}

	public void setNoticeInterface(NoticeInterface noticeInterface) {
		this.noticeInterface = noticeInterface;
	}




	HttpServletRequest request=ServletActionContext.getRequest();
	
	public String add(){
		 
		Admin admin = new Admin();
	   String adminID=((Admin) request.getSession().getAttribute("admin")).getAdminID();
	   admin.setAdminID(adminID);
		notice.setAdmin(admin);
		notice.setReleaseTime(util.getNowTime());
		String str=noticeInterface.add(notice);
		if(str!=null){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String delete(){
		 
		if(noticeInterface.delete(notice)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	
	public String update(){
		 
		if(noticeInterface.update(notice)!=0){
			return "success";
		}
		else{
			return "error";
		}
	}
	

	
	public void search() throws IOException{
		 
		List<Notice> list=noticeInterface.search();
		JSONArray json = JSONArray.fromObject(list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(json.toString());
		pw.close();
		pw.flush();			
	}
	
	public String noticelook() throws IOException{
		
	   Notice Notice=noticeInterface.noticelook(notice);
		request.setAttribute("Notice",Notice);
		return "success";
	}


}
