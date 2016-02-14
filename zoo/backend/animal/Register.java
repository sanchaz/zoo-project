package zoo.backend.animal;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.animal.MenuEntry.REGISTER;
import static zoo.textui.animal.Message.animalKeyReq;
import static zoo.textui.animal.Message.speciesKeyReq;
import static zoo.textui.animal.Message.animalNameReq;
import static zoo.textui.animal.Message.speciesNameReq;
import static zoo.textui.animal.Message.speechReq;
import static zoo.textui.animal.Message.duplicateAnimal;
import static zoo.textui.animal.Message.habitatKeyReq;
import zoo.textui.animal.UnknownAnimalKeyException;
import zoo.textui.animal.UnknownGroupKeyException;
import zoo.textui.habitat.UnknownKeyException;
import zoo.backend.habitat.Habitat;
/**
 * Command used to register a new animal
 */
public class Register extends Command<Zoo> {
	
	/**
	 * Registers a new animal
	 */
	public void execute() throws InvalidOperation {
		String key = "";
		String name = "";
		String speciekey = "";
		String speciename = "";
		String speech = "";
		String habitatkey = "";
		Animal a;
		Specie s;
		Habitat h;
		try{
			key = IO.readString(animalKeyReq());
			a = _entity.getAnimal(key);
			IO.println(duplicateAnimal(key));
			return;
		}catch(IOException ioexcpt) {
			IO.println(ioexcpt.toString());
			return;
		}catch(UnknownAnimalKeyException e) {
			try{
				name = IO.readString(animalNameReq());
				speciekey = IO.readString(speciesKeyReq());
				s = _entity.getSpecie(speciekey);
				speech = IO.readString(speechReq());
				habitatkey = IO.readString(habitatKeyReq());
				h = _entity.getHabitat(habitatkey);
				a = _entity.putAnimal(key, name, s.getKey(), speech, h.getKey());
				_entity.setChanged(true);
				return;
			}catch(IOException ioexcpt2) {
				IO.println(ioexcpt2.toString());
				return;
			}catch(UnknownGroupKeyException e2) {
				try{
					speciename = IO.readString(speciesNameReq());
					speech = IO.readString(speechReq());
					habitatkey = IO.readString(habitatKeyReq());
					h = _entity.getHabitat(habitatkey);
					s = _entity.putSpecie(speciekey, speciename);
					a = _entity.putAnimal(key, name, s.getKey(), speech, h.getKey());
					_entity.setChanged(true);
					return;
				}catch(IOException ioexcpt3) {
					IO.println(ioexcpt3.toString());
					return;
				}
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
