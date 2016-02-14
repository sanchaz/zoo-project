package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.CHANGE_TREE;
import static zoo.textui.habitat.Message.treeKeyReq;
import static zoo.textui.habitat.Message.caduca;
import static zoo.textui.habitat.Message.treeNewBiological;
import static zoo.textui.habitat.Message.withLeaves;
import static zoo.textui.habitat.Message.withoutLeaves;
import static zoo.textui.habitat.Message.fallingLeaves;
import static zoo.textui.habitat.Message.growingLeaves;

/**
 * Command used to change a Tree's habitat
 */
public class ChangeTree extends Command<Zoo> {
	
	/**
	 * Changes the Tree's habitat
	 */
	public void execute() throws InvalidOperation {
		String key;
		Tree t;
		Decidous d;
		try{
			key = IO.readString(treeKeyReq());
			t = _entity.getTree(key);
			if(t.getType().compareTo(caduca()) == 0) {
				d = (Decidous) t;
				while(((key = IO.readString(treeNewBiological())).compareTo(withLeaves()) != 0) && (key.compareTo(withoutLeaves()) != 0) && (key.compareTo(fallingLeaves()) != 0) && (key.compareTo(growingLeaves()) != 0));
				d.setBiologicalCycle(key);
				_entity.setChanged(true);
			}
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}	
	}
	
	/**
	 * Constructor
	 */
	public ChangeTree(Zoo entity) {
		super(false, CHANGE_TREE, entity);
	}
}
