package hjjf.scss.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	
	Serializable save(T obj);
	
	T findByID(Class<T> clazz,Serializable id);
	
	int	delete(T obj);
	
	int delete(Class<T> clazz, Serializable id);
	
	int update(T obj);
	
	List<T> findAll(Class<T> clazz);
	
	List<T> select(String hql);
	
	List<T> select(String hql,Object[] parmas);
	
	Object selectValue(String hql);
	
	Object selectValue(String hql,Object[] parmas);		
	
	Long getPageCount(String hql,int perCount);
	
	Long getPageCount(String hql,Object[] parmas,int perCount);
	
	List<T> selectPage(String hql,int perCount,int index);
	
	List<T> selectPage(String hql,Object[] parmas,int perCount,int index);
}
