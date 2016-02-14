/**
 * @version $Id: UnknownIdException.java,v 1.0 $
 */
package zoo.textui.vaccine;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown identifiers.
 */
@SuppressWarnings("nls")
public class UnknownIdException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;

	/**
	 * @param id
	 *            Unknown vaccine id to report.
	 */
	public UnknownIdException(String id) {
		super("Não existe nenhuma vacina identificada por '" + id + "'");
	}

}
