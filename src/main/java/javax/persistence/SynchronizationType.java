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
 * Describes how a persistence context will be synchronized to the database in sync with JTA transactions
 *
 * @since Java Persistence 2.1
 */
public enum SynchronizationType {
	/**
	 * Indicates the persistence context is automatically enlisted in (joined to) the current JTA transaction.
	 */
	SYNCHRONIZED,
	/**
	 * Indicates the persistence context is not enlisted in any JTA transaction unless explicitly joined to that
	 * transaction by invocation of the EntityManager {@link EntityManager#joinTransaction} method. The persistence
	 * context remains joined to the transaction until the transaction commits or rolls back. After the transaction
	 * commits or rolls back, the persistence context will not be joined to any subsequent transaction unless the
	 * joinTransaction method is invoked in the scope of that subsequent transaction.
	 *
	 * Such a persistence context must not be flushed to the database unless it is joined to a transaction. The
	 * application's use of queries with pessimistic locks,  bulk update or delete queries, etc. result in the
	 * provider throwing {@link TransactionRequiredException}.  After the persistence context has been joined to the
	 * JTA transaction, these operations are again allowed.
	 */
	UNSYNCHRONIZED
}
