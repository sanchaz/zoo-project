package zoo.backend.employee;

import java.io.Serializable;
import java.util.*;
import static java.lang.Math.round;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import zoo.Zoo;
import static zoo.textui.employee.Message.*;
import zoo.textui.vaccine.OperationNotPermited;
import zoo.backend.animal.*;
import zoo.backend.lookup.SortSpeciesByKey;
import zoo.backend.vaccine.VaccineReg;
import zoo.backend.vaccine.Vaccine;

public class Vet extends Employee implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * LinkedHashMap containing all of the Species the Vet knows how to treat
	 */
	private Map<String, Specie> _species = new LinkedHashMap<String, Specie>();
	/**
	 * List with all vaccines the vet has ministrated
	 */
	 private List<VaccineReg> _vaccinesgiven = new LinkedList<VaccineReg>();

	/**
	 * @return _species returns a LinkedHashMap of all the species the vet knows how to treat
	 */
	public Map<String, Specie> getSpecies() {
		return _species;
	}
	
	/**
	 * @return species LinkedList containing all the species the vet knows how to treat
	 */
	public List<Specie> getListOfSpecies() {
		List<Specie> species = new ArrayList<Specie>(getSpecies().values());
		return species;
	}
	
	/**
	 * adds a species to the list of species the vet can treat
	 * @param key Specie's key
	 * @param specie Specie to add 
	 */
	public void addSpecie(String key, Specie specie) {
		if(getSpecies().containsKey(key) == false) {
			getSpecies().put(key, specie);
		}
	}
	
	/**
	 * removes a species to the list of species the vet can treat
	 * @param key Specie's key to remove
	 */
	public void rmSpecie(String key) {
		if(getSpecies().containsKey(key) == true) {
			getSpecies().remove(key);
		}else{
			IO.println(noResponsability(key));
		}
	}
	
	/**
	 * gets a species that the vet can vaccine from the list of species
	 * @param key Specie's key to treat
	 * @return the specie
	 * @exception OperationNotPermited if the vet can not treat the given specie
	 */
	public Specie getSpecie(String key) throws OperationNotPermited{
		if(getSpecies().containsKey(key) == true) {
			return getSpecies().get(key);
		}else{
			throw new OperationNotPermited(key);
		}
	}
	
		/**
	 * @return _vaccinesgiven returns a List with all the vaccines taken by the animal
	 */
   public List<VaccineReg> getVaccineReg() {
	   return _vaccinesgiven;
   }
   
   /**
    * Adds a vaccine to the list of all the vaccines the vet has ministrated
    * @param a Animal that the vaccine was given to
    * @param vac vaccine ministrated by the vet
    */
   public void addVaccineReg(VaccineReg vr) {
      LinkedList<VaccineReg> vacs = (LinkedList<VaccineReg>) getVaccineReg();
      vacs.addLast(vr);
   }
	
	/**
    * Calculates animal satisfaction
    */
   public int getSatisfaction(Zoo zoo) {
		float pop = 0;
		float vets = 0;
		float temp = 0;
		int satisfaction = 20;
		List<Animal> animals = zoo.getListOfAnimals();
		List<Employee> employees = zoo.getListOfEmployees();
		List<Specie> species = getListOfSpecies();
		Vet v;
		for(Specie s : species) {
			pop = 0;
			vets = 0;
			for(Animal a : animals) {
				if((a.getSpecie().compareTo(s.getKey())) == 0) {
					pop++;
				}
			}
			for(Employee e : employees) {
				if((e.getType().compareTo(veterinary())) == 0) {
					v = (Vet) e;
					for(Specie s2 : v.getListOfSpecies()) {
						if((s.getKey().compareTo(s2.getKey())) == 0) {
							vets++;
							break;
						}
					}
				}
			}
			//IO.println("pop " + pop + " vets " + vets); //for testing
			temp += (pop/vets);
		}
		
		satisfaction -= round(temp);
		return satisfaction;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		List<Specie> species = getListOfSpecies();
		String ts = veterinary() + "|" + getKey() + "|" + getName();
		int n = 0;
		Collections.sort(species, new SortSpeciesByKey());
		for(Specie s : species) {
			if((n == 0) && (species.size() > 0)) {
				ts += "|";
			}
			ts += s.getKey();
			if(n < (species.size() - 1)) {
				ts += ",";
				n++;
			}
		}
		return ts;
	}
	
	/**
	 * Constructor
	 * @see zoo.backend.employee.Employee
	 */
	public Vet(String key, String name) {
		super(key, name, veterinary());
	}
	
}
