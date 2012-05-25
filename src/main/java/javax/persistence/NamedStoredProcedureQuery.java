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

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies and names a stored procedure, its parameters, and its result type.
 *
 * The NamedStoredProcedureQuery annotation can be applied to an entity or mapped superclass.
 *
 * The name element is the name that is passed as an argument to the
 * {@link EntityManager#createNamedStoredProcedureQuery(String)} method to create an executable
 * StoredProcedureQuery object. Names are scoped to the persistence unit.
 *
 * The procedureName element is the name of the stored procedure in the database.
 *
 * The parameters of the stored procedure are specified by the parameters element. All
 * parameters must be specified in the order in which they occur in the parameter list of the
 * stored procedure.
 *
 * The resultClasses element refers to the class (or classes) that are used to map the results. The
 * resultSetMappings element names one or more result set mappings, as defined by the
 * {@link SqlResultSetMapping} annotation.
 *
 * If there are multiple result sets, it is assumed that they will be mapped using the same
 * mechanism — e.g., either all via a set of result class mappings or all via a set of result
 * set mappings. The order of the specification of these mappings must be the same as the order in
 * which the result sets will be returned by the stored procedure invocation. If the stored procedure
 * returns one or more result sets and no resultClasses or resultSetMappings element is specified,
 * any result set will be returned as a list of type Object[]. The combining of different strategies
 * for the mapping of stored procedure result sets is undefined.
 *
 * The hints element may be used to specify query properties and hints. Properties defined by this
 * specification must be observed by the provider. Vendor-specific hints that are not recognized
 * by a provider must be ignored.
 *
 * All parameters of a named stored procedure query must be specified using the StoredProcedureParameter
 * annotation.
 *
 * @since Java Persistence 2.1
 *
 * @see StoredProcedureQuery
 * @see StoredProcedureParameter
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface NamedStoredProcedureQuery {
	/**
	 * The name used to refer to the query with the {@link EntityManager} methods that create stored
	 * procedure query objects.
	 */
	String name();

	/**
	 * The name of the stored procedure in the database.
	 */
	String procedureName();

	/**
	 * Information about all parameters of the stored procedure.
	 */
	StoredProcedureParameter[] parameters() default {};

	/**
	 * The class or classes that are used to map the results.
	 */
	Class[] resultClasses() default {};

	/**
	 *  The names of one or more result set mappings, as defined in metadata.
	 */
	String[] resultSetMappings() default {};

	/**
	 * Query properties and hints.
	 */
	QueryHint[] hints() default {};
}

