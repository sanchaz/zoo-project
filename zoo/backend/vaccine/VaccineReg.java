package zoo.backend.vaccine;

import java.io.Serializable;
import static pt.utl.ist.po.ui.UserInteraction.IO;
import static zoo.textui.vaccine.Message.vacOperation;
import zoo.backend.animal.Animal;
import zoo.backend.employee.Vet;

public class VaccineReg implements Serializable {
   
	private static final long serialVersionUID = 100;
	
   /**
    * Animal the vaccine was ministrated to
    */
   private Animal _animal;
   
   /**
    * Vet that ministrated the vaccine to the animal
    */
   private Vet _vet;
   
   /**
    * Vaccine that was ministrated to the animal
    */
   private Vaccine _vaccine;
   
   /**
    * Indicates if the vaccine was wrongly ministered or not
    */
   private boolean _wrong;
   
   /**
    * @return _animal the animal the vaccine was ministrated to
    */
   public Animal getAnimal() {
      return _animal;
   }
   
   /**
    * @return _vet the vet that ministrated the vaccine to the animal
    */
   public Vet getVet() {
      return _vet;
   }
   
   
   /**
    * @return _vaccine the vaccine that was ministrated to the animal
    */
   public Vaccine getVaccine() {
      return _vaccine;
   }
   
      /**
    * @return _wrong Indicates if the vaccine was wrongly ministered or not (true or false)
    */
   public boolean getWrong() {
      return _wrong;
   }
   
   
   /**
    *
    */
   public String toString() {
      return vacOperation() + "|" + getVaccine().getKey() + "|" + getVet().getKey() + "|" + getAnimal().getKey();
   }
   
   public VaccineReg(Vaccine vac, Vet v, Animal a, boolean wrong) {
      _vaccine = vac;
      _vet = v;
      _animal = a;
      _wrong = wrong;
   }
   
}
