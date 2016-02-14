package zoo.backend.vaccine;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.vaccine.MenuEntry.SHOW_VACCINES;

/**
 * Command used to Show Zoo Vaccine history
 */
public class ShowVaccines extends Command<Zoo> {
	
	/**
	 * Show Zoo Vaccine history
	 */
	public void execute() throws InvalidOperation {
		List<VaccineReg> vaccinehistory = _entity.getVaccineHistory();
		for(VaccineReg vr : vaccinehistory) {
			IO.println(vr.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public ShowVaccines(Zoo entity) {
		super(false, SHOW_VACCINES, entity);
	}
}
