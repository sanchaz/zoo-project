package zoo.backend.animal;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.animal.MenuEntry.SHOW_ALL;
import zoo.backend.lookup.SortAnimalsByKey;

/**
 * Command used to show all animals in the zoo
 */
public class ShowAll extends Command<Zoo> {
	
	/**
	 * Shows all animals in the zoo
	 */
	public void execute() throws InvalidOperation {
		List<Animal> animals = _entity.getListOfAnimals();
		Collections.sort(animals, new SortAnimalsByKey());
		for(Animal a : animals) {
			IO.println(a.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public ShowAll(Zoo entity) {
		super(false, SHOW_ALL, entity);
	}
}
