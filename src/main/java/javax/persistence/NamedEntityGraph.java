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
 * The NamedEntityGraph annotation is used to define a named entity graph.  The entity graph may be retrieved by name
 * using the EntityManagerFactory interface.  The entity graph may be used to specify the path and boundaries for find
 * operations or queries.  The NamedEntityGraph annotation must be applied to the entity class that forms the root of
 * the corresponding graph of entities.
 *
 * @since JPA 2.1
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface NamedEntityGraph {
	/**
	 * The name element is used to refer to the entity graph. It defaults to the entity name of the root entity to
	 * which the annotation is applied. Entity graph names must be unique within the persistence unit.
	 */
	String name() default "";

	/**
	 * The attributeNodes element lists attributes of the annotated entity class that are to be included in the
	 * entity graph.
	 */
	NamedAttributeNode[] attributeNodes() default {};

	/**
	 * The includeAllAttributes element specifies that all attributes of the annotated entity class are to be
	 * included in the entity graph.  An attributeNode element may still be used in conjunction with this element to
	 * specify a subgraph for the attribute.
	 */
	boolean includeAllAttributes() default false;

	/**
	 * The subgraphs element specifies a list of subgraphs, further specifying attributes that are managed types.
	 * These subgraphs are referenced by name from NamedAttributeNode definitions.
	 */
	NamedSubgraph[] subgraphs() default {};

	/**
	 * The subclassSubgraphs element specifies a list of subgraphs that add additional attributes for subclasses of
	 * the root entity to which the annotation is applied.
	 */
	NamedSubgraph[] subclassSubgraphs() default {};
}
