package lk.health.phd.cd.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lk.health.phd.cd.dao.UniversalDao;

/**
 * @author admin
 *
 * @param <T>
 */
public class UniversalDaoImpl<T extends Serializable> implements UniversalDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	/**
	 * {@inheritDoc}
	 */
	public Long save(T object) {
		Session session = getCurrentSession();
		return (Long) session.save(object);
	}

	/**
	 * ({@inheritDoc}
	 */
	public void update(T object) {
		Session session = getCurrentSession();
		session.update(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void merge(T object) {
		Session session = getCurrentSession();
		session.merge(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(T object) {
		Session session = getCurrentSession();
		session.delete(object);
	}

	/**
	 * Get the current session.
	 * 
	 * @return {@linkplain Session}
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
