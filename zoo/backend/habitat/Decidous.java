package zoo.backend.habitat;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import static zoo.textui.habitat.Message.*;

/**
 * Decidous Tree can have a different biological cycle
 * @see zoo.backend.habitat.Tree
 */
public class Decidous extends Tree implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Decidous Tree's biological cycle
	 */
	private String _biologicalcycle = withLeaves();
	
	/**
	 * @return _biologicalcycle returns Decidous Tree's current biological cycle
	 */
	public String getBiologicalCycle() {
		return _biologicalcycle;
	}
	
	/**
	 * Sets Decidous Tree's biological cycle
	 * @param biological Decidous Tree new biological cycle
	 */
	public void setBiologicalCycle(String biologicalcycle) {
		_biologicalcycle = biologicalcycle;
	}
	
	/**
	 * Moves the trees biological cycle to the next cycle
	 */
	public void nextBiologicalCycle() {
		if(getBiologicalCycle().compareTo(withLeaves()) == 0) {
			setBiologicalCycle(fallingLeaves());
		}else if(getBiologicalCycle().compareTo(withoutLeaves()) == 0) {
			setBiologicalCycle(growingLeaves());
		}else if(getBiologicalCycle().compareTo(fallingLeaves()) == 0) {
			setBiologicalCycle(withoutLeaves());
		}else if(getBiologicalCycle().compareTo(growingLeaves()) == 0) {
			setBiologicalCycle(withLeaves());
		}
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return tree() + "|" + getKey() + "|" + getName() + "|" + getCleanDifficulty() + "|" + getBiologicalCycle();
	}
	
	/**
	 * Constructor
	 * @see zoo.backend.habitat.Tree
	 */
	public Decidous(String key, String name, int cleandifficulty) {
		super(key, name, cleandifficulty, caduca());
	}
	
}
