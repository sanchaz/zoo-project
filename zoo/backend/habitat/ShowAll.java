package zoo.backend.habitat;

import java.util.*;
import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.habitat.MenuEntry.SHOW_ALL;
import zoo.backend.lookup.SortHabitatsByKey;
import zoo.backend.lookup.SortTreesByKey;

/**
 * Command used to show all habitats in th Zoo
 */
public class ShowAll extends Command<Zoo> {
	
	/**
	 * Shows all habitats in the zoo
	 */
	public void execute() throws InvalidOperation {
		List<Habitat> habitats = _entity.getListOfHabitats();
		List<Tree> trees;
		Collections.sort(habitats, new SortHabitatsByKey());
		for(Habitat h : habitats) {
			trees = h.getListOfTrees();
			Collections.sort(trees, new SortTreesByKey());
			IO.println(h.toString());
			for(Tree t : trees) {
				IO.println(t.toString());
			}
		}
	}
	
	/**
	 * Constructor
	 */
	public ShowAll(Zoo entity) {
		super(false, SHOW_ALL, entity);
	}
}
