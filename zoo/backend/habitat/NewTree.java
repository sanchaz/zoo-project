package zoo.backend.habitat;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.NEW_TREE;
import static zoo.textui.habitat.Message.*;
import zoo.textui.habitat.UnknownTreeKeyException;

/**
 * Command used to create a new Tree and add it to a habitat
 */
public class NewTree extends Command<Zoo> {
	
	/**
	 * Creates a new Tree and adds it to a habitat
	 */
	public void execute() throws InvalidOperation {
		String key = "";
		String name = "";
		int difficulty;
		String type = "";
		String habitatkey = "";
		Habitat h;
		Tree t;
		Decidous d;
		Evergreen eg;
		try{
			key = IO.readString(treeKeyReq());
			t = _entity.getTree(key);
			IO.println(duplicateTree(key));
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}catch(UnknownTreeKeyException e2) {
			try{
				name = IO.readString(treeNameReq());
				difficulty = IO.readInteger(treeDifficultyReq());
				while(((type = IO.readString(requestTreeType())).compareTo(caduca()) != 0) && (type.compareTo(perene()) != 0));
				habitatkey = IO.readString(keyReq());
				h = _entity.getHabitat(habitatkey);
				if(type.compareTo(caduca()) == 0) {
					d = _entity.putDecidous(key, name, difficulty);
					h.addTree(d.getKey(), d);
				}else if(type.compareTo(perene()) == 0) {
					eg = _entity.putEvergreen(key, name, difficulty);
					h.addTree(eg.getKey(), eg);
				}
				_entity.setChanged(true);
				return;
			}catch(IOException e3) {
				IO.println(e3.toString());
				return;
			}
		}
	}
	
	/**
	 * Constructor
	 */
	public NewTree(Zoo entity) {
		super(false, NEW_TREE, entity);
	}
}
