package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.REMOVE_ASSOCIATION;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.animal.Message.speciesKeyReq;
import zoo.backend.animal.Specie;

/**
 * Command used to remove a specie to a habitat with positive or negative effect
 */
public class RemoveAssociation extends Command<Zoo> {
	
	/**
	 * Removes positive or negative effect a given habitat has on a given species
	 */
	public void execute() throws InvalidOperation {
		String key;
		Habitat h;
		Specie s;
		try{
			key = IO.readString(keyReq());
			h = _entity.getHabitat(key);
			key = IO.readString(speciesKeyReq());
			s = _entity.getSpecie(key);
			h.rmSpecie(s.getKey());
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
	public RemoveAssociation(Zoo entity) {
		super(false, REMOVE_ASSOCIATION, entity);
	}
}
