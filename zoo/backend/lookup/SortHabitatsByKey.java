package zoo.backend.lookup;

import java.util.Comparator;
import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.backend.habitat.Habitat;

/**
 * Class used for sorting habitats by key
 */
public class SortHabitatsByKey implements Comparator<Habitat>, Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Compares the key atribute of two habitats
	 * @return o1.getKey().compareToIgnoreCase(o2.getKey()) returns less than, equal to, more than 0, if key from object 1 is smaller than, equal to, or greater than key from object 2
	 */
	public int compare(Habitat o1, Habitat o2) {
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}

}
