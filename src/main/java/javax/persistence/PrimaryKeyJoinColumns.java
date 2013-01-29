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
 * Groups {@link PrimaryKeyJoinColumn} annotations.
 * It is used to map composite foreign keys.
 *
 * <pre>
 *    Example: ValuedCustomer subclass
 *
 *    &#064;Entity
 *    &#064;Table(name="VCUST")
 *    &#064;DiscriminatorValue("VCUST")
 *    &#064;PrimaryKeyJoinColumns({
 *        &#064;PrimaryKeyJoinColumn(name="CUST_ID",
 *            referencedColumnName="ID"),
 *        &#064;PrimaryKeyJoinColumn(name="CUST_TYPE",
 *            referencedColumnName="TYPE")
 *    })
 *    public class ValuedCustomer extends Customer { ... }
 * </pre>
 *
 * @since Java Persistence 1.0
 */
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface PrimaryKeyJoinColumns {
	/**
	 * One or more <code>PrimaryKeyJoinColumn</code> annotations.
	 */
	PrimaryKeyJoinColumn[] value();

	/**
	 * (Optional) The foreign key constraint specification for the join columns. This is used only if table generation
	 * is in effect.  Default is provider defined.
	 *
	 * @return The foreign key specification
	 */
	ForeignKey foreignKey() default @ForeignKey();
}
