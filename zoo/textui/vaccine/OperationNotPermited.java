/**
 * @version $Id: OperationNotPermited.java,v 1.0 $
 */
package zoo.textui.vaccine;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Exception for unknown identifiers.
 */
@SuppressWarnings("nls")
public class OperationNotPermited extends InvalidOperation {
	static final long serialVersionUID = 200910161102L;

	/**
	 * @param idSpecies
	 *            wrong species id to report.
	 */
	public OperationNotPermited(String idSpecies) {
		super("O veterinário não pode ministrar vacinas à espécie '" + idSpecies + "'");
	}

}
