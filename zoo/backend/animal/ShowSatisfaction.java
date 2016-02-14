package zoo.backend.animal;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.animal.MenuEntry.SHOW_SATISFACTION;
import static zoo.textui.animal.Message.animalKeyReq;

/**
 * Command used to check an animals satisfaction
 */
public class ShowSatisfaction extends Command<Zoo> {
	
	/**
	 * Checks animals satisfaction (prints animals satisfaction)
	 */
	public void execute() throws InvalidOperation {
		String key;
		Animal a;
		int satisfaction;
		try{
		   key = IO.readString(animalKeyReq());
		   a = _entity.getAnimal(key);
		   satisfaction = a.getSatisfaction(_entity);
		   IO.println("" + satisfaction);
      }catch(IOException e){
         IO.println(e.toString());
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
