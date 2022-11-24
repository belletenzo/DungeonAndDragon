package fr.campus_numerique.module_java.d_d.ennemy;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public abstract class Ennemi extends Personnage implements Case {

    public Ennemi(String name, int pv, int atk){
        super(name);
        this.pv = pv;
        this.forceatk = atk;
    }
    @Override
    public void interact(Personnage perso) {
        System.out.println("Vous avez rencontré un " + nom);
    }
}
