/**
 * @version $Id: InvalidOperation.java,v 1.1 2008/10/19 15:27:23 david Exp $
 */
package pt.utl.ist.po.ui;

/**
 * This class represents events in unsuccessful operations.
 */
public class InvalidOperation extends Exception {

	/**
	 * Serial number for serialization.
	 */
	static final long serialVersionUID = 200610291601L;

	/**
	 * Constructor.
	 */
	public InvalidOperation() {
		// intentionally left empty
	}

	/**
	 * Constructor.
	 * 
	 * @param msg
	 *            message describing the exception.
	 */
	public InvalidOperation(String msg) {
		super(msg);
	}

	/**
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return Messages.invalidOperation(getMessage());
	}

}