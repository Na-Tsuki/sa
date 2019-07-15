package hjjf.scss.impl;

import java.util.List;

import hjjf.scss.dao.NoticeDao;
import hjjf.scss.model.Notice;
import hjjf.scss.service.NoticeInterface;

public class NoticeMgrImpl implements NoticeInterface {
	
	private NoticeDao noticeDao;
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public String add(Notice not) {
		// TODO Auto-generated method stub
		return String.valueOf(noticeDao.save(not));
	}

	@Override
	public int delete(Notice not) {
		// TODO Auto-generated method stub
		return noticeDao.delete(not);
	}

	@Override
	public int update(Notice not) {
		// TODO Auto-generated method stub
		Notice notice = (Notice) noticeDao.findByID(Notice.class, not.getID());
		notice.setNoticeTitle(not.getNoticeTitle());
		notice.setNoticeContent(not.getNoticeContent());
		notice.setReleaseTime(not.getReleaseTime());
		notice.setRemark(not.getRemark());
		return noticeDao.update(notice);
	}

	@Override
	public List<Notice> search() {
		// TODO Auto-generated method stub
		String hql = "from Notice";
		return noticeDao.select(hql);
	}
	
	@Override
	public Notice noticelook(Notice not) {
		// TODO Auto-generated method stub	
		return (Notice)noticeDao.findByID(Notice.class, not.getID());
	}

	
}
