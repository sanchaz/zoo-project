/**
 * @version $Id: Message.java,v 1.0 $
 */
package zoo.textui.main;

/**
 * Messages.
 */
public class Message {

	/**
	 * @return string with prompt for filename to open.
	 */
	public static final String openFile() {
		return "Ficheiro a abrir: ";
	}

	/**
	 * @return string with "file not found" message.
	 */
	public static final String fileNotFound() {
		return "O ficheiro não existe.";
	}

	/**
	 * @param filename
	 * @return string with "file not found" message (more elaborate).
	 */
	public static final String fileNotFound(String filename) {
		return "O ficheiro '" + filename + "' não existe.";
	}

	/**
	 * @return string with a warning and a question.
	 */
	public static final String newSaveAs() {
		return "Ficheiro sem nome. " + saveAs();
	}

	/**
	 * @return string asking for a filename.
	 */
	public static final String saveAs() {
		return "Guardar ficheiro como: ";
	}

	/**
	 * @return string confirming that user wants to save.
	 */
	public static final String saveBeforeExit() {
		return "Guardar antes de fechar? ";
	}

}