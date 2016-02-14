package zoo.backend.lookup;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.lookup.MenuEntry.WRONG_VACCINES;
import zoo.backend.vaccine.VaccineReg;

/**
 * Command to Lookup all badly administered vaccines
 */
public class WrongVaccines extends Command<Zoo> {
	
	/**
	 * Show all vaccines badly administered to animals
	 */
	public void execute() throws InvalidOperation {
		List<VaccineReg> wrongvaccinehistory = _entity.getWrongVaccineHistory();
		for(VaccineReg vr : wrongvaccinehistory) {
			IO.println(vr.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public WrongVaccines(Zoo entity) {
		super(false, WRONG_VACCINES, entity);
	}
}
