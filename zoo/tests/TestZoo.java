package zoo.tests;

import junit.framework.TestCase;
import java.lang.*;
import java.util.*;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import zoo.Zoo;
import zoo.backend.animal.Animal;
import zoo.backend.habitat.Habitat;
import zoo.textui.habitat.*;
public class TestZoo extends TestCase{
	
	/**
	 * name of the zoo instance
	 */
	private Zoo _zootest;
	
	/**
	 * Creates an instance of the zoo and iniciates it with a species, habitat and 3 animals for testing
	 */
	public void setUp() {
		try{	
			_zootest = new Zoo();
			Habitat h;
			Animal a;
			_zootest.putHabitat("HT1", "Habitat test 1", 20);
			_zootest.putSpecie("ST1", "Species test 1");
			a = _zootest.putAnimal("AT1", "Animal test 1", "ST1", "uh!?", "HT1");
			h = _zootest.getHabitat("HT1");
			h.addAnimal(a.getKey(), a);
			a = _zootest.putAnimal("AT2", "Animal test 2", "ST1", "uhhhhh!?", "HT1");
			h.addAnimal(a.getKey(), a);
			a = _zootest.putAnimal("AT3", "Animal test 3", "ST1", "aaaa!?", "HT1");
			h.addAnimal(a.getKey(), a);
		}catch (zoo.textui.habitat.UnknownKeyException e) {
			IO.println(e.toString());
		}
	}
	
	/**
	 * Tests if the 3 animals are returned as they should be
	 */
	public void testHabitatAnimals() {
		List<Animal> animalstest;
		Habitat h;
		try{
			h = _zootest.getHabitat("HT1");
			animalstest = _zootest.getListOfAnimals();
			if(animalstest.size() != 3) {
				fail("Not all animals are in returned list, or there are more animals than what there's suppost to be. something went wrong?");
			}
			for(Animal a : animalstest) {
				if((a.getKey() != "AT1") && (a.getKey() != "AT2") && (a.getKey() != "AT3")) {
					fail("This animal with the key " + a.getKey() + " wasn't suppost to be here. Where did he come from. Something went wrong!?");
				}
				if((a.getKey() == "AT1") && (a.toString().compareTo("ANIMAL|AT1|Animal test 1|ST1|uh!?|HT1") != 0)) {
					fail("Animal with the key " + a.getKey() + " has toString wrong!? maybe other parameters are wrong!?");
				}
				if((a.getKey() == "AT2") && (a.toString().compareTo("ANIMAL|AT2|Animal test 2|ST1|uhhhhh!?|HT1") != 0)) {
					fail("Animal with the key " + a.getKey() + " has toString wrong!? maybe other parameters are wrong!?");
				}
				if((a.getKey() == "AT3") && (a.toString().compareTo("ANIMAL|AT3|Animal test 3|ST1|aaaa!?|HT1") != 0)) {
					fail("Animal with the key " + a.getKey() + " has toString wrong!? maybe other parameters are wrong!?");
				}
			}
			h = _zootest.getHabitat("HT2");
			fail("Habitat with key HT2 does not exist. Where did u get that from? Something weny wrong!?");
		}catch (zoo.textui.habitat.UnknownKeyException e) {
		}
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestZoo.class);
		//junit.swingui.TestRunner.run(TestZoo.class);
		//junit.awtui.TestRunner.run(TestZoo.class);
	}
	
}
