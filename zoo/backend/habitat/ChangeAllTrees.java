package zoo.backend.habitat;

import java.io.*;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.CHANGE_ALL_TREES;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.habitat.Message.caduca;

/**
 * Command used to change all the trees decidous trees biological cycles of a given habitat to the next biological cycle 
 */
public class ChangeAllTrees extends Command<Zoo> {
	
	/**
	 * Changes the Tree's biological cycle
	 */
	public void execute() throws InvalidOperation {
		String key;
		Habitat h;
		List<Tree> trees;
		Decidous d;
		try{
			key = IO.readString(keyReq());
			h = _entity.getHabitat(key);
			trees = h.getListOfTrees();
			for(Tree t : trees) {
				if(t.getType().compareTo(caduca()) == 0) {
					d = (Decidous) t;
					d.nextBiologicalCycle();
				}
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
	public ChangeAllTrees(Zoo entity) {
		super(false, CHANGE_ALL_TREES, entity);
	}
}
