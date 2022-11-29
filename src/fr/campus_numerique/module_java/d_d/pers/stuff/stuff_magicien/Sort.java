package fr.campus_numerique.module_java.d_d.pers.stuff.stuff_magicien;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.EquipementOffensif;
import fr.campus_numerique.module_java.d_d.pers.types.Magiciens;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public class Sort extends EquipementOffensif implements Case {
    public Sort(String name, int atk) {
        super(name, atk);
    }

    @Override
    public boolean interact(Personnage perso) {
        System.out.println("Vous etes tombé sur le sort " + name+".");
        if (perso instanceof Magiciens){
            int newDegat = perso.getForceatk() + getAtk();
            perso.setForceatk(newDegat);
            System.out.println("Cela vous donne : " + atk + " atk en plus");
        } else {
            System.out.println("Vous etes un guerrier, vous ne pouvez donc pas l'aquérir.");
        }
        return true;
    }
}
