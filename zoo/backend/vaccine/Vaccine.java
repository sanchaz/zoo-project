package zoo.backend.vaccine;

import java.io.Serializable;
import java.util.*;
import java.util.LinkedHashMap;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.vaccine.Message.*;
import zoo.backend.animal.*;
import zoo.backend.lookup.SortSpeciesByKey;
/**
 * Vaccines are used to treat animals
 * A wrongly ministered Vaccine can damage a Animals speech
 * @see zoo.backend.animal.Animal 
 */
public class Vaccine implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Key used to identify all vaccines (each differente vaccine has a unique key)
	 */
	private String _key;
	/**
	 * Vaccine's name
	 */
	private String _name;
	/**
	 * Number of times it has been used on any animal
	 */
	private int _timesused = 0;
	/**
	 * LinkedHashMap contaning all the Species a vaccine can be ministered to
	 */
	private Map<String, Specie> _species = new LinkedHashMap<String, Specie>();
	
	/**
	 * @return _key returns the vaccines unique key
	 */
	public String getKey() {
		return _key;
	}
	/**
	 * @return _name returns the vaccine's name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return _timesused returns number of times a vaccine has been used on any animal
	 */
	public int getTimesUsed() {
		return _timesused;
	}
	
	/**
	 * Indicates that the vaccine has been used
	 */
	public void used() {
		_timesused++;
	}
	
	/**
	 * @return _species returns a LinkedHashMap containg all the species a vaccine can be used on
	 */
	public Map<String, Specie> getSpecies() {
		return _species;
	}
	
		/**
	 * @return species LinkedList containing all the species the vaccine can cure
	 */
	public List<Specie> getListOfSpecies() {
		List<Specie> species = new ArrayList<Specie>(getSpecies().values());
		return species;
	}
	
	/**
	 * adds a species to the list of species the vaccine can cure
	 * @param key Specie's key
	 * @param specie Specie to add 
	 */
	public void addSpecie(String key, Specie specie) {
		if(getSpecies().containsKey(key) == false) {
			getSpecies().put(key, specie);
		}
	}
	
		/**
	 * gets a species that the vaccine can cure from the list of species
	 * @param key Specie's key to treat
	 * @return the specie
	 * @return null if the vaccine can not cure the given specie
	 */
	public Specie getSpecie(String key){
		if(getSpecies().containsKey(key) == true) {
			return getSpecies().get(key);
		}else{
			return null;
		}
	}
	
	/**
	 * toString
	 */
	public String toString() {
		List<Specie> species = getListOfSpecies();
		String ts = vaccine() + "|" + getKey() + "|" + getName() + "|" +  getTimesUsed() + "|";
		int n = 0;
		Collections.sort(species, new SortSpeciesByKey());
		for(Specie s : species) {
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
	 */
	public Vaccine(String key, String name) {
		_key = key;
		_name = name;
	}
}
