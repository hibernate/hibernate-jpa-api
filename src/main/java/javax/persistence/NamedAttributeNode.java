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
 * The NamedAttributeNode annotation is used to specify an attribute node of within an entity graph or subgraph.
 *
 * @since JPA 2.1
 */
@Target({})
@Retention(RUNTIME)
public @interface NamedAttributeNode {
	/**
	 * Specifies the name of the corresponding attribute.
	 */
	String value();

	/**
	 * Refers to a NamedSubgraph specification that further characterizes an attribute node corresponding to a
	 * managed type (entity or embeddable). The value of the subgraph element must correspond to the name used for
	 * the subgraph in the NamedSubgraph element.  If the referenced attribute is an entity which has entity
	 * subclasses, there may be more than one NamedSubgraph element with this name, and the subgraph element is
	 * considered to refer to all of these.
	 */
	String subgraph() default "";

	/**
	 * Refers to a NamedSubgraph specification that further characterizes an attribute node corresponding to the
	 * key of a Map-valued attribute.  The value of the the keySubgraph element must correspond to the name used for
	 * the subgraph in the NamedSubgraph element.  If the referenced attribute is an entity which has entity
	 * subclasses, there may be more than one NamedSubgraph element with this name, and the keySubgraph element is
	 * considered to refer to all of these.
	 */
	String keySubgraph() default "";
}
