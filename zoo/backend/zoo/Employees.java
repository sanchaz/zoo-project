package zoo.backend.zoo;

//import static pt.utl.ist.po.ui.UserInteraction.IO; //uncomment if any output or input commands need to be used
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import zoo.backend.employee.*;
import static zoo.textui.employee.MenuEntry.TITLE;
import static zoo.textui.zoo.MenuEntry.EMPLOYEES;

/**
 * Menu command
 * Command that will bring up a menu when execute is called.
 */
public class Employees extends Command<Zoo> {
	
	/**
	 * Creates and opens the Employee's Menu
	 */
	public void execute() throws InvalidOperation {
		Command<?>[] commands = {new zoo.backend.employee.ShowAll(_entity),
					new zoo.backend.employee.Register(_entity),
					new zoo.backend.employee.AddResponsability(_entity),
					new zoo.backend.employee.RemoveResponsability(_entity),
					new zoo.backend.employee.ShowSatisfaction(_entity)
					};
		Menu mainmenu = new Menu(TITLE, commands);
		mainmenu.open();
	}
	
	/**
	 * Constructor
	 */
	public Employees(Zoo entity) {
		super(false, EMPLOYEES, entity);
	}
}
