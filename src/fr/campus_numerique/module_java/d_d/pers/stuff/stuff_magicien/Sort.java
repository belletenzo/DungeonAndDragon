package fr.campus_numerique.module_java.d_d.pers.stuff.stuff_magicien;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.EquipementOffensif;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public class Sort extends EquipementOffensif implements Case {
    public Sort(String name, int atk) {
        super(name, atk);
    }

    @Override
    public void interact(Personnage perso) {
        System.out.println("Vous avez obtenu le sort " + name +" qui vous donne : " + atk + " atk");
    }
}
