package zoo.backend.zoo;

//import static pt.utl.ist.po.ui.UserInteraction.IO; //uncomment if any output or input commands need to be used
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.habitat.*;
import static zoo.textui.habitat.MenuEntry.TITLE;
import static zoo.textui.zoo.MenuEntry.HABITATS;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class Habitats extends Command<Zoo> {
	
	/**
	 * Creates and opens the Habitat's Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.habitat.ShowAll(_entity),
					new zoo.backend.habitat.Register(_entity),
					new zoo.backend.habitat.ChangeArea(_entity),
					new zoo.backend.habitat.AddAssociation(_entity),
					new zoo.backend.habitat.RemoveAssociation(_entity),
					new zoo.backend.habitat.NewTree(_entity),
					new zoo.backend.habitat.ChangeTree(_entity),
					new zoo.backend.habitat.ChangeAllTrees(_entity),
					new zoo.backend.habitat.ListTrees(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public Habitats(Zoo entity) {
		super(false, HABITATS, entity);
	}
}
