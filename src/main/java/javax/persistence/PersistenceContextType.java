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
 * Specifies whether a transaction-scoped or extended
 * persistence context is to be used in {@link PersistenceContext}.
 * If not specified, a transaction-scoped persistence context is used.
 *
 * @since Java Persistence 1.0
 */
public enum PersistenceContextType {

	/**
	 * Transaction-scoped persistence context
	 */
	TRANSACTION,

	/**
	 * Extended persistence context
	 */
	EXTENDED
}
