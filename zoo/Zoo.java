package zoo;

import java.io.*;
import java.util.*;
import java.util.LinkedHashMap;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import static zoo.textui.main.MenuEntry.TITLE;
import pt.utl.ist.po.ui.*;
import zoo.backend.*;
import zoo.backend.main.*;
import zoo.backend.zoo.*;
import zoo.backend.animal.*;
import zoo.backend.employee.*;
import zoo.backend.habitat.*;
import zoo.backend.lookup.*;
import zoo.backend.vaccine.*;
import zoo.textui.main.*;
import zoo.textui.zoo.*;
import zoo.textui.animal.*;
import zoo.textui.employee.*;
import zoo.textui.habitat.*;
import zoo.textui.lookup.*;
import zoo.textui.vaccine.*;

/** Zoo class
 * Runs the whole zoo management system
 * Contains a record of all animals, species, employees, habitats and vaccines in the zoo.
 */
public class Zoo {
	
	/**
	 * LinkedHashMap used to store all Animals in the zoo
	 */
	private Map<String, Animal> _animals = new LinkedHashMap<String, Animal>();
	/**
	 * LinkedHashMap used to store all Species in the zoo
	 */
	private Map<String, Specie> _species = new LinkedHashMap<String, Specie>();
	/**
	 * LinkedHashMap used to store all Employees in the zoo (Vet and Keeper (ZooKeeper))
	 */
	private Map<String, Employee> _employees = new LinkedHashMap<String, Employee>();
	/**
	 * LinkedHashMap used to store all Habitats in the zoo
	 */
	private Map<String, Habitat> _habitats = new LinkedHashMap<String, Habitat>();
	/**
	 * LinkedHashMap used to store all Trees in the zoo (Decidous (Decidous Tree) and Evergreen (Evergreen Tree))
	 */
	private Map<String, Tree> _trees = new LinkedHashMap<String, Tree>();
	/**
	 * LinkedHashMap used to store all Vaccines in the zoo
	 */
	private Map<String, Vaccine> _vaccines = new LinkedHashMap<String, Vaccine>();
	/**
	 * LinkedList used to keep record of vaccine history in the zoo
	 */
	private List<VaccineReg> _vaccinehistory = new LinkedList<VaccineReg>();
	/**
	 * LinkedList used to keep record of wrongly ministared vaccines in the zoo
	 */
	private List<VaccineReg> _wrongvaccinehistory = new LinkedList<VaccineReg>();
	/**
	 * The saved zoo's file name
	 */
	 private String _zoofilename = null;
	 /**
	  * Indicates if the zoo has been changed and not saved yet
	  */
	 private boolean _changed = false;
	 
	/** Gets animals in the zoo
	 * @return _animals returns a LinkedHashMap that contains all animals in the zoo
	 */
	public Map<String, Animal> getAnimals() {
		return _animals;
	}
	
	/**
	 * @param animals LinkedHashMap that contains all animals in the loaded zoo
	 */
	private void setAnimals(Map<String, Animal> animals) {
		_animals = animals;
	}
	
	/** Gets animals in the zoo
	 * @return animals returns a LinkedList that contains all animals in the zoo
	 */
	public List<Animal> getListOfAnimals() {
		List<Animal> animals = new ArrayList<Animal>(getAnimals().values());
		return animals;
	}
	
	/** Adds a new animal to the zoo
	 * Adds a new Animal to the LinkedHashMap that contains all animals in the zoo
	 * @param key Key used to identify the Animal (every Animal has a unique Key)
	 * @param name Animals name
	 * @param specie Animals Species
	 * @param speech What the Animal says when he is asked to talk
	 * @param habitat Animals habitat
	 * @return a returns the newly created Animal
	 * @see zoo.backend.animal.Animal
	 */
	public Animal putAnimal(String key, String name, String specie, String speech, String habitat) {
		Animal a = new Animal(key, name, specie, speech, habitat);
		getAnimals().put(key, a);
		return a;
	}
	
	/** gets Animal from the zoo
	 * checks to see if the asked animal exists, if so the Animal is returned, else an UnknownAnimalKeyException is thrown
	 * @param key Key that identifies the Animal (every Animal has a unique Key)
	 * @return Animal returns the animal that has the given key
	 * @exception UnknownAnimalKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.animal.Animal
	 */
	public Animal getAnimal(String key) throws zoo.textui.animal.UnknownAnimalKeyException{
		if(getAnimals().containsKey(key) == true) {
			return getAnimals().get(key);
		}else{
			throw new zoo.textui.animal.UnknownAnimalKeyException(key);
		}
	}
	
	/** Gets species in the zoo
	 * @return _species returns a LinkedHashMap that contains all species in the zoo
	 */
	public Map<String, Specie> getSpecies() {
		return _species;
	}

	/**
	 * @param species LinkedHashMap that contains all species in the loaded zoo
	 */
	private void setSpecies(Map<String, Specie> species) {
		_species = species;
	}

	/** Gets species in the zoo
	 * @return species returns a LinkedList that contains all species in the zoo
	 */
	public List<Specie> getListOfSpecies() {
		List<Specie> species = new ArrayList<Specie>(getSpecies().values());
		return species;
	}
	
	/** Adds a new species to the zoo
	 * Adds a new Species to the LinkedHashMap that contains all species in the zoo
	 * @param key Key used to identify the species (every Species has a unique Key)
	 * @param name Species name
	 * @return s returns the newly created Species
	 * @see zoo.backend.animal.Species
	 */
	public Specie putSpecie(String key, String name) {
		Specie s = new Specie(key, name);
		getSpecies().put(key, s);
		return s;
	}
	
	/** gets Species from the zoo
	 * checks to see if the asked animal exists, if so the Species is returned, else an UnknownGroupKeyException is thrown
	 * @param key Key that identifies the Species (every Species has a unique Key)
	 * @return Specie returns the species that has the given key
	 * @exception UnknownGroupKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.animal.Specie
	 */
	public Specie getSpecie(String key) throws zoo.textui.animal.UnknownGroupKeyException{
		if(getSpecies().containsKey(key) == true) {
			return getSpecies().get(key);
		}else{
			throw new zoo.textui.animal.UnknownGroupKeyException(key);
		}
	}
	
	/** Gets employees in the zoo
	 * Contains Keepers and Vets
	 * @return _employees returns a LinkedHashMap that contains all employees in the zoo
	 * @see zoo.backend.employee.Keeper
	 * @see zoo.backend.employee.Vet
	 */
	public Map<String, Employee> getEmployees() {
		return _employees;
	}

	/**
	 * @param employees LinkedHashMap that contains all employees in the loaded zoo
	 */
	private void setEmployees(Map<String, Employee> employees) {
		_employees = employees;
	}

	/** Gets employees in the zoo
	 * @return employees returns a LinkedList that contains all employees in the zoo
	 */
	public List<Employee> getListOfEmployees() {
		List<Employee> employees = new ArrayList<Employee>(getEmployees().values());
		return employees;
	}
	
	/** Adds a new keeper to the zoo
	 * Adds a new Keeper to the LinkedHashMap that contains all employees in the zoo
	 * @param key Key used to identify the employee (every Employee has a unique Key)
	 * @param name Keeper's name
	 * return k returns the newly created Keeper
	 * @see zoo.backend.employee.Employee
	 * @see zoo.backend.employee.Keeper
	 */
	public Keeper putKeeper(String key, String name) {
		Keeper k = new Keeper(key, name);
		getEmployees().put(key, k);
		return k;
	}
	
	/** Adds a new vet to the zoo
	 * Adds a new Vet to the LinkedHashMap that contains all employees in the zoo
	 * @param key Key used to identify the employee (every Employee has a unique Key)
	 * @param name Vet's name
	 * @return v returns the newly created Vet
	 * @see zoo.backend.employee.Employee
	 * @see zoo.backend.employee.Vet
	 */
	public Vet putVet(String key, String name) {
		Vet v = new Vet(key, name);
		getEmployees().put(key, v);
		return v;
	}
	
	/** gets Employe from the zoo
	 * checks to see if the asked employee exists, if so the Employee is returned, else an UnknownKeyException is thrown
	 * @param key Key that identifies the Employee (every Employee has a unique Key)
	 * @return Employee returns the employee that has the given key
	 * @exception UnknownKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.employee.Employee
	 */
	public Employee getEmployee(String key) throws zoo.textui.employee.UnknownKeyException{
		if(getEmployees().containsKey(key) == true) {
			return getEmployees().get(key);
		}else{
			throw new zoo.textui.employee.UnknownKeyException(key);
		}
	}
	
	/** Gets habitats in the zoo
	 * @return _habitats returns a LinkedHashMap that contains all habitats in the zoo
	 */
	public Map<String, Habitat> getHabitats() {
		return _habitats;
	}
	
	/**
	 * @param habitats LinkedHashMap that contains all habitats in the loaded zoo
	 */
	private void setHabitats(Map<String, Habitat> habitats) {
		_habitats = habitats;
	}
	
	/** Gets habitats in the zoo
	 * @return habitats returns a LinkedList that contains all habitats in the zoo
	 */
	public List<Habitat> getListOfHabitats() {
		List<Habitat> habitats = new ArrayList<Habitat>(getHabitats().values());
		return habitats;
	}
	
	/** Adds a new habitat to the zoo
	 * Adds a new Habitat to the LinkedHashMap that contains all habitats in the zoo
	 * @param key Key used to identify the habitat (every Habitat has a unique Key)
	 * @param name Habitat's name
	 * @param area Habitat's area (space the habitat has)
	 * @return h returns the newly created habitat
	 * @see zoo.backend.habitat.Habitat
	 */
	public Habitat putHabitat(String key, String name, int area) {
		Habitat h = new Habitat(key, name, area);
		getHabitats().put(key, h);
		return h;
	}
	
	/** gets Habitat from the zoo
	 * checks to see if the asked habitat exists, if so the Habitat is returned, else an UnknownKeyException is thrown
	 * @param key Key that identifies the Habitat (every Habitat has a unique Key)
	 * @return Habitat returns the habitat that has the given key
	 * @exception UnknownKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.habitat.Habitat
	 */
	public Habitat getHabitat(String key) throws zoo.textui.habitat.UnknownKeyException{
		if(getHabitats().containsKey(key) == true) {
			return getHabitats().get(key);
		}else{
			throw new zoo.textui.habitat.UnknownKeyException(key);
		}
	}
	
	/** Gets trees in the zoo
	 * @return _trees returns a LinkedHashMap that contains all trees in the zoo
	 */
	public Map<String, Tree> getTrees() {
		return _trees;
	}
	
	/**
	 * @param trees LinkedHashMap that contains all trees in the loaded zoo
	 */
	private void setTrees(Map<String, Tree> trees) {
		_trees = trees;
	}
	
	/** Gets Trees in the zoo
	 * @return trees returns a LinkedList that contains all trees in the zoo
	 */
	public List<Tree> getListOfTrees() {
		List<Tree> trees = new ArrayList<Tree>(getTrees().values());
		return trees;
	}
	
	/** Adds a new evergreen tree to the zoo
	 * Adds a new Evergreen tree to the LinkedHashMap that contains all trees in the zoo
	 * @param key Key used to identify the tree (every Tree has a unique Key)
	 * @param name Tree's name
	 * @param difficulty Tree's cleaning difficulty
	 * @return t returns the newly created Evergreen (Evergreen Tree)
	 * @see zoo.backend.habitat.Tree
	 * @see zoo.backend.habitat.Evergreen
	 */
	public Evergreen putEvergreen(String key, String name, int difficulty) {
		Evergreen t = new Evergreen(key, name, difficulty);
		getTrees().put(key, t);
		return t;
	}
	
	/** Adds a new decidous tree to the zoo
	 * Adds a new Decidous tree to the LinkedHashMap that contains all trees in the zoo
	 * @param key Key used to identify the tree (every Tree has a unique Key)
	 * @param name Tree's name
	 * @param difficulty Tree's cleaning difficulty
	 * @return t returns the newly created Decidous (Decidous Tree)
	 * @see zoo.backend.habitat.Tree
	 * @see zoo.backend.habitat.Decidous
	 */
	public Decidous putDecidous(String key, String name, int difficulty) {
		Decidous t = new Decidous(key, name, difficulty);
		getTrees().put(key, t);
		return t;
	}
	
	/** gets Tree from the zoo
	 * checks to see if the asked tree exists, if so the Tree is returned, else an UnknownTreeKeyException is thrown
	 * @param key Key that identifies the Tree (every Habitat has a unique Key)
	 * @return Habitat returns the tree that has the given key
	 * @exception UnknownTreeKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.habitat.Tree
	 */
	public Tree getTree(String key) throws zoo.textui.habitat.UnknownTreeKeyException{
		if(getTrees().containsKey(key) == true) {
			return getTrees().get(key);
		}else{
			throw new zoo.textui.habitat.UnknownTreeKeyException(key);
		}
	}
	
	/** Gets vaccines in the zoo
	 * @return _vaccines returns a LinkedHashMap that contains all vaccines in the zoo
	 */
	public Map<String, Vaccine> getVaccines() {
		return _vaccines;
	}
	
	/**
	 * @param vaccines LinkedHashMap that contains all vaccines in the loaded zoo
	 */
	private void setVaccines(Map<String, Vaccine> vaccines) {
		_vaccines = vaccines;
	}
	
	/** Gets Vaccines in the zoo
	 * @return vaccines returns a LinkedList that contains all vaccines in the zoo
	 */
	public List<Vaccine> getListOfVaccines() {
		List<Vaccine> vaccines = new ArrayList<Vaccine>(getVaccines().values());
		return vaccines;
	}
	
	/** Adds a new vaccine to the zoo
	 * Adds a new Vaccine to the LinkedHashMap that contains all vaccines in the zoo
	 * @param key Key used to identify the vaccine (every Vaccine has a unique Key)
	 * @param name Vaccine's name
	 * @return v returns the newly created Vaccine
	 * @see zoo.backend.habitat.Habitat
	 */
	public Vaccine putVaccine(String key, String name) {
		Vaccine v = new Vaccine(key, name);
		getVaccines().put(key, v);
		return v;
	}
	
	/** gets Vaccine from the zoo
	 * checks to see if the asked vaccine exists, if so the Vaccine is returned, else an UnknownIdException is thrown
	 * @param key Key that identifies the Vaccine (every Vaccine has a unique Key)
	 * @return Vaccine returns the vaccine that has the given key
	 * @exception UnknownIdKeyException Tells the user that the given key does not exist
	 * @see zoo.backend.vaccine.Vaccine
	 */
	public Vaccine getVaccine(String key) throws zoo.textui.vaccine.UnknownIdException{
		if(getVaccines().containsKey(key) == true) {
			return getVaccines().get(key);
		}else{
			throw new zoo.textui.vaccine.UnknownIdException(key);
		}
	}
	
	/** Gets vaccine history of zoo
	 * @return _vaccinehistory returns a LinkedList that contains the history of all vaccines used in the zoo
	 */
	public List<VaccineReg> getVaccineHistory() {
		return _vaccinehistory;
	}
	
	/**
	 * @param vaccinehistory LinkedList that contains the history of all vaccines used in the loaded zoo
	 */
	private void setVaccineHistory(List<VaccineReg> vaccinehistory) {
		_vaccinehistory = vaccinehistory;
	}
	
	/**
    * Adds a vaccine to the list of all the vaccines that have been ministrated in the zoo
    * @param vac vaccine ministrated by the vet
    * @param a Animal that the vaccine was given to
    * @param v vet that ministrated the vaccine
    */
   public VaccineReg putVaccineHistory(Vaccine vac, Vet v,Animal a, boolean wrong) {
      VaccineReg vr = new VaccineReg(vac, v, a, wrong);
      LinkedList<VaccineReg> vacs = (LinkedList<VaccineReg>) getVaccineHistory();
      vacs.addLast(vr);
      if(wrong == true) {
      	putWrongVaccineHistory(vr);
      }
      return vr;
   }
	
	/** Gets wrong vaccine history of zoo
	 * @return _wrongvaccinehistory returns a LinkedList that contains the history of all wrong vaccinations in the zoo
	 */
	public List<VaccineReg> getWrongVaccineHistory() {
		return _wrongvaccinehistory;
	}
	
	/**
	 * @param wrongvaccinehistory LinkedList that contains the history of all wrong vaccines used in the loaded zoo
	 */
	private void setWrongVaccineHistory(List<VaccineReg> wrongvaccinehistory) {
		_wrongvaccinehistory = wrongvaccinehistory;
	}
	
	/**
    * Adds a vaccine to the list of all the vaccines that have been wrongly ministrated in the zoo
    * @param vac vaccine ministrated by the vet
    * @param a Animal that the vaccine was given to
    * @param v vet that ministrated the vaccine
    */
   public void putWrongVaccineHistory(VaccineReg vr) {
      LinkedList<VaccineReg> vacs = (LinkedList<VaccineReg>) getWrongVaccineHistory();
      vacs.addLast(vr);
   }
	
	/**
	 * @return filename the filename under which the zoo is saved. null indicates no name has been choosen.
	 */
	public String getZooFilename() {
		return _zoofilename;
	}
	
	/**
	 * Sets the filename under which the zoo is to be saved
	 * @param zfn the filename under which the zoo is to be saved
	 */
	public void setZooFilename(String zfn) {
		_zoofilename = zfn;
	}
	
	/**
	 * @return changed Indicates if the zoo has been changed and not saved yet
	 */
	public boolean getChanged() {
		return _changed;
	}
	 
	/**
	 * @param changed indicates if the zoo has been changed
	 */
	public void setChanged(boolean changed) {
		_changed = changed;
	}
	
	/**
	 * Saves the current zoo
	 */
	public void save() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getZooFilename() + ".zm"));
		out.writeObject(getAnimals());
		out.writeObject(getEmployees());
		out.writeObject(getHabitats());
		out.writeObject(getTrees());
		out.writeObject(getVaccines());
		out.writeObject(getVaccineHistory());
		out.writeObject(getWrongVaccineHistory());
		out.close();
		setChanged(false);
		return;
	}
	
	/**
	 * loads the zoo from the file
	 */
	@SuppressWarnings("unchecked")
	public void open() throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(getZooFilename() + ".zm"));
		setAnimals((Map<String, Animal>) in.readObject());
		setEmployees((Map<String, Employee>) in.readObject());
		setHabitats((Map<String, Habitat>) in.readObject());
		setTrees((Map<String, Tree>) in.readObject());
		setVaccines((Map<String, Vaccine>) in.readObject());
		setVaccineHistory((List<VaccineReg>) in.readObject());
		setWrongVaccineHistory((List<VaccineReg>) in.readObject());
		in.close();
		setChanged(false);
		return;
	}
	
	/**
	 * Cleans the zoo
	 */
	 public void clean() {
	 	setAnimals((Map<String, Animal>) new LinkedHashMap<String, Animal>());
		setEmployees((Map<String, Employee>) new LinkedHashMap<String, Employee>());
		setHabitats((Map<String, Habitat>) new LinkedHashMap<String, Habitat>());
		setTrees((Map<String, Tree>) new LinkedHashMap<String, Tree>());
		setVaccines((Map<String, Vaccine>) new LinkedHashMap<String, Vaccine>());
		setVaccineHistory((List<VaccineReg>) new LinkedList<VaccineReg>());
		setWrongVaccineHistory((List<VaccineReg>) new LinkedList<VaccineReg>());
		setChanged(false);
		return;
	}
	
	/** Opens MainMenu
	 * creates the mainmenu using a title (String) and a vector of Command
	 * @see pt.utl.ist.po.ui.Command
	 * @see pt.utl.ist.po.ui.Menu
	 */
	public void openMainMenu() {
		Command<?>[] commands = {new zoo.backend.main.New(this),
					new zoo.backend.main.Open(this),
					new zoo.backend.main.Save(this),
					new zoo.backend.main.SaveAs(this),
					new zoo.backend.main.OperationMenu(this)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/** Calls import method
	 * Check if there is a file with data to import and import if so
	 */
	public void importFile() {
		Import importfile = new Import(this);
	}	  
	
	public static void main(String args[]) {
		Zoo zoomanagement = new Zoo();
		zoomanagement.importFile();
		zoomanagement.openMainMenu();
	}
}
