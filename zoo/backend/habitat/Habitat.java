package zoo.backend.habitat;

import java.io.Serializable;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.habitat.Message.*;
import zoo.textui.habitat.*;
import zoo.backend.animal.*;
/**
 * A Habitat is used to keep animals and may or may not have trees.
 * A Habitat also may have some postive or negative effect on a species.
 */
public class Habitat implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Key used to identify the Habitat (This key is unique for each habitat)
	 */
	private String _key;
	/**
	 * The Habitat's name
	 */
	private String _name;
	/**
	 * The Habitat's area (space the habitat has)
	 */
	private int _area;
	/**
	 * Number of trees in the habitat
	 */
	 private int _numberoftrees;
	/**
	 * LinkedHashMap to keep record of the species the habitat has a postive effect on
	 */
	private Map<String, Specie> _posspecies = new LinkedHashMap<String, Specie>();
	/**
	 * LinkedHashMap to keep record of the species the habitat har a negative effect on
	 */
	private Map<String, Specie> _negspecies = new LinkedHashMap<String, Specie>();
	/**
	 * LinkedHashMap to keep record of all the trees int the habitat
	 */
	private Map<String, Tree> _trees = new LinkedHashMap<String, Tree>();
	/**
	 * LinkedHashMap to keep record of all the animals in the habitat
	 */
	private Map<String, Animal> _animals = new LinkedHashMap<String, Animal>();
	
	/**
	 * @return _key Habitats unique key
	 */
	public String getKey() {
		return _key;
	}
	
	/**
	 * @return _name habitat's name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return _area habitat's area (space the habitat has)
	 */
	public int getArea() {
		return _area;
	}
	
	/**
	 * @param a habitat's new area (space the habitat has)
	 */
	public void setArea(int a) {
		_area = a;
	}
	
	/**
	 * @return _numberoftrees number of trees in the habitat
	 */
	public int getNumberOfTrees() {
		return _numberoftrees;
	}
	
	/**
	 * adds +1 to _numberoftrees. number of trees in the habitat
	 */
	private void incrementNumberOfTrees() {
		_numberoftrees++;
	}
	
	/**
	 * adds -1 to _numberoftrees. number of trees in the habitat
	 */
	private void decrementNumberOfTrees() {
		_numberoftrees--;
	}
	
	/**
	 * @return _posspecies LinkedHashMap with the species the habitat has a postive effect on
	 */
	public Map<String, Specie> getPosSpecies() {
		return _posspecies;
	}
	
	/**
	 * @return posspecies LinkedList containing all the species the habitat has a postive effect on
	 */
	public List<Specie> getListOfPosSpecies() {
		List<Specie> posspecies = new ArrayList<Specie>(getPosSpecies().values());
		return posspecies;
	}
	
	/**
	 * Adds a new specie the habitat has a postive effect on
	 * @param key the specie's key
	 * @param s the specie
	 */
	public void addPosSpecie(String key, Specie s) {
		if(getPosSpecies().containsKey(key) == false) {
			getPosSpecies().put(key, s);
		}
	}
	
	/**
	 * @return _negspecies LinkedHashMap with the species the habitat has a negative effect on
	 */
	public Map<String, Specie> getNegSpecies() {
		return _negspecies;
	}
	
		/**
	 * @return posspecies LinkedList containing all the species the habitat has a postive effect on
	 */
	public List<Specie> getListOfNegSpecies() {
		List<Specie> negspecies = new ArrayList<Specie>(getNegSpecies().values());
		return negspecies;
	}
	
		/**
	 * Adds a new specie the habitat has a negative effect on
	 * @param key the specie's key
	 * @param s the specie
	 */
	public void addNegSpecie(String key, Specie s) {
		if(getNegSpecies().containsKey(key) == false) {
			getNegSpecies().put(key, s);
		}
	}
	
	/**
	 * Removes a specie the habitat has a positive/negative effect on
	 * @param key the specie's key
	 */
	public void rmSpecie(String key) {
		if(getPosSpecies().containsKey(key) == true) {
			getPosSpecies().remove(key);
		}else if(getNegSpecies().containsKey(key) == true) {
			getNegSpecies().remove(key);
		}else {
			IO.println(noAssociation(this.getKey(), key));
		}
	}
	
	/**
	 * @return _trees LinkedHashMap with the trees in the habitat
	 */
	public Map<String, Tree> getTrees() {
		return _trees;
	}
	
	/**
	 * @return tree LinkedList containing all the trees in the habitat
	 */
	public List<Tree> getListOfTrees() {
		List<Tree> trees = new ArrayList<Tree>(getTrees().values());
		return trees;
	}
	
	/**
	 * Add a tree to the habitat
	 * @param key Tree's key
	 * @param a Tree
	 */
	public void addTree(String key, Tree t) {
		getTrees().put(key, t);
		incrementNumberOfTrees();
	}
	
	/**
	 * Remove a tree from the habitat
	 * @param key Tree's key
	 */
	public void rmTree(String key) { //Remove if not needed
		getTrees().remove(key);
		decrementNumberOfTrees();
	}
	
	/**
	 * @return animals LinkedList containing all the animals in the habitat
	 */
	public Map<String, Animal> getAnimals() {
		return _animals;
	}
	
	/**
	 * @return animals LinkedList containing all the animals in the habitat
	 */
	public List<Animal> getListOfAnimals() {
		List<Animal> animals = new ArrayList<Animal>(getAnimals().values());
		return animals;
	}
	
	/**
	 * Add an animal to the habitat
	 * @param key Animal's key
	 * @param a Animal
	 */
	public void addAnimal(String key, Animal a) {
		getAnimals().put(key, a);
	}
	
	/**
	 * Remove an animal from the habitat
	 * @param key Animal's key
	 */
	public void rmAnimal(String key) {
		getAnimals().remove(key);
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return habitat() + "|" + getKey() + "|" + getName() + "|" + getArea() + "|" + getNumberOfTrees(); 
	}
		
	/**
	 * Constructor
	 * @param key Habitat's unique key
	 * @param name Habitat's name
	 * @param area Habitat's area (space the habitat has)
	 */
	public Habitat(String key, String name, int area) {
		_key = key;
		_name = name;
		_area = area;
	}
}
