/**
 * @version $Id: UnknownAnimalKeyException.java, v 1.0 $
 */
package zoo.textui.animal;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown animal identifiers.
 */
@SuppressWarnings("nls")
public class UnknownAnimalKeyException extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;
	/**
	 * @param id
	 *            Unknown animal id to report.
	 */
	public UnknownAnimalKeyException(String id) {
		super("Não existe nenhum animal identificado por '" + id + "'");
	}

}
