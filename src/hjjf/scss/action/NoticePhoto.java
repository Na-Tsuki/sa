package hjjf.scss.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NoticePhoto extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File upload;    //editorĬ�ϵ��ϴ����ı�ǩ��Ϊupload
    private String uploadContentType;
    private String uploadFileName;
    @SuppressWarnings("resource")
	public String NoticePhoto() throws Exception{
        HttpServletResponse response = ServletActionContext.getResponse();    
        response.setCharacterEncoding("GBK");    
        PrintWriter out = response.getWriter();  

        String realPath=ServletActionContext.getServletContext().getRealPath("/admin/noticephoto");
        File file = new File(realPath);
		if (!file.exists()) {
			file.mkdir();
		}
        // CKEditor�ύ�ĺ���Ҫ��һ������    
        String callback = ServletActionContext.getRequest().getParameter("CKEditorFuncNum"); 
        //request.put("callback", callback);

        FileOutputStream fout=new FileOutputStream(new File(file,getUploadFileName()));

        FileInputStream in=new FileInputStream(getUpload());

        byte[] buffer=new byte[1024];
        int len=0;
        while((len=in.read(buffer))>0)
            fout.write(buffer,0,len);
        //���ء�ͼ��ѡ�������ʾԤ��ͼƬ
        //һ��Ҫ�����ر�֮ǰд�������仰������ͼƬ��ʾ��������Ҳ������
        out.println("<script type=\"text/javascript\">");    
        out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + ServletActionContext.getRequest().getContextPath() + "/admin/noticephoto/" + uploadFileName + "','')");    
        out.println("</script>");

        out.close();
        in.close();

        return SUCCESS;
    }
    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}