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
 * Specifies a parameter of a named stored procedure query. All parameters of a named stored procedure query must be specified.
 *
 * @since Java Persistence 2.1
 *
 * @see StoredProcedureQuery
 * @see ParameterMode
 */
@Target({})
@Retention(RUNTIME)
public @interface StoredProcedureParameter {
	/** The name of the parameter as defined by the stored procedure in the database. */
	String name() default "";

	/** Specifies whether the parameter is an IN, INOUT, OUT, or REF_CURSOR parameter. */
	ParameterMode mode() default ParameterMode.IN;

	/** JDBC type of the paramter. */
	Class type();
}
