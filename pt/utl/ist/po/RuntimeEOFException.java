/**
 * @version $Id: RuntimeEOFException.java,v 1.1 2008/10/19 15:27:23 david Exp $
 */
package pt.utl.ist.po;

/**
 * Class RuntimeEOFException.
 */

public class RuntimeEOFException extends RuntimeException {

	/**
	 * Serial number for serialization.
	 */
	static final long serialVersionUID = 200610291655L;

	/**
	 * Constructor.
	 */
	public RuntimeEOFException() {
		// intentionally left empty
	}

	/**
	 * Constructor.
	 * 
	 * @param msg
	 *            message describing the exception.
	 */
	public RuntimeEOFException(String msg) {
		super(msg);
	}

}