package fr.campus_numerique.module_java.d_d.pers.stuff.stuff_soins;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.plateau.Case;

public abstract class Potion implements Case {
    private String name;
    public int pv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }



    public Potion(String name, int pv){
        this.name = name;
        this.pv = pv;
    }

    @Override
    public void interact(Personnage perso) {
        System.out.println("Vous avez obtenu une " + name +" qui vous donne : " + pv + " pv");
    }
}
