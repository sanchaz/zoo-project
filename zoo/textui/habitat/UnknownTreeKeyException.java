/**
 * @version $Id: UnknownTreeKeyException.java,v 1.0 $
 */
package zoo.textui.habitat;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown suppliers.
 */
@SuppressWarnings("nls")
public class UnknownTreeKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;

	/**
	 * @param id
	 *            Unknown tree id to report.
	 */
	public UnknownTreeKeyException(String id) {
		super("Não existe nenhuma árvore identificada por '" + id + "'");
	}

}
