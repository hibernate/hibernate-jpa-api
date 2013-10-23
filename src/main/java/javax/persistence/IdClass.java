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
 * Specifies a composite primary key class that is mapped to
 * multiple fields or properties of the entity.
 *
 * <p> The names of the fields or properties in the primary key
 * class and the primary key fields or properties of the entity
 * must correspond and their types must be the same.
 *
 * <pre>
 *
 *   Example:
 *
 *   &#064;IdClass(com.acme.EmployeePK.class)
 *   &#064;Entity
 *   public class Employee {
 *      &#064;Id String empName;
 *      &#064;Id Date birthDay;
 *      ...
 *   }
 * </pre>
 *
 * @since Java Persistence 1.0
 */
@Target({TYPE})
@Retention(RUNTIME)

public @interface IdClass {

	/** Primary key class */
	Class value();
}
