/**
 * @version $Id: Message.java,v 1.0 $
 */
package zoo.textui.animal;

/**
 * Messages.
 */
public class Message {
	/**
	 * @return string prompting for an animal identifier
	 */
	public static final String animalKeyReq() {
		return "Identificador do animal: ";
	}

	/**
	 * @return string prompting for a species identifier
	 */
	public static final String speciesKeyReq() {
		return "Identificador da espécie: ";
	}

	/**
	 * @return string prompting for an animal name
	 */
	public static final String animalNameReq() {
		return "Nome do animal: ";
	}

	/**
	 * @return string prompting for a species name
	 */
	public static final String speciesNameReq() {
		return "Nome da espécie: ";
	}

	/**
	 * @return string prompting for a speech sentence
	 */
	public static final String speechReq() {
		return "Fala do animal: ";
	}

	/**
	 * @return string prompting for an habitat identifier
	 */
	public static final String habitatKeyReq() {
		return "Identificador do novo habitat: ";
	}


	/**
	 * @param id
	 *            animal id
	 * @return string reporting a duplicate animal identifier
	 */
	public static final String duplicateAnimal(String id) {
		return "Animal '" + id + "' já existe.";
	}

	/**
	 * @return string "ANIMAL".
	 */
	public static final String animal() {
		return "ANIMAL";
	}

	/**
	 * @return string "..Atchim".
	 */
	public static final String atchim() {
		return "..Atchim";
	}

	/**
	 * @return string "RR..".
	 */
	public static final String catarro() {
		return "RR..";
	}
}