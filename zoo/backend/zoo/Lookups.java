package zoo.backend.zoo;

//import static pt.utl.ist.po.ui.UserInteraction.IO; //uncomment if any output or input commands need to be used
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.lookup.*;
import static zoo.textui.lookup.MenuEntry.TITLE;
import static zoo.textui.zoo.MenuEntry.LOOKUPS;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class Lookups extends Command<Zoo> {
	
	/**
	 * Creates and opens the Lookup's Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.lookup.AnimalsHabitat(_entity),
					new zoo.backend.lookup.VaccinesAnimal(_entity),
					new zoo.backend.lookup.MedicalActsVet(_entity),
					new zoo.backend.lookup.WrongVaccines(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public Lookups(Zoo entity) {
		super(false, LOOKUPS, entity);
	}
}
