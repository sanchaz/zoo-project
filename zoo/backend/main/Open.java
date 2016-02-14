package zoo.backend.main;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.main.MenuEntry.OPEN;
import static zoo.textui.main.MenuEntry.CLOSE;
import static zoo.textui.main.Message.saveBeforeExit;
import static zoo.textui.main.Message.openFile;
import static zoo.textui.main.Message.newSaveAs;
import static zoo.textui.main.Message.fileNotFound;

/**
 * Open an existing zoo deserialize
 */
public class Open extends Command<Zoo> {
	
	/**
	 * Open an existing zoo
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
			name = IO.readString(openFile());
			_entity.setZooFilename(name);
			_entity.open();
			return;
		}catch(FileNotFoundException e) {
			IO.println(fileNotFound());
			_entity.setZooFilename(null);
			return;
		}catch(ClassNotFoundException e) {
			IO.println(e.toString());
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}
	}

	/**
	 * Constructor
	 */
	public Open(Zoo entity) {
		super(false, OPEN, entity);
	}
}
