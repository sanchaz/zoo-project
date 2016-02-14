package zoo.backend.habitat;

import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.LIST_TREES;
import zoo.backend.lookup.SortTreesByKey;

/**
 * Command used to list all Trees in the Zoo
 */
public class ListTrees extends Command<Zoo> {
	
	/**
	 * Lists all Trees in the Zoo
	 */
	public void execute() throws InvalidOperation {
		List<Tree> trees = _entity.getListOfTrees();
		Collections.sort(trees, new SortTreesByKey());
		for(Tree t : trees) {
			IO.println(t.toString());
		}
	}
	
	/**
	 * Constructor
	 */
	public ListTrees(Zoo entity) {
		super(false, LIST_TREES, entity);
	}
}
