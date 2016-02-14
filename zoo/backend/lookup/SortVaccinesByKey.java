package zoo.backend.lookup;

import java.util.Comparator;
import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.backend.vaccine.Vaccine;

/**
 * Class used for sorting vaccines by key
 */
public class SortVaccinesByKey implements Comparator<Vaccine>, Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Compares the key atribute of two vaccines
	 * @return o1.getKey().compareToIgnoreCase(o2.getKey()) returns less than, equal to, more than 0, if key from object 1 is smaller than, equal to, or greater than key from object 2
	 */
	public int compare(Vaccine o1, Vaccine o2) {
		return o1.getKey().compareToIgnoreCase(o2.getKey());
	}

}
