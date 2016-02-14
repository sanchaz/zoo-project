package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.REGISTER;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.habitat.Message.nameReq;
import static zoo.textui.habitat.Message.areaReq;
import static zoo.textui.habitat.Message.duplicateHabitat;
import zoo.textui.habitat.UnknownKeyException;

/**
 * Command used to register a new Habitat
 */
public class Register extends Command<Zoo> {
	
	/**
	 * Creates a new Habitat
	 */
	public void execute() throws InvalidOperation {
		String key = "";
		String name = "";
		int area;
		Habitat h;
		try{
			key = IO.readString(keyReq());
			h = _entity.getHabitat(key);
			IO.println(duplicateHabitat(key));
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}catch(UnknownKeyException e) {
			try{
				name = IO.readString(nameReq());
				area = IO.readInteger(areaReq());
				h = _entity.putHabitat(key, name, area);
				_entity.setChanged(true);
				return;
			}catch(IOException e2) {
				IO.println(e2.toString());
				return;
			}
		}
	}
	
	/**
	 * Constructor
	 */
	public Register(Zoo entity) {
		super(false, REGISTER, entity);
	}
}
