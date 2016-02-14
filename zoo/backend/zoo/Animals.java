package zoo.backend.zoo;

//import static pt.utl.ist.po.ui.UserInteraction.IO; //uncomment if any output or input commands need to be used
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.animal.*;
import static zoo.textui.animal.MenuEntry.TITLE;
import static zoo.textui.zoo.MenuEntry.ANIMALS;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class Animals extends Command<Zoo> {
	
	/**
	 * Creates and opens the Animal's Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.animal.ShowAll(_entity),
					new zoo.backend.animal.Register(_entity),
					new zoo.backend.animal.Transfer(_entity),
					new zoo.backend.animal.Speak(_entity),
					new zoo.backend.animal.ShowSatisfaction(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public Animals(Zoo entity) {
		super(false, ANIMALS, entity);
	}
}
