package zoo.backend.vaccine;

import java.io.*;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.vaccine.MenuEntry.VACCINATION;
import static zoo.textui.vaccine.Message.vetReq;
import static zoo.textui.vaccine.Message.idReq;
import static zoo.textui.vaccine.Message.wrongVaccine;
import static zoo.textui.vaccine.Message.animalReq;
import static zoo.textui.employee.Message.veterinary;
import zoo.textui.vaccine.UnknownIdException;
import zoo.textui.animal.UnknownAnimalKeyException;
import zoo.textui.animal.UnknownGroupKeyException;
import zoo.textui.employee.UnknownKeyException;
import zoo.backend.animal.Animal;
import zoo.backend.animal.Specie;
import zoo.backend.employee.Employee;
import zoo.backend.employee.Vet;

/**
 * Command used to vaccine an animal
 */
public class Vaccination extends Command<Zoo> {
	
	/**
	 * Vaccine an animal
	 */
	public void execute() throws InvalidOperation {
		String vetkey;
		String animalkey;
		String vackey;
		Employee emp;
		Vet v;
		Animal a;
		Specie s;
		Vaccine vac;
		VaccineReg vr;
		boolean wrong = false;
		try{
			vetkey = IO.readString(vetReq());
			emp = _entity.getEmployee(vetkey);
			if(emp.getType().compareTo(veterinary()) == 0) {
				v = (Vet) emp;
				animalkey = IO.readString(animalReq());
				a = _entity.getAnimal(animalkey);
				s = v.getSpecie(a.getSpecie());
				vackey = IO.readString(idReq());
				vac = _entity.getVaccine(vackey);
				if(damage(vac, a) > 0) {
					wrong = true;
					IO.println(wrongVaccine(vac.getKey(), a.getKey()));
				}
				vr = _entity.putVaccineHistory(vac, v, a, wrong);
				a.addVaccineReg(vr);
				v.addVaccineReg(vr);
				vac.used();
				_entity.setChanged(true);
			}
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}
	}
	
	/**
	 * Calculates the damage made by a wrong vaccine
	 * @return max the maximum damage made to an animal by a wrong vaccine
	 */
	public int damage(Vaccine v, Animal a) throws UnknownGroupKeyException {
		List<Specie> species = v.getListOfSpecies();
		Specie s;
		Specie s3;
		char[] vaccinespecie;
		char[] animalspecie;
		int max = 0;
		int maxname;
		int maxchar;
		int maxtemp;
		int i,j;
		s = _entity.getSpecie(a.getSpecie());
		if((s3 = v.getSpecie(s.getKey())) == null) {
			for(Specie s2 : species) {
				vaccinespecie = s2.getName().toCharArray();
				animalspecie = s.getName().toCharArray();
				if(s2.getName().length() >= s.getName().length()) {
					maxname = s2.getName().length();
				}else{
					maxname = s.getName().length();
				}
				maxchar = 0;
				for(char c : vaccinespecie) {
					for(i = 0; (i < animalspecie.length) && (animalspecie[i] != '\0'); i++) {
						//IO.println(Character.toString(c) + " - " + Character.toString(animalspecie[i])); //for testing
						if(c == animalspecie[i]) {
							for(j = (i+1); (j < animalspecie.length) && (animalspecie[j] != '\0'); j++){
						 		animalspecie[j-1] = animalspecie[j];
							}
							animalspecie[j-1] = '\0';
							maxchar++;
							break;
						}
					}
				}
				maxtemp = maxname - maxchar;
				//IO.println("char comuns entre " + s.getName() + " e " + s2.getName() + " sao " + maxchar + " maxname: " + maxname); //for testing
				if(maxtemp > max) {
					max = maxtemp;
				}
			}
			if((max > 0) && (max <= 4)) {
				a.incrementPhlegm();
			}else if(max >= 5) {
				a.incrementSneeze();
			} 
			//IO.println("returned " + max); //for testing
			return max;
		}else{
			return max;
		}
	}
	
	/**
	 * Constructor
	 */
	public Vaccination(Zoo entity) {
		super(false, VACCINATION, entity);
	}
}
