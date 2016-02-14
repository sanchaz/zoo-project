/**
 * @version $Id: UnknownKeyException.java,v 1.0 $
 */
package zoo.textui.employee;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown product identifiers.
 */
@SuppressWarnings("nls")
public class UnknownKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;


	/**
	 * @param id
	 *            Unknown employee id to report.
	 */
	public UnknownKeyException(String id) {
		super("Não existe nenhum empregado identificado por '" + id + "'");
	}

}
