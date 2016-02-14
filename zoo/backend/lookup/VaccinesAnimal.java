package zoo.backend.lookup;

import java.io.*;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.lookup.MenuEntry.VACCINES_ANIMAL;
import static zoo.textui.animal.Message.animalKeyReq;
import zoo.backend.animal.Animal;
import zoo.backend.vaccine.VaccineReg;

/**
 * Command to Lookup all vaccines an animal received
 */
public class VaccinesAnimal extends Command<Zoo> {
	
	/**
	 * Shows all vaccines received by a given animal
	 */
	public void execute() throws InvalidOperation {
		String key;
		Animal a;
		List<VaccineReg> vaccinesgiven;
		try{
			key = IO.readString(animalKeyReq());
			a = _entity.getAnimal(key);
			vaccinesgiven = a.getVaccineReg();
			for(VaccineReg vr : vaccinesgiven) {
				IO.println(vr.toString());
			}
		}catch(IOException e) {
			IO.println(e.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public VaccinesAnimal(Zoo entity) {
		super(false, VACCINES_ANIMAL, entity);
	}
}
