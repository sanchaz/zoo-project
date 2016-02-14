package zoo.backend.animal;

import java.util.*;
import java.io.Serializable;
import static java.lang.Math.round;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import zoo.Zoo;
import static zoo.textui.animal.Message.*;
import zoo.textui.habitat.UnknownKeyException;
import zoo.backend.habitat.Habitat;
import zoo.backend.vaccine.VaccineReg;
import zoo.backend.vaccine.Vaccine;
import zoo.backend.employee.Vet;
/**
 * An Animal has to be assingned to a habitat, and can talk. It's talk can however be effected due to vaccinations
 */
public class Animal implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Key used to identify an Animal (each animal has a unique key)
	 */	
	private String _key;
	/**
	 * Animals name
	 */
	private String _name;
	/**
	 * Animals species
	 */
	private String _specie;
	/**
	 * Animals habitat
	 */
	private String _habitat;
	/**
	 * Animals speech
	 */
	private String _speech;
	/**
	 * How many phlegm's the animal has in it's speech.
	 * Phlegm's are due to bad vaccinations.
	 */
	private int _phlegm = 0; // catarro
	/**
	 * How many sneeze's the animal has in it's speech.
	 * Sneezes's are due to bad vaccinations.
	 */
	private int _sneeze = 0; // espiro
	/**
	 * List with all vaccines given to the animal
	 */
	 private List<VaccineReg> _vaccinestaken = new LinkedList<VaccineReg>();
	
	/**
	 * @return _key returns the animals unique key
	 */
	public String getKey() {
		return _key;
	}
	
	/**
	 * @return _name returns the animals name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return _specie returns the animals species
	 */
	public String getSpecie() {
		return _specie;
	}
	
	/**
	 * @return _habitat returns the animals habitat
	 */
	public String getHabitat() {
		return _habitat;
	}
	
	/**
	 * Used to change the animals habitat
	 * @param newhabitat Animals new habitat
	 */
	public void setHabitat(String newhabitat) {
		_habitat = newhabitat;
	}
	
	/**
	 * @return _speech Returns the animals original speech at time of creation
	 */
	public String getSpeech() {
		return _speech;
	}
	
	/**
	 * This method returns the animals current speech with all the phlegm's and sneeze's due to bad vaccination,
	 * if none occured, then the original speech is returned.
	 * @return speech Returns animals current speech due to bad vaccinations
	 */
	public String getSpeechSickness() {
		int i;
		String speech = "";
		for(i = _phlegm; i > 0; i--) {
			speech += catarro();
		}
		speech += getSpeech();
		for(i = _sneeze; i > 0; i--) {
			speech += atchim();
		}
		return speech;
	}
	
	/**
	 * @return _phlegm the number of phlegms
	 */
	public int getPhlegm() {
		return _phlegm;
	}
	
	/**
	 * increment _phlegm by 1
	 */
	public void incrementPhlegm() {
		_phlegm++;
	}
	
	/**
	 * @return _sneeze the number of sneezes
	 */
	public int getSneeze() {
		return _sneeze;
	}
	
	/**
	 * increment _sneeze by 1
	 */
	public void incrementSneeze() {
		_sneeze++;
	}
	
	/**
	 * @return _vaccinestaken returns a List with all the vaccines taken by the animal
	 */
   public List<VaccineReg> getVaccineReg() {
	   return _vaccinestaken;
   }
   
   /**
    * Adds a vaccine to the list of all the vaccines taken by the animal
    * @param v Vet that ministrated the vaccine
    * @param vac vaccine ministared to the animal
    */
   public void addVaccineReg(VaccineReg vr) {
      LinkedList<VaccineReg> vacs = (LinkedList<VaccineReg>) getVaccineReg();
      vacs.addLast(vr);
   }
   
   /**
    * Calculates animal satisfaction
    */
   public int getSatisfaction(Zoo zoo) throws zoo.textui.habitat.UnknownKeyException {
   	int satisfaction = 20;
   	int numberanimalshabitat = 0;
   	int same = 0;
   	int different = 0;
   	int space = 0;
   	int quality = 0;
   	Habitat h = zoo.getHabitat(getHabitat());
   	List<Animal> animals = h.getListOfAnimals();
   	List<Specie> posspecies = h.getListOfPosSpecies();
   	List<Specie> negspecies = h.getListOfNegSpecies();
   	for(Animal a : animals) {
   		if((a.getSpecie().compareTo(getSpecie())) == 0) {
   			same++;
   		}
   		numberanimalshabitat++;
   	}
   	different = numberanimalshabitat - same;
   	same -= 1;
   	space = round(((float) h.getArea())/((float) numberanimalshabitat));
   	for(Specie s : posspecies) {
   		if(s.getKey().compareTo(getSpecie()) == 0) {
   			quality = 20;
   		}
   	}
   	for(Specie s : negspecies) {
   		if(s.getKey().compareTo(getSpecie()) == 0) {
   			quality = -20;
   		}
   	}
   	//IO.println("output s: " + same + " n " + numberanimalshabitat + " d " + different + " space " + space + " quality " + quality); //for testing
   	satisfaction = satisfaction + (3*same) - (2*different) + space + quality;
   	return satisfaction;
   }
	
	/**
	 * @return "ANIMAL|" + getKey() + "|" + getName() + "|" + getSpecie() + "|" + getSpeech() + "|" + getHabitat() the view of an animal
	 */
	public String toString() {
		return animal() + "|" + getKey() + "|" + getName() + "|" + getSpecie() + "|" + getSpeech() + "|" + getHabitat();
	}
	
	/**
	 * Constructor
	 * @param key Animals unique key
	 * @param name Animals name
	 * @param speech Animals speech
	 * @param habitat Animals habitat
	 */
	public Animal(String key, String name, String specie, String speech, String habitat) {
		_key = key;
		_name = name;
		_specie = specie;
		_speech = speech;
		_habitat = habitat;
	}
	
}
