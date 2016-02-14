package zoo.backend.main;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.main.MenuEntry.CLOSE;
import static zoo.textui.main.Message.saveBeforeExit;
import static zoo.textui.main.Message.newSaveAs;

/**
 * Closes current file
 */
public class Close extends Command<Zoo> {
	
	/**
	 * Closes current zoo and asks the user if he wants to save, if any changes have been made
	 */
	public void execute() throws InvalidOperation {
		String name;
		try{
			if(_entity.getChanged() == true) {
				if(IO.readBoolean(saveBeforeExit()) == true) {
					if(_entity.getZooFilename() == null) {
						name = IO.readString(newSaveAs());
						_entity.setZooFilename(name);
						_entity.save();
					}else{
						_entity.save();
					}
				}
			}
			_entity.setZooFilename(null);
			return;
		}catch(IOException e) {
			IO.println(e.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public Close(Zoo entity) {
		super(false, CLOSE, entity);
	}
}
