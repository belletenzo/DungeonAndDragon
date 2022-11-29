package fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.EquipementOffensif;
import fr.campus_numerique.module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public class Arme extends EquipementOffensif implements Case {
    public Arme(String name, int atk) {
        super(name, atk);
    }

    @Override
    public boolean interact(Personnage perso) {
        System.out.println("Vous etes tombé sur une " + name+".");
        if (perso instanceof Guerriers){
            int newDegat = perso.getForceatk() + getAtk();
            perso.setForceatk(newDegat);
            System.out.println("Cela vous donne : " + atk + " atk en plus.");
        } else {
            System.out.println("Vous etes un magicien, vous ne pouvez donc pas l'aquérir.");
        }
        return true;
    }
}
