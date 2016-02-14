package zoo.backend.employee;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.employee.MenuEntry.REMOVE_RESPONSABILITY;
import static zoo.textui.employee.Message.keyReq;
import static zoo.textui.employee.Message.zookeeper;
import static zoo.textui.employee.Message.veterinary;
import static zoo.textui.habitat.Message.keyReq;
import static zoo.textui.animal.Message.speciesKeyReq;
import zoo.backend.animal.Specie;
import zoo.backend.habitat.Habitat;

/**
 * Command used to remove a responsability to an Employee
 */
public class RemoveResponsability extends Command<Zoo> {
	
	/**
	 * Removes a habitat to the given Employee's Responsabilities
	 */
	public void execute() throws InvalidOperation {
		String key;
		Employee e;
		Vet v;
		Specie s;
		Keeper k;
		Habitat h;
		try{
		   key = IO.readString(zoo.textui.employee.Message.keyReq());
		   e = _entity.getEmployee(key);
		   if(e.getType() == zookeeper()) {
		   	k = (Keeper) e;
		   	key = IO.readString(zoo.textui.habitat.Message.keyReq());
		   	h = _entity.getHabitat(key);
		   	k.rmHabitat(h.getKey());
		   }else if(e.getType() == veterinary()) {
		   	v = (Vet) e;
		   	key = IO.readString(zoo.textui.animal.Message.speciesKeyReq());
		   	s = _entity.getSpecie(key);
		   	v.rmSpecie(s.getKey());
		   }
		   _entity.setChanged(true);
		   return;
      }catch(IOException ecxp){
         IO.println(ecxp.toString());
         return;
      }
	}
	
	/**
	 * Constructor
	 */
	public RemoveResponsability(Zoo entity) {
		super(false, REMOVE_RESPONSABILITY, entity);
	}
}
