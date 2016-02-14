package zoo.backend.main;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.main.MenuEntry.SAVE;
import static zoo.textui.main.Message.newSaveAs;

/**
 * Command to Serialize current zoo (save the current zoo)
 */
public class Save extends Command<Zoo> {
	
	/**
	 * Serialize current Zoo
	 */
	public void execute() throws InvalidOperation {
		String name;
		try{
			if(_entity.getZooFilename() == null) {
				name = IO.readString(newSaveAs());
				_entity.setZooFilename(name);
				_entity.save();
			}else{
				if(_entity.getChanged() == true) {
				_entity.save();
				}
			}
		}catch(IOException e) {
			IO.println(e.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public Save(Zoo entity) {
		super(false, SAVE, entity);
	}
}
