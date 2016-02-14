/**
 * @version $Id: Message.java,v 1.0 $
 */
package zoo.textui.vaccine;

/**
 * Messages.
 */
public class Message {
	/**
	 * @return string prompting for vaccine id.
	 */
	public static final String idReq() {
		return "Identificador da vacina: ";
	}

	/**
	 * @return string prompting for a vaccine name.
	 */
	public static final String nameReq() {
		return "Nome da vacina: ";
	}

	/**
	 * @return string prompting for a veterinary id.
	 */
	public static final String vetReq() {
		return "Identficador do veterinário a ministrar a vacina: ";
	}

	/**
	 * @return string prompting for an animal id.
	 */
	public static final String animalReq() {
		return "Identificador do animal a vacinar: ";
	}

	/**
	 * @return string with boolean query.
	 */
	public static final String moreReq() {
		return "Adicionar nova espécie? (s/n) ";
	}

	/**
	 * @param id
	 *            vaccine id
	 * @return string reporting a duplicate vaccine id.
	 */
	public static final String duplicateVaccine(String id) {
		return "Vacina '" + id + "' já existe.";
	}

	/**
	 * @param idVac
	 *            the vaccine identifier
	 * @param idAnimal
	 *            the animal identifier
	 * @return string with warning message.
	 */
	public static final String wrongVaccine(String idVac, String idAnimal) {
		return "A vacina '" + idVac + "' não é apropiada para o animal '" + idAnimal + "'.";
	}

	/**
	 * @return "VACCINE-REG"
	 */
	public static final String vacOperation() {
		return "VACCINE-REG";
	}


	/**
	 * @return "VACINA"
	 */
	public static final String vaccine() {
		return "VACCINE";
	}

	/**
	 * @return "NÃO"
	 */
	public static final String no() {
		return "NÃO";
	}

	/**
	 * @return "SIM"
	 */
	public static final String yes() {
		return "SIM";
	}

}