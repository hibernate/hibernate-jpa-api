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

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Supports composite map keys that reference entities.
 * <p> The <code>MapKeyJoinColumns</code> annotation groups
 * <code>MapKeyJoinColumn</code> annotations.  When the
 * <code>MapKeyJoinColumns</code> annotation is used, both the
 * <code>name</code> and the <code>referencedColumnName</code>
 * elements must be specified in each of the grouped
 * <code>MapKeyJoinColumn</code> annotations.
 *
 * @see MapKeyJoinColumn
 *
 * @since Java Persistence 2.0
 */
@Target( { METHOD, FIELD })
@Retention(RUNTIME)
public @interface MapKeyJoinColumns {
	/**
	 * (Required) The map key join columns that are used to map to the entity
	 * that is the map key.
	 */
	MapKeyJoinColumn[] value();

	/**
	 * (Optional) The foreign key constraint specification for the join columns. This is used only if table generation
	 * is in effect.  Default is provider defined.
	 *
	 * @return The foreign key specification
	 */
	ForeignKey foreignKey() default @ForeignKey();
}
