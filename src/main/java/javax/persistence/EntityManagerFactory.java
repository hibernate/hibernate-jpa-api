/*
 * Copyright (c) 2008, 2009, 2011 Oracle, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.  The Eclipse Public License is available
 * at http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution License
 * is available at http://www.eclipse.org/org/documents/edl-v10.php.
 */
package javax.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.Map;

/**
 * Interface used to interact with the entity manager factory
 * for the persistence unit.
 *
 * <p>When the application has finished using the entity manager
 * factory, and/or at application shutdown, the application should
 * close the entity manager factory.  Once an
 * <code>EntityManagerFactory</code> has been closed, all its entity managers
 * are considered to be in the closed state.
 *
 * @since Java Persistence 1.0
 */
public interface EntityManagerFactory {

	/**
	 * Create a new application-managed <code>EntityManager</code>.  This method returns a new
	 * code>EntityManager</code> instance each time it is invoked.  The <code>isOpen</code> method will return true
	 * on the returned instance.
	 *
	 * @return entity manager instance
	 *
	 * @throws IllegalStateException if the entity manager factory has been closed
	 */
	public EntityManager createEntityManager();

	/**
	 * Create a new application-managed <code>EntityManager</code> with the
	 * specified Map of properties.  This method returns a new <code>EntityManager</code> instance each time
	 * it is invoked.  The <code>isOpen</code> method will return true on the returned instance.
	 *
	 * @param map properties for entity manager
	 *
	 * @return entity manager instance
	 *
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 */
	public EntityManager createEntityManager(Map map);

	/**
	 * Create a new JTA application-managed EntityManager with the specified synchronization type.  This method
	 * returns a new EntityManager instance each time it is invoked.  The isOpen method will return true on the
	 * returned instance.
	 *
	 * @param synchronizationType how and when the entity manager should be synchronized with the current JTA
	 * transaction
	 *
	 * @return entity manager instance
	 *
	 * @throws IllegalStateException if the entity manager factory has been configured for resource-local entity
	 * managers or has been closed
	 */
	public EntityManager createEntityManager(SynchronizationType synchronizationType);

	/**
	 * Create a new JTA application-managed EntityManager with the specified synchronization type and Map of properties.
	 * This method returns a new EntityManager instance each time it is invoked.  The isOpen method will return true
	 * on the returned instance.
	 *
	 * @param synchronizationType how and when the entity manager
	 * should be synchronized with the current JTA transaction
	 * @param map properties for entity manager; may be null
	 *
	 * @return entity manager instance
	 *
	 * @throws IllegalStateException if the entity manager factory has been configured for resource-local entity
	 * managers or has been closed
	 */
	public EntityManager createEntityManager(SynchronizationType synchronizationType, Map map);

	/**
	 * Return an instance of <code>CriteriaBuilder</code> for the creation of
	 * <code>CriteriaQuery</code> objects.
	 * @return CriteriaBuilder instance
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 *
	 * @since Java Persistence 2.0
	 */
	public CriteriaBuilder getCriteriaBuilder();

	/**
	 * Return an instance of <code>Metamodel</code> interface for access to the
	 * metamodel of the persistence unit.
	 * @return Metamodel instance
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 *
	 * @since Java Persistence 2.0
	 */
	public Metamodel getMetamodel();

	/**
	 * Indicates whether the factory is open. Returns true
	 * until the factory has been closed.
	 * @return boolean indicating whether the factory is open
	 */
	public boolean isOpen();

	/**
	 * Close the factory, releasing any resources that it holds.
	 * After a factory instance has been closed, all methods invoked
	 * on it will throw the <code>IllegalStateException</code>, except
	 * for <code>isOpen</code>, which will return false. Once an
	 * <code>EntityManagerFactory</code> has been closed, all its
	 * entity managers are considered to be in the closed state.
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 */
	public void close();

	/**
	 * Get the properties and associated values that are in effect
	 * for the entity manager factory. Changing the contents of the
	 * map does not change the configuration in effect.
	 * @return properties
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 *
	 * @since Java Persistence 2.0
	 */
	public Map<String, Object> getProperties();

	/**
	 * Access the cache that is associated with the entity manager
	 * factory (the "second level cache").
	 * @return instance of the <code>Cache</code> interface
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 *
	 * @since Java Persistence 2.0
	 */
	public Cache getCache();

	/**
	 * Return interface providing access to utility methods
	 * for the persistence unit.
	 * @return <code>PersistenceUnitUtil</code> interface
	 * @throws IllegalStateException if the entity manager factory
	 * has been closed
	 *
	 * @since Java Persistence 2.0
	 */
	public PersistenceUnitUtil getPersistenceUnitUtil();

	/**
	 * Define the query, typed query, or stored procedure query as
	 * a named query such that future query objects can be created
	 * from it using the createNamedQuery methods.
	 * Any configuration of the query object (except for actual
	 * parameter binding) in effect when the named query is added
	 * is retained as part of the named query definition.
	 * This includes configuration information such as max results,
	 * hints, flush mode, lock mode, result set mapping information,
	 * and information about stored procedure parameters.
	 * When the query is executed, information that can be set
	 * by means of the Query API can be overridden. Information
	 * that is overridden does not affect the named query as
	 * registered with the entity manager factory, and thus does
	 * not affect subsequent query objects created from it by
	 * means of the createNamedQuery method.
	 * If a named query of the same name has been previously
	 * defined, either statically via metadata or via this method,
	 * that query definition is replaced.
	 *
	 * @param name name for the query
	 * @param query Query, TypedQuery, or StoredProcedureQuery object
	 *
	 * @since Java Persistence 2.1
	 */
	public void addNamedQuery(String name, Query query);

	/**
	 * Return an object of the specified type to allow access to the
	 * provider-specific API. If the provider's EntityManagerFactory
	 * implementation does not support the specified class, the
	 * PersistenceException is thrown.
	 *
	 * @param cls the class of the object to be returned. This is
	 * normally either the underlying EntityManagerFactory
	 * implementation class or an interface that it implements.
	 *
	 * @return an instance of the specified class
	 *
	 * @throws PersistenceException if the provider does not
	 * support the call
	 */
	public <T> T unwrap(Class<T> cls);

	/**
	 * Add a named copy of the EntityGraph to the
	 * EntityManagerFactory. If an entity graph with the same name
	 * already exists, it is replaced.
	 *
	 * @param graphName name for the entity graph
	 * @param entityGraph entity graph
	 *
	 * @since JPA 2.1
	 */
	public <T> void addNamedEntityGraph(String graphName, EntityGraph<T> entityGraph);

}
