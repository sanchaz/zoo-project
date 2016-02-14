package zoo.backend.employee;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.employee.MenuEntry.REGISTER;
import static zoo.textui.employee.Message.keyReq;
import static zoo.textui.employee.Message.typeReq;
import static zoo.textui.employee.Message.nameReq;
import static zoo.textui.employee.Message.veterinary;
import static zoo.textui.employee.Message.zookeeper;
import static zoo.textui.employee.Message.duplicateEmployee;
import zoo.textui.employee.UnknownKeyException;

/**
 * Command used to register a new Employee
 */
public class Register extends Command<Zoo> {
	
	/**
	 * Registers a new Employee
	 */
	public void execute() throws InvalidOperation {
		String type = "";
		String key = "";
		String name = "";
		Employee e;
		Vet v;
		Keeper k;
		try{
			while(((type = IO.readString(typeReq())).compareTo(veterinary()) != 0) && (type.compareTo(zookeeper()) != 0));
			key = IO.readString(keyReq());
			e = _entity.getEmployee(key);
			IO.println(duplicateEmployee(key));
			return;
		}catch(IOException excpt) {
			IO.println(excpt.toString());
			return;
		}catch(UnknownKeyException excpt2) {
			try{
				name = IO.readString(nameReq());
				if(type.compareTo(veterinary()) == 0) {
					v = _entity.putVet(key, name);
				}else if(type.compareTo(zookeeper()) == 0) {
					k = _entity.putKeeper(key, name);
				}
				_entity.setChanged(true);
				return;
			}catch(IOException excpt3) {
				IO.println(excpt3.toString());
				return;
			}
		}
	}
	
	/**
	 * Constructor
	 */
	public Register(Zoo entity) {
		super(false, REGISTER, entity);
	}
}
