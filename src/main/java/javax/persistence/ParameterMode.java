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
 * Specifies the mode of a parameter of a stored procedure query.
 *
 * @since Java Persistence 2.1
 *
 * @see StoredProcedureQuery
 * @see StoredProcedureParameter
 */
public enum ParameterMode {
	/**
	 * Stored procedure input parameter
	 */
	IN,
	/**
	 * Stored procedure input/output parameter
	 */
	INOUT,
	/**
	 * Stored procedure output parameter
	 */
	OUT,
	/**
	 * Stored procedure reference cursor parameter.
	 */
	REF_CURSOR
}
