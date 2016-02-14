/**
 * @version $Id: Message.java,v 1.0 $
 */
package zoo.textui.employee;

/**
 * Messages.
 */
public class Message {
	/**
	 * @return string prompting for employee identifier
	 */
	public static final String keyReq() {
		return "Identificador do funcionário: ";
	}

	/**
	 * @return string prompting for employee name
	 */
	public static final String nameReq() {
		return "Nome do funcionário: ";
	}

	/**
	 * @param id
	 *            responsability id.
	 * @return string detailing problem
	 */
	public static final String noResponsability(String id) {
		return "Responsabilidade (habitat ou espécie) não atribuída: '" + id + "'.";
	}

	/**
	 * @param id
	 *            client id
	 * @return string reporting a duplicate employee identifier
	 */
	public static final String duplicateEmployee(String id) {
		return "Funcionário '" + id + "' já existe.";
	}

	/**
	 * @param id
	 *            employee type.
	 * @return string prompting for product removal.
	 */
	public static final String typeReq() {
		return "Tipo do funcionário? (VET ou KEEPER) ";
	}

	/**
	 * @return string repreenting veterinaries.
	 */
	public static final String veterinary() {
		return "VET";
	}

	/**
	 * @return string repreenting zookeepers.
	 */
	public static final String zookeeper() {
		return "KEEPER";
	}
}