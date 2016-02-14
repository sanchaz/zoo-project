package zoo.backend.vaccine;

import java.io.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import pt.utl.ist.po.ui.*;
import zoo.Zoo;
import static zoo.textui.vaccine.MenuEntry.REGISTER;
import static zoo.textui.vaccine.Message.idReq;
import static zoo.textui.vaccine.Message.duplicateVaccine;
import static zoo.textui.vaccine.Message.nameReq;
import static zoo.textui.vaccine.Message.moreReq;
import static zoo.textui.animal.Message.speciesKeyReq;
import zoo.textui.vaccine.UnknownIdException;
import zoo.textui.animal.UnknownGroupKeyException;
import zoo.backend.animal.Specie;

/**
 * Command used to register a new Vaccine
 */
public class Register extends Command<Zoo> {
	
	/**
	 * Registers a new Vaccine
	 */
	public void execute() throws InvalidOperation {
		String key = "";
		String name = "";
		String speciekey = "";
		boolean more;
		Vaccine v;
		Specie s;
		try{
			key = IO.readString(idReq());
			v = _entity.getVaccine(key);
			IO.println(duplicateVaccine(key));
			return;
		}catch(IOException e) {
			IO.println(e.toString());
			return;
		}catch(UnknownIdException e2) {
			try{
				name = IO.readString(nameReq());
				v = _entity.putVaccine(key, name);
				_entity.setChanged(true);
				while(true) {
					try{
						speciekey = IO.readString(speciesKeyReq());
						s = _entity.getSpecie(speciekey);
						v.addSpecie(s.getKey(), s);
					}catch(IOException e4) {
						IO.println(e4.toString());
						return;
					}catch(UnknownGroupKeyException e5) {
					}finally{
						try{
							more = IO.readBoolean(moreReq());
							if(more == false) {
								return;
							}
						}catch(IOException e6) {
							IO.println(e6.toString());
							return;
						}
					}
				}
			}catch(IOException e3) {
				IO.println(e3.toString());
			return;
			}
		}
	}
	
	/**
	 * 
	 */
	public Register(Zoo entity) {
		super(false, REGISTER, entity);
	}
}
