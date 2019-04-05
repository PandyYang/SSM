package com.gyf.bos.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.gyf.bos.utils.PageBean;

public class BaseDaoImpl<T>  implements IBaseDao<T> {

	private Class<T> entityClass;
	
	
	@Autowired
	@Qualifier("hibernateTemplate")
	
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		
	
		Type[] types = genericSuperclass.getActualTypeArguments();
	
		entityClass = (Class<T>) types[0];		
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql = "FROM " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	/**这是一个通用的更新方法，queryName是需要在user.hbm.xml文件中配置的
	 * user.hbm.xml：
	 * <query name="editPassword">UPDATE User SET password = ? WHERE id = ?</query>
	 * */
	public void excuteUpdate(String queryName, Object... objs) {
		// TODO Auto-generated method stub
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		Query query = session.getNamedQuery(queryName);
		
		int i = 0;
		for(Object obj : objs){
			query.setParameter(i, obj);
			i++;
		}
		
		query.executeUpdate();
	}

	@Override
	public void pageQuery(PageBean pb) {
		// TODO Auto-generated method stub
		int crrentPage = pb.getCurrentPage();
		int pageSize = pb.getPageSize();
		
		//查询的封闭对象
		DetachedCriteria criteria = pb.getDetachedCriteria();
		
		//查询总记录数
		criteria.setProjection(Projections.rowCount());//获取总记录数据,内部会变成sql语句
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
		Long total = list.get(0);
		pb.setTotal(total.intValue());
		
		
		//查询当前页数据
		criteria.setProjection(null);//清除前面的查询条件
		criteria.setResultTransformer(DetachedCriteria.ROOT_ENTITY);//重置hql
		List rows = this.getHibernateTemplate().findByCriteria(criteria, (crrentPage - 1) * pageSize, pageSize);
	
		pb.setRows(rows);
	}

	@Override
	public List<T> findListByDetachedCriteria(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().findByCriteria(dc);
	}

}
