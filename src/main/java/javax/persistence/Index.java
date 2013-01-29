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
 * The Index annotation is used in schema generation. Note that it is not necessary to specify an index
 * for a primary key, as the primary key index will be created automatically, however, the Index annotation
 * may be used to specify the ordering of the columns in the index for the primary key.
 *
 * @since JPA 2.1
 */
@Target({}) @Retention(RUNTIME)
public @interface Index {
	/**
	 * (Optional) The name of the index.  Defaults to a provider-generated value.
	 *
	 * @return The index name
	 */
	String name() default "";

	/**
	 * (Required) The names of the columns to be included in the index.
	 *
	 * @return The names of the columns making up the index
	 */
	String columnList();

	/**
	 * (Optional) Whether the index is unique.  Default is false.
	 *
	 * @return Is the index unique?
	 */
	boolean unique() default false;
}
