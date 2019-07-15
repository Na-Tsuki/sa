package hjjf.scss.base;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibernateDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;
	
	@Override
	public Serializable save(T obj) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().save(obj);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T findByID(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}


	@Override
	public int delete(T obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(obj);
		return 1;
	}


	@Override
	public int delete(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(findByID(clazz,id));
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("from "+clazz.getSimpleName());
		return (List<T>)query.list();
	}
	

	@Override
	public int update(T obj) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(obj);
		return 1;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String hql) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery(hql);
		return (List<T>)query.list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String hql, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery(hql);
		for(int i=0;i<parmas.length;i++){
			query.setParameter(i,parmas[i]);
		}
		return (List<T>)query.list();
	}


	@Override
	public Object selectValue(String hql) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();		
		return session.createQuery(hql).uniqueResult();		
	}


	@Override
	public Object selectValue(String hql, Object[] parmas) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();		
		Query query = session.createQuery(hql);
		for (int i = 0; i < parmas.length; i++) {
			query.setParameter(i, parmas[i]);
		}
		return query.uniqueResult();
	}


	@Override
	public Long getPageCount(String hql, int perCount) {
		// TODO Auto-generated method stub
		String chql = "select count(*) " + hql;
		Object cnt = selectValue(chql);
		Long objCnt = (Long) cnt;
		long pageCount = 0;
		if (objCnt % perCount == 0)
			pageCount = objCnt / perCount;
		else
			pageCount = objCnt / perCount + 1;		
		return pageCount;
	}


	@Override
	public Long getPageCount(String hql, Object[] parmas, int perCount) {
		// TODO Auto-generated method stub
		String chql = "select count(*) " + hql;
		Object cnt = selectValue(chql,parmas);
		Long objCnt = (Long) cnt;
		long pageCount = 0;
		if (objCnt % perCount == 0)
			pageCount = objCnt / perCount;
		else
			pageCount = objCnt / perCount + 1;		
		return pageCount;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectPage(String hql, int perCount, int index) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery(hql);
		query.setFirstResult((index-1)*perCount);
		query.setMaxResults(perCount);
		return (List<T>)query.list();		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectPage(String hql, Object[] parmas, int perCount,
			int index) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();	
		Query query = session.createQuery(hql);
		for (int i = 0; i < parmas.length; i++) {
			query.setParameter(i, parmas[i]);
		}
		query.setFirstResult((index-1)*perCount);
		query.setMaxResults(perCount);
		return (List<T>)query.list();		
	}
	
	/*******************Seter/Geter*****************************/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}





	

	

}
