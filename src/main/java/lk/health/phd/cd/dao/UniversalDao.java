package lk.health.phd.cd.dao;

/**
 * 
 * @author admin
 * 
 *         Interface class for common DB operations.
 *
 * @param <T>
 */
public interface UniversalDao<T> {
	/**
	 * Persist an object to DB.
	 * 
	 * @param object
	 *            Any object
	 * @return Id of the persisted record.
	 */
	Long save(T object);

	/**
	 * Update a persisted object.
	 * 
	 * @param object
	 *            Any object.
	 */
	void update(T object);

	/**
	 * Merges changes to a persisted object.
	 * 
	 * @param object
	 *            Any object.
	 */
	void merge(T object);

	/**
	 * Delete any persisted object.
	 * 
	 * @param object
	 *            Any object
	 */
	void delete(T object);

}
