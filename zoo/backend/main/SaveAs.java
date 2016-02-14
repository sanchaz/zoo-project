package zoo.backend.main;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.main.MenuEntry.SAVE_AS;
import static zoo.textui.main.Message.saveAs;
import static zoo.textui.main.Message.fileNotFound;

/**
 * Command used to serialize current zoo with a new name (save the current Zoo under a new name)
 */
public class SaveAs extends Command<Zoo> {
	
	/**
	 * Serialize Zoo with a new name
	 */
	public void execute() throws InvalidOperation {
		String name;
		try{
			name = IO.readString(saveAs());
			_entity.setZooFilename(name);
			_entity.save();
		}catch(IOException e) {
			IO.println(e.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public SaveAs(Zoo entity) {
		super(false, SAVE_AS, entity);
	}
}
