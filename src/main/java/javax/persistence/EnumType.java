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

/**
 * Defines mapping for enumerated types.  The constants of this
 * enumerated type specify how a persistent property or
 * field of an enumerated type should be persisted.
 *
 * @since Java Persistence 1.0
 */
public enum EnumType {
	/** Persist enumerated type property or field as an integer. */
	ORDINAL,

	/** Persist enumerated type property or field as a string. */
	STRING
}
