package zoo.backend.zoo;

//import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.vaccine.*;
import static zoo.textui.vaccine.MenuEntry.TITLE;
import static zoo.textui.zoo.MenuEntry.VACCINES;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class Vaccines extends Command<Zoo> {
	
	/**
	 * Creates and opens the Vaccine's Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.vaccine.Show(_entity),
					new zoo.backend.vaccine.Register(_entity),
					new zoo.backend.vaccine.Vaccination(_entity),
					new zoo.backend.vaccine.ShowVaccines(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public Vaccines(Zoo entity) {
		super(false, VACCINES, entity);
	}
}
