/**
 * @version $Id: Message.java,v 1.0 $
 */
package zoo.textui.habitat;

/**
 * Messages.
 */
public class Message {
	/**
	 * @return string prompting for an habitat identifier
	 */
	public static final String keyReq() {
		return "Identificador do habitat: ";
	}

	/**
	 * @return string prompting for an habitat name
	 */
	public static final String nameReq() {
		return "Nome do habitat: ";
	}

	/**
	 * @return string prompting for the area of an habitat
	 */
	public static final String areaReq() {
		return "Área do habitat: ";
	}

	/**
	 * @return string prompting for the new area of an habitat
	 */
	public static final String requestNewArea(int area) {
		return "A nova área do habitat passa a ser (era " + area + "): ";
	}

	/**
	 * @param id
	 *            habitat id
	 * @return string reporting a duplicate habitat
	 */
	public static final String duplicateHabitat(String id) {
		return "Habitat '" + id + "' já existe.";
	}

	/**
	 * @return string requesting the direction of the influences
	 */
	public static final String requestSense() {
		return "Qual o tipo de influência? (POS ou NEG): ";
	}

	/**
	 * @return string prompting for a tree identifier
	 */
	public static final String treeKeyReq() {
		return "Identificador da árvore: ";
	}

	/**
	 * @param id
	 *            tree id
	 * @return string reporting a duplicate tree
	 */
	public static final String duplicateTree(String id) {
		return "Tree '" + id + "' já existe.";
	}

	/**
	 * @return string prompting for a tree name
	 */
	public static final String treeNameReq() {
		return "Nome da árvore: ";
	}

	/**
	 * @return string prompting for a tree cleaning difficulty
	 */
	public static final String treeDifficultyReq() {
		return "Dificuldade de limpeza da árvore: ";
	}

	/**
	 * @return string prompting for the tree type
	 */
	public static final String requestTreeType() {
		return "Tipo de árvore: (CADUCA ou PERENE)";
	}

	/**
	 * @param idHabitat
	 *            the habitat identifier
	 * @param idSpecies
	 *            the species identifier
	 * @return string with warning message.
	 */
	public static final String noAssociation(String idHabitat, String idSpecies) {
		return "Não existe  associação entre o habitat '" + idHabitat + "' e a espécie'" + idSpecies + "' ";
	}

	/**
	 * @return string prompting for the new biological situation of a tree
	 */
	public static final String treeNewBiological() {
		return "A nova situação biológica passa a ser: ";
	}

	/**
	 * @return "CADUCA"
	 */
	public static final String caduca() {
		return "CADUCA";
	}

	/**
	 * @return "PERENE"
	 */
	public static final String perene() {
		return "PERENE";
	}

	/**
	 * @return "COMFOLHAS"
	 */
	public static final String withLeaves() {
		return "COMFOLHAS";
	}

	/**
	 * @return "SEMFOLHAS"
	 */
	public static final String withoutLeaves() {
		return "SEMFOLHAS";
	}

	/**
	 * @return "LARGARFOLHAS"
	 */
	public static final String fallingLeaves() {
		return "LARGARFOLHAS";
	}

	/**
	 * @return "GERARFOLHAS"
	 */
	public static final String growingLeaves() {
		return "GERARFOLHAS";
	}

	/**
	 * @return "HABITAT"
	 */
	public static final String habitat() {
		return "HABITAT";
	}

	/**
	 * @return "TREE"
	 */
	public static final String tree() {
		return "TREE";
	}

	/**
	 * @return "POS"
	 */
	public static final String positive() {
		return "POS";
	}

	/**
	 * @return "NEG"
	 */
	public static final String negative() {
		return "NEG";
	}

}