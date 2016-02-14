package zoo.backend;

import java.io.*;
import zoo.Zoo;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import static zoo.textui.animal.Message.animal;
import static zoo.textui.employee.Message.zookeeper;
import static zoo.textui.employee.Message.veterinary;
import static zoo.textui.habitat.Message.caduca;
import static zoo.textui.habitat.Message.perene;
import static zoo.textui.habitat.Message.tree;
import static zoo.textui.habitat.Message.habitat;
import static zoo.textui.vaccine.Message.vaccine;
import zoo.textui.animal.*;
import zoo.textui.habitat.*;
import zoo.backend.animal.Animal;
import zoo.backend.animal.Specie;
import zoo.backend.employee.Keeper;
import zoo.backend.employee.Vet;
import zoo.backend.habitat.Habitat;
import zoo.backend.habitat.Tree;
import zoo.backend.habitat.Decidous;
import zoo.backend.vaccine.Vaccine;


public class Import {
	
	private static final class Messages {
		
		/**
		 * @return import file property name
		 */
		private static final String inputFile() {
			return "Import";
		}
		
		/**
		 * @return string "SPECIES"
		 */
		 private static final String species() {
		 	return "SPECIES";
		 }
	}
	/*BufferedReader to read file*/
	private BufferedReader _import;
	/* Name of the file where the data is to be imported from*/
	private String _filename;
	/* name of the object Zoo, where data is supost to be imported to*/
	private Zoo _zooname;	
	
	/** Constructor
	 * Checks if file exists, and if so calls method to treat it
	 */
	public Import(Zoo zooname) {
		_zooname = zooname;
		try{
			_filename = System.getProperty(Messages.inputFile());
			_import = new BufferedReader(new FileReader(_filename));
			processFile(_import);
			_import.close();			
		}catch(FileNotFoundException fn) {
			IO.println(fn.toString());
		}catch(IOException e) {
			//IO.println(e.toString());
		}catch(NullPointerException e) {
			//IO.println(e.toString());
		}
	}
	
	/** Process a Animal
	 * Reads the previously identified line, and tells the zoo to put in a new animal
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processAnimal(String[] linevector) {
		Animal a = _zooname.putAnimal(linevector[1], linevector[2], linevector[3], linevector[4], linevector[5]);
		Habitat h;
		try{
			h = _zooname.getHabitat(a.getHabitat());
			h.addAnimal(a.getKey(), a);
		}catch(zoo.textui.habitat.UnknownKeyException e) {
			IO.println(e.toString());
		}
		
	}
	
	/** Process a Species
	 * Reads the previously identified line, and tells the zoo to put in a new species
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processSpecies(String[] linevector) {
		_zooname.putSpecie(linevector[1], linevector[2]);
	}
	
	/** Process a Keeper
	 * Reads the previously identified line, and tells the zoo to put in a new keeper
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processKeeper(String[] linevector) {
		Keeper k;
		String[] s;
		Habitat h;
		k = _zooname.putKeeper(linevector[1], linevector[2]);
		if(linevector.length == 4) {
			s = linevector[3].split(",");
			for(int i = 0; i < s.length; i++) {
				try{
					h = _zooname.getHabitat(s[i]);
					k.addHabitat(h.getKey(), h);
				}catch(zoo.textui.habitat.UnknownKeyException e){
					IO.println(e.toString());
				}
			}
		}
	}
	
	/** Process a Vet
	 * Reads the previously identified line, and tells the zoo to put in a new vet
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processVet(String[] linevector) {
		Vet v;
		String[] s;
		Specie sp;
		v = _zooname.putVet(linevector[1], linevector[2]);
		if(linevector.length == 4) {
			s = linevector[3].split(",");
			for(int i = 0; i < s.length; i++) {
				try{
					sp = _zooname.getSpecie(s[i]);
					v.addSpecie(sp.getKey(), sp);
				}catch(zoo.textui.animal.UnknownGroupKeyException e){
					IO.println(e.toString());
				}
			}
		}
	}
	
	/** Process a Habitat
	 * Reads the previously identified line, and tells the zoo to put in a new habitat
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processHabitat(String[] linevector) {
		Habitat h;
		String[] s;
		Tree t;
		h = _zooname.putHabitat(linevector[1], linevector[2], Integer.parseInt(linevector[3]));
		if(linevector.length == 5) {
			s = linevector[4].split(",");
			for(int i = 0; i < s.length; i++) {
				try{
					t = _zooname.getTree(s[i]);
					t.setHabitat(h.getKey());
					h.addTree(t.getKey(), t);
				}catch(zoo.textui.habitat.UnknownTreeKeyException e){
					IO.println(e.toString());
				}
			}
		}
	}
	
	/** Process a Tree
	 * Reads the previously identified line, and tells the zoo to put in a new tree
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processTree(String[] linevector) {
		Decidous dt;
		if((linevector[4].compareTo(perene())) == 0) {
			_zooname.putEvergreen(linevector[1], linevector[2], Integer.parseInt(linevector[3]));
		}else{
			dt = _zooname.putDecidous(linevector[1], linevector[2], Integer.parseInt(linevector[3]));
			dt.setBiologicalCycle(linevector[4]);
		}
	}
	
	/** Process a Vaccine
	 * Reads the previously identified line, and tells the zoo to put in a new vaccine
	 * @param linevector a vector of String containing all the information of the new object
	 */
	private void processVaccine(String[] linevector) {
		Vaccine v;
		String[] s;
		Specie sp;
		v = _zooname.putVaccine(linevector[1], linevector[2]);
		if(linevector.length == 4) {
			s = linevector[3].split(",");
			for(int i = 0; i < s.length; i++) {
				try{
					sp = _zooname.getSpecie(s[i]);
					v.addSpecie(sp.getKey(), sp);
				}catch(zoo.textui.animal.UnknownGroupKeyException e){
					IO.println(e.toString());
				}
			}
		}
	}
	
	/** Processes each line of the file
	 * Reads the first paramter in each line and calls the corresponding method to treat it
	 * @param file file to read from
	 */	
	private void processFile(BufferedReader file) {
		String line;
		String[] linevector;
		try{
			line = file.readLine();
			while(line != null) {
				linevector = line.split("\\|");
				if((linevector[0].compareTo(animal())) == 0) {
					processAnimal(linevector);
				}else if((linevector[0].compareTo(Messages.species())) == 0) {
					processSpecies(linevector);
				}else if((linevector[0].compareTo(zookeeper())) == 0) {
					processKeeper(linevector);
				}else if((linevector[0].compareTo(veterinary())) == 0) {
					processVet(linevector);
				}else if((linevector[0].compareTo(habitat())) == 0) {
					processHabitat(linevector);
				}else if((linevector[0].compareTo(tree())) == 0) {
					processTree(linevector);
				}else if((linevector[0].compareTo(vaccine())) == 0) {
					processVaccine(linevector);
				}
				line = file.readLine();				
			}
		}catch (IOException e) {
			IO.println(e.toString());
		}

	}
}
	
