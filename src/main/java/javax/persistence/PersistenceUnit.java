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
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Expresses a dependency on an {@link EntityManagerFactory} and its
 * associated persistence unit.
 *
 * @since Java Persistence 1.0
 */
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface PersistenceUnit {
	/**
	 * (Optional) The name by which the entity manager factory is to be accessed
	 * in the environment referencing context;  not needed when
	 * dependency injection is used.
	 */
	String name() default "";

	/**
	 * (Optional) The name of the persistence unit as defined in the
	 * <code>persistence.xml</code> file. If specified, the
	 * persistence unit for the entity manager factory that is
	 * accessible in JNDI must have the same name.
	 */
	String unitName() default "";
}
