/**
 * @version $Id: UnknownKeyException.java,v 1.0 $
 */
package zoo.textui.habitat;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown suppliers.
 */
@SuppressWarnings("nls")
public class UnknownKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;

	/**
	 * @param id
	 *            Unknown habitat id to report.
	 */
	public UnknownKeyException(String id) {
		super("Não existe nenhum habitat identificado por '" + id + "'");
	}

}
