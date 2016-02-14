package zoo.backend.habitat;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.habitat.Message.*;

/**
 * Evergreen Tree does not have different biological cycles
 * @see zoo.backend.habitat.Tree
 */
public class Evergreen extends Tree implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * toString
	 */
	public String toString() {
		return tree() + "|" + getKey() + "|" + getName() + "|" + getCleanDifficulty() + "|" + perene();
	}
	
	/**
	 * Constructor
	 * @see zoo.backend.habitat.Tree
	 */
	public Evergreen(String key, String name, int cleandifficulty) {
		super(key, name, cleandifficulty, perene());
	}
	
}
