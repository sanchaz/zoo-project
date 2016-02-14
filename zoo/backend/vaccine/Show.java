package zoo.backend.vaccine;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.vaccine.MenuEntry.SHOW;
import zoo.backend.lookup.SortVaccinesByKey;

/**
 * Command used to show all vaccines available in the Zoo
 */
public class Show extends Command<Zoo> {
	
	/**
	 * Shows aall vaccines available in the zoo
	 */
	public void execute() throws InvalidOperation {
		List<Vaccine> vaccines = _entity.getListOfVaccines();
		Collections.sort(vaccines, new SortVaccinesByKey());
		for(Vaccine v : vaccines) {
			IO.println(v.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public Show(Zoo entity) {
		super(false, SHOW, entity);
	}
}
