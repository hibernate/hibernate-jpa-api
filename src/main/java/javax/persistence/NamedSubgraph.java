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

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The NamedSubgraph annotation is used to further define an attribute node.  It is referenced by its name from
 * the subgraph or keySubgraph element of a NamedAttributeNode element.
 *
 * @since JPA 2.1
 */
@Target({}) @Retention(RUNTIME)
public @interface NamedSubgraph {
	/**
	 * The name element is the name used to reference the subgraph from a NamedAttributeNode definition. In the case
	 * of entity inheritance, multiple subgraph elements have the same name.
	 */
	String name();

	/**
	 * The type element must be specified when the subgraph corresponds to a subclass of the entity type corresponding
	 * to the referencing attribute node.
	 */
	Class type() default void.class;

	/**
	 * Lists attributes of the class that must be included.  If the subgraph corresponds to a subclass of the class
	 * referenced by the corresponding attribute node, only subclass-specific attributes are listed.
	 */
	NamedAttributeNode[] attributeNodes();
}
