package zoo.backend.employee;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.employee.MenuEntry.SHOW_ALL;
import zoo.backend.lookup.SortEmployeesByKey;

public class ShowAll extends Command<Zoo> {
	
	public void execute() throws InvalidOperation {
		List<Employee> employees = _entity.getListOfEmployees();
		Collections.sort(employees, new SortEmployeesByKey());
		for(Employee e : employees) {
			IO.println(e.toString());
		}
	}
	
	/**
	 *
	 */
	public ShowAll(Zoo entity) {
		super(false, SHOW_ALL, entity);
	}
}
