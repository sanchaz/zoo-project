package zoo.backend.zoo;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO; //uncomment if any output or input commands need to be used
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.zoo.MenuEntry.SHOW_SATISFACTION;
import zoo.backend.animal.Animal;
import zoo.backend.employee.Employee;

/**
 * Command used to show total Zoo satisfaction
 */
public class ShowSatisfaction extends Command<Zoo> {
	
	/**
	 * Adds up all satisfaction from animals and employees.
	 */
	public void execute() throws InvalidOperation {
		int satisfaction = 0;
		List<Animal> animals = _entity.getListOfAnimals();
		List<Employee> employees = _entity.getListOfEmployees();
		for(Animal a : animals) {
			satisfaction += a.getSatisfaction(_entity);
		}
		for(Employee e : employees) {
			satisfaction += e.getSatisfaction(_entity);
		}
		IO.println("" + satisfaction);
	}
	
	/**
	 * Constructor
	 */
	public ShowSatisfaction(Zoo entity) {
		super(false, SHOW_SATISFACTION, entity);
	}
}
