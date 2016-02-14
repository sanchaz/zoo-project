package zoo.backend.employee;

import java.io.Serializable;
import java.util.*;
import static java.lang.Math.round;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import zoo.Zoo;
import static zoo.textui.employee.Message.*;
import static zoo.textui.habitat.Message.perene;
import static zoo.textui.habitat.Message.caduca;
import static zoo.textui.habitat.Message.withLeaves;
import static zoo.textui.habitat.Message.withoutLeaves;
import static zoo.textui.habitat.Message.fallingLeaves;
import static zoo.textui.habitat.Message.growingLeaves;
import zoo.backend.habitat.*;
import zoo.backend.lookup.SortHabitatsByKey;

public class Keeper extends Employee implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * LinkedHashMap containing the Keeper's habitats (habitats he is responsible for)
	 */
	private Map<String, Habitat> _habitats = new LinkedHashMap<String, Habitat>();
	
	/**
	 * @return _habitats Returns a LinkedHashMap containg of all the habitats the Keeper is responsible for
	 */
	public Map<String, Habitat> getHabitats() {
		return _habitats;
	}
	
	/**
	 * @return habitats LinkedList containing all the habitats the keeper is responsible for
	 */
	public List<Habitat> getListOfHabitats() {
		List<Habitat> habitats = new ArrayList<Habitat>(getHabitats().values());
		return habitats;
	}
			
	/**
	 * Add a habitat to the Keeper's habitats (that is the Keeper is now responsible for one more habitat)
	 * @param key Habitats key to add
	 * @param habitat Habitat to add
	 */
	public void addHabitat(String key, Habitat habitat) {
		if(getHabitats().containsKey(key) == false) {
			getHabitats().put(key, habitat);
		}
	}
	
	/**
	 * Remove a habitat from the Keeper's habitats (that is the Keeper is not responsible for the passed habitat anymore)
	 * @param key Habitats key to remove
	 */
	public void rmHabitat(String key) {
		if(getHabitats().containsKey(key) == true) {
			getHabitats().remove(key);
		}else{
			IO.println(noResponsability(key));
		}
	}
	
	public int getSatisfaction(Zoo zoo) {
		float work;
		float keepers;
		float difficulty;
		float area;
		float pop;
		float temp = 0;
		int satisfaction = 300;
		boolean out = false;
		List<Employee> employees = zoo.getListOfEmployees();
		List<Habitat> habitats = getListOfHabitats();
		Keeper k;
		Decidous d;
		for(Habitat h : habitats) {
			work = 0;
			area = 0;
			pop = 0;
			difficulty = 0;
			keepers = 0;
			area = (float) h.getArea();
			pop = h.getListOfAnimals().size();
			for(Tree t : h.getListOfTrees()) {
				if(t.getType().compareTo(perene()) == 0) {
					difficulty += (float) (t.getCleanDifficulty()*3);
				}else if(t.getType().compareTo(caduca()) == 0) {
					d = (Decidous) t;
					if(d.getBiologicalCycle().compareTo(withLeaves()) == 0) {
						difficulty += (float) (d.getCleanDifficulty()*2);
					}else if(d.getBiologicalCycle().compareTo(withoutLeaves()) == 0) {
						difficulty += (float) (d.getCleanDifficulty()*0);
					}else if(d.getBiologicalCycle().compareTo(fallingLeaves()) == 0) {
						difficulty += (float) (d.getCleanDifficulty()*5);
					}else if(d.getBiologicalCycle().compareTo(growingLeaves()) == 0) {
						difficulty += (float) (d.getCleanDifficulty()*1);
					}
				}
			}
			work = area + (3*pop) + difficulty;
			for(Employee e : employees) {
				if(e.getType().compareTo(zookeeper()) == 0) {
					k = (Keeper) e;
					for(Habitat h2 : k.getListOfHabitats()) {
						if(h.getKey().compareTo(h2.getKey()) == 0) {
							keepers++;
						}
					}
				}
			}
			//IO.println("work " + work + "area " + area + "pop " + pop + "difficulty " + difficulty + "keepers " + keepers); //for testing
			temp += (work/keepers);
		}
		satisfaction -= round(temp);
		return satisfaction;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		List<Habitat> habitats = getListOfHabitats();
		String ts = zookeeper() + "|" + getKey() + "|" + getName();
		int n = 0;
		Collections.sort(habitats, new SortHabitatsByKey());
		for(Habitat h : habitats) {
			if((n == 0) && (habitats.size() > 0)) {
				ts += "|";
			}
			ts += h.getKey();
			if(n < (habitats.size() - 1)) {
				ts += ",";
				n++;
			}
		}
		return ts;
	}
	
	/**
	 * Constructor
	 * @see zoo.backend.employee.Employee
	 */
	public Keeper(String key, String name) {
		super(key, name, zookeeper());
	}
		
}
