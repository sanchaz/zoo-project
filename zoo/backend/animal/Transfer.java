package zoo.backend.animal;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.animal.MenuEntry.TRANSFER;
import static zoo.textui.animal.Message.animalKeyReq;
import static zoo.textui.animal.Message.habitatKeyReq;
import zoo.backend.habitat.Habitat;

/**
 * Command used to transfer an animal from one habitat to another
 */
public class Transfer extends Command<Zoo> {
	
	/**
	 * Transfers an animal from one habitat to another
	 */
	public void execute() throws InvalidOperation {
		String key;
		String oldhabitat;
		Animal a;
		Habitat oldh;
		Habitat newh;
		try{
		   key = IO.readString(animalKeyReq());
		   a = _entity.getAnimal(key);
		   key = IO.readString(habitatKeyReq());
		   newh = _entity.getHabitat(key);
		   oldh = _entity.getHabitat(a.getHabitat());
		   oldh.rmAnimal(a.getKey());
		   a.setHabitat(newh.getKey());
		   newh.addAnimal(a.getKey(), a);
		   _entity.setChanged(true);
		   return;
      }catch(IOException e){
         IO.println(e.toString());
			return;
      }
	}
	
	/**
	 * Constructor
	 */
	public Transfer(Zoo entity) {
		super(false, TRANSFER, entity);
	}
}
