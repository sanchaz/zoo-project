package zoo.backend.animal;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.animal.Message.*;
/**
 * Specie represents Species in the zoo
 * As there is no plural for species, specie has been used for methods that return a single instance of Specie and
 * sppecies for method that return collections of Specie
 * For example when you use a getSpecie() function it means it is going to return a an object of type Specie
 * and if you use getSpecies() function it means it is going to return a collection (eg HashMap or List)
 */
public class Specie implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Species key (every species has a unique key)
	 */
	private String _key;
	/**
	 * Species name
	 */
	private String _name;
	
	/**
	 * @return _key returns the species key
	 */
	public String getKey() {
		return _key;
	}
	
	/**
	 * @return _name returns name of the species
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * Constructor
	 */
	public Specie(String key, String name) {
		_key = key;
		_name = name;
	}
	
}
