package fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.EquipementOffensif;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public class Arme extends EquipementOffensif implements Case {
    public Arme(String name, int atk) {
        super(name, atk);
    }

    @Override
    public void interact(Personnage perso) {
        System.out.println("Vous avez obtenu une " + name +" qui vous donne : " + atk + " atk");
    }
}
