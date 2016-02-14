package zoo.backend.lookup;

import java.io.*;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.lookup.MenuEntry.MEDICAL_ACTS_VET;
import static zoo.textui.lookup.Message.vetReq;
import static zoo.textui.employee.Message.veterinary;
import zoo.backend.employee.Employee;
import zoo.backend.employee.Vet;
import zoo.backend.vaccine.VaccineReg;

/**
 * Show all minitered vaccines
 */
public class MedicalActsVet extends Command<Zoo> {
	
	/**
	 * Show all ministered vacines
	 */
	public void execute() throws InvalidOperation {
		String key;
		Employee e;
		Vet v;
		List<VaccineReg> vaccinesgiven;
		try{
			key = IO.readString(vetReq());
			e = _entity.getEmployee(key);
			if((e.getType().compareTo(veterinary())) == 0) {
				v = (Vet) e;
				vaccinesgiven = v.getVaccineReg();
				for(VaccineReg vr : vaccinesgiven) {
					IO.println(vr.toString());
				}
			}
			return;
		}catch(IOException excpt) {
			IO.println(excpt.toString());
			return;
		}
	}
	
	/**
	 * Constructor
	 */
	public MedicalActsVet(Zoo entity) {
		super(false, MEDICAL_ACTS_VET, entity);
	}
}
