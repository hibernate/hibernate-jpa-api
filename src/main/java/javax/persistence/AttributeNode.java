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

import java.util.Map;

/**
 * Represents an attribute node of an entity graph.
 *
 * @param <T> The type of the attribute.
 *
 * @since JPA 2.1
 */
public interface AttributeNode<T> {
	/**
	 * Return the name of the attribute corresponding to the attribute node.
	 *
	 * @return name of the attribute
	 */
	public String getAttributeName();

	/**
	 * Return the Map<Class, Subgraph> of subgraphs associated with this attribute node.
	 *
	 * @return Map of subgraphs associated with this attribute node or empty Map if none have been defined
	 */
	public Map<Class, Subgraph> getSubgraphs();

	/**
	 * Return the Map<Class, Subgraph> of subgraphs associated with this attribute node's map key.
	 *
	 * @return Map of subgraphs associated with this attribute node's map key or empty Map if none have been defined
	 */
	public Map<Class, Subgraph> getKeySubgraphs();
}
