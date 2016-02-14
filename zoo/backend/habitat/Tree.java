package zoo.backend.habitat;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.habitat.Message.*;

/**
 * Trees are used in habitats
 * They have a difficult cleaning parameter, that defines how diffcult it is to clean the tree's leaves
 * They can either be Decidous or Evergreen
 */
public abstract class Tree implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Trees unique key
	 */
	private String _key;
	/**
	 * Tree's name
	 */
	private String _name;
	/**
	 * Tree's type (either Decidous ("CADUCA") or Evergreen ("PERENE"))
	 */
	private String _type;
	/**
	 * Tree's clean diffculty
	 */
	private int _cleandifficulty;
	/**
	 * Habitat the tree is in
	 */
	private String _habitat;
	
	/**
	 * @return _key returns Tree's unique key
	 */
	public String getKey() {
		return _key;
	}
	
	/**
	 * @return _name returns Tree's name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return _type returns Tree type
	 */
	public String getType() {
		return _type;
	}
	
	/**
	 * @return _cleandifficulty returns Tree's clean difficulty
	 */
	public int getCleanDifficulty() {
		return _cleandifficulty;
	}
	
	/**
	 * @return _habitat returns the tree's habitat
	 */
	public String getHabitat() {
		return _habitat;
	}
	 
	/**
	* @param key The key of Habitat the Tree is in
	*/
	public void setHabitat(String key) {
		_habitat = key;
	}
	
	/**
	 * Constructor
	 */
	public Tree(String key, String name, int cleandifficulty, String type) {
		_key = key;
		_name = name;
		_cleandifficulty = cleandifficulty;
		_type = type;
	}
		
	
}
