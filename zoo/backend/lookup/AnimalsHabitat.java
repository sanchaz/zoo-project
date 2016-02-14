package zoo.backend.lookup;

import java.util.*;
import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.lookup.MenuEntry.ANIMALS_HABITAT;
import static zoo.textui.habitat.Message.*;
import zoo.textui.habitat.UnknownKeyException;
import zoo.backend.habitat.Habitat;
import zoo.backend.animal.Animal;
/**
 * AnimalsHabitat is a lookup command which prints out all animals.
 * The user inputs a habitat key and if that habitat exists the output
 * is a list of all animals in that habitat
 */
public class AnimalsHabitat extends Command<Zoo> {
	
	/** Executes the command
	 * Prints all animals from a given habitat
	 */
	public void execute() throws InvalidOperation {
		Habitat h;
		String key;
		List<Animal> animals;
		InvalidOperation ex;
		try{
			key = IO.readString(keyReq());
			h = _entity.getHabitat(key);
			animals = h.getListOfAnimals();
			Collections.sort(animals, new SortAnimalsByKey());
			for(Animal a : animals) {
				IO.println(a.toString());
			}			
		}catch (IOException e) {
			IO.println(e.toString());
			return;
		}
		
	}
	
	/**
	 * Construtor
	 */
	public AnimalsHabitat(Zoo entity) {
		super(false, ANIMALS_HABITAT, entity);
	}
}
