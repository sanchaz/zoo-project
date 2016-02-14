package zoo.backend.lookup;

import java.util.Comparator;
import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.backend.animal.Animal;

/**
 * Class used for sorting animals by key
 */
public class SortAnimalsByKey implements Comparator<Animal>, Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Compares the key atribute of two animals
	 * @return o1.getKey().compareToIgnoreCase(o2.getKey()) returns less than, equal to, more than 0, if key from object 1 is smaller than, equal to, or greater than key from object 2
	 */
	public int compare(Animal o1, Animal o2) {
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}

}
