package fr.campus_numerique.module_java.d_d.pers.types;

import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier.Arme;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier.Bouclier;

public class Guerriers extends Personnage {
    Arme arme;
    Bouclier bouclier;
    public Guerriers(String name){
        super(name, "Guerrier");
        this.setPv(10);
        this.setForceatk(10);
        this.arme = new Arme("Épée",7);
        this.bouclier = new Bouclier("Bouclier en bois",5);
    }
    public String toString() {
        return "Perso : " + this.getNom() + " | type : " + getType() + " | pv : " + this.getPv() + " | force : " + this.getForceatk() + " " + arme.toString()  + " " + bouclier.toString();

    }
}
