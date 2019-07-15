package hjjf.scss.model;

public class Audit {
	private int ID;
	private TeachTask teachTask;
	private String AuditDate;
	private Admin admin;
	private String Remark;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public TeachTask getTeachTask() {
		return teachTask;
	}

	public void setTeachTask(TeachTask teachTask) {
		this.teachTask = teachTask;
	}

	public String getAuditDate() {
		return AuditDate;
	}

	public void setAuditDate(String auditDate) {
		AuditDate = auditDate;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}
}
