package zoo.backend.main;

import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.zoo.*;
import static zoo.textui.main.MenuEntry.OPERATION;
import static zoo.textui.zoo.MenuEntry.TITLE;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class OperationMenu extends Command<Zoo> {
	
	/**
	 * Creates and opens the Operation Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.zoo.Animals(_entity),
					new zoo.backend.zoo.Employees(_entity),
					new zoo.backend.zoo.Habitats(_entity),
					new zoo.backend.zoo.Vaccines(_entity),
					new zoo.backend.zoo.Lookups(_entity),
					new zoo.backend.zoo.ShowSatisfaction(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public OperationMenu(Zoo entity) {
		super(false, OPERATION, entity);
	}
}
