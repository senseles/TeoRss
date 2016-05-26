package lt.teo.core.dao;

import java.util.List;

import org.hibernate.Query;

import lt.teo.core.model.Items;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<Items> findByParentId(int id) {
		Query query = getSession().getNamedQuery("Items.loadByParentId");
		query.setInteger("feeds", id);
		return (List<Items>) query.list();
	}

}
