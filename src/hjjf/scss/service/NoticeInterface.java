package hjjf.scss.service;

import hjjf.scss.model.Notice;

import java.util.List;

public interface NoticeInterface {
	String add(Notice not);
	int delete(Notice not);
	int update(Notice not);
	List<Notice> search();
	Notice noticelook(Notice not);
}
