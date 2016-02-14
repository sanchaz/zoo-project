package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.CHANGE_AREA;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.habitat.Message.requestNewArea;

/**
 * Command used to change a habitat's area
 */
public class ChangeArea extends Command<Zoo> {
	
	/**
	 * Changes a habitat's area
	 */
	public void execute() throws InvalidOperation {
		String key;
		int a;
		Habitat h;
		try{
			key = IO.readString(keyReq());
			h = _entity.getHabitat(key);
			a = IO.readInteger(requestNewArea(h.getArea()));
			h.setArea(a);
			_entity.setChanged(true);
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}
	}
	
	/**
	 * Constructor
	 */
	public ChangeArea(Zoo entity) {
		super(false, CHANGE_AREA, entity);
	}
}
