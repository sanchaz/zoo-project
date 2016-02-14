/**
 * @version $Id: UnknownGroupKeyException.java, v 1.0 $
 */
package zoo.textui.animal;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown specie identifiers.
 */
@SuppressWarnings("nls")
public class UnknownGroupKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;
	/**
	 * @param id
	 *            Unknown species id to report.
	 */
	public UnknownGroupKeyException(String id) {
		super("Não existe nenhuma especie identificada por '" + id + "'");
	}

}
