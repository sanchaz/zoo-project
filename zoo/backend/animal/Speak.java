package zoo.backend.animal;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.animal.MenuEntry.SPEAK;
import static zoo.textui.animal.Message.animalKeyReq;

/**
 * Command used to tell the animal to speak
 */
public class Speak extends Command<Zoo> {
	
	/**
	 * Tells the animal to speak (prints the animal's speech)
	 */
	public void execute() throws InvalidOperation {
		String key;
		Animal a;
		try{
		   key = IO.readString(animalKeyReq());
		   a = _entity.getAnimal(key);
		   IO.println(a.getSpeechSickness());
      }catch(IOException e){
         IO.println(e.toString());
			return;
      }
	}
	
	/**
	 * Constructor
	 */
	public Speak(Zoo entity) {
		super(false, SPEAK, entity);
	}
}
