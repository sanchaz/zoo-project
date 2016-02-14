package zoo.backend.main;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.main.MenuEntry.NEW;
import static zoo.textui.main.Message.saveBeforeExit;
import static zoo.textui.main.Message.newSaveAs;

/**
 * Create new filename to
 */
public class New extends Command<Zoo> {
	
	/**
	 * Create new file
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
			_entity.clean();
			_entity.setZooFilename(null);
			return;
		}catch(IOException e) {
			IO.println(e.toString());
		}
	}

	/**
	 * Constructor
	 */
	public New(Zoo entity) {
		super(false, NEW, entity);
	}
}
