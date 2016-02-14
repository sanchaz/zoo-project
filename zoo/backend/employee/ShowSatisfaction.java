package zoo.backend.employee;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.employee.MenuEntry.SHOW_SATISFACTION;
import static zoo.textui.employee.Message.keyReq;

/**
 * Command used to check an employees satisfaction
 */
public class ShowSatisfaction extends Command<Zoo> {
	
	/**
	 * Checks employees satisfaction (prints employees satisfaction)
	 */
	public void execute() throws InvalidOperation {
		String key;
		Employee e;
		int satisfaction;
		try{
		   key = IO.readString(keyReq());
		   e = _entity.getEmployee(key);
		   satisfaction = e.getSatisfaction(_entity);
		   IO.println("" + satisfaction);
      }catch(IOException excpt){
         IO.println(excpt.toString());
			return;
      }
		
	}
	
	/**
	 * Constructor
	 */
	public ShowSatisfaction(Zoo entity) {
		super(false, SHOW_SATISFACTION, entity);
	}
}
