/*
 * Copyright (c) 2008, 2009, 2011 Oracle, Inc. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.  The Eclipse Public License is available
 * at http://www.eclipse.org/legal/epl-v10.html and the Eclipse Distribution License
 * is available at http://www.eclipse.org/org/documents/edl-v10.php.
 */
package javax.persistence.criteria;

import javax.persistence.metamodel.Attribute;

/**
 * A join to an entity, embeddable, or basic type.
 *
 * @param <Z> the source type of the join
 * @param <X> the target type of the join
 * @since Java Persistence 2.0
 */
public interface Join<Z, X> extends From<Z, X> {
	/**
	 * Modify the join to restrict the result according to the
	 * specified ON condition. Replaces the previous ON condition,
	 * if any.
	 * Return the join object
	 * @param restriction a simple or compound boolean expression
	 * @return the modified join object
	 */
	Join<Z, X> on(Expression<Boolean> restriction);

	/**
	 * Modify the join to restrict the result according to the
	 * specified ON condition. Replaces the previous ON condition,
	 * if any.
	 * Return the join object
	 * @param restrictions zero or more restriction predicates
	 * @return the modified join object
	 */
	Join<Z, X> on(Predicate... restrictions);

	/**
	 * Return the predicate that corresponds to the ON
	 * restriction(s) on the join, or null if no ON condition
	 * has been specified.
	 * @return the ON restriction predicate
	 */
	Predicate getOn();

	/**
	 * Return the metamodel attribute corresponding to the join.
	 *
	 * @return metamodel attribute corresponding to the join
	 */
	Attribute<? super Z, ?> getAttribute();

	/**
	 * Return the parent of the join.
	 *
	 * @return join parent
	 */
	From<?, Z> getParent();

	/**
	 * Return the join type.
	 *
	 * @return join type
	 */
	JoinType getJoinType();
}
