package zoo.backend.employee;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
//import pt.utl.ist.po.ui.*; //if need activate //remove if not needed
import zoo.Zoo;
import static zoo.textui.employee.Message.*;

public abstract class Employee implements Serializable {
	
	private static final long serialVersionUID = 100;
	
	/**
	 * Employee's key (all employees have a unique key)
	 */
	private String _key;
	/**
	 * Employee's name
	 */
	private String _name;
	/**
	 * Employee's type
	 */
	private String _type;
	
	/**
	 * @return _key Employee's unique key
	 */
	public String getKey() {
		return _key;
	}
	
	/**
	 * @return _name Employee's name
	 */
	public String getName() {
		return _name;
	}
	
	/**
	 * @return _type Employee's function (zookeeper or vet)
	 */
	public String getType() {
		return _type;
	}
	
	/**
    * Calculates animal satisfaction
    */
   public abstract int getSatisfaction(Zoo zoo);
	
	/**
	 * Constructor
	 */
	public Employee(String key, String name, String type) {
		_key = key;
		_name = name;
		_type = type;
	}
		
	
}
