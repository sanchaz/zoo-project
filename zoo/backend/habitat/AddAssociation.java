package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.ADD_ASSOCIATION;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.habitat.Message.requestSense;
import static zoo.textui.habitat.Message.positive;
import static zoo.textui.habitat.Message.negative;
import static zoo.textui.animal.Message.speciesKeyReq;
import zoo.backend.animal.Specie;

/**
 * Command used to add a specie to a habitat with positive or negative effect
 */
public class AddAssociation extends Command<Zoo> {
	
	/**
	 * Adds positive or negative effect a given habitat has on a given species
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
			while(((key = IO.readString(requestSense())).compareTo(positive()) != 0) && (key.compareTo(negative()) != 0));
			if(key.compareTo(positive()) == 0) {
				h.addPosSpecie(s.getKey(), s);
			}else if(key.compareTo(negative()) == 0) {
				h.addNegSpecie(s.getKey(), s);
			}
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
	public AddAssociation(Zoo entity) {
		super(false, ADD_ASSOCIATION, entity);
	}
}
