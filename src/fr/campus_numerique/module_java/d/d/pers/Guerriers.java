package fr.campus_numerique.module_java.d.d.pers;

import fr.campus_numerique.module_java.d.d.pers.stuff.Arme;
import fr.campus_numerique.module_java.d.d.pers.stuff.Bouclier;

public class Guerriers extends Personnage{
    Arme arme;
    Bouclier bouclier;
    public Guerriers(String name, String type){
        super(name, type);
        this.setPv(10);
        this.setForceatk(10);
        this.arme = new Arme("Épée",7);
        this.bouclier = new Bouclier("Bouclier en bois",5);
    }
    public String toString() {
        return "Perso : " + this.getNom() + " | type : " + getType() + " | pv : " + this.getPv() + " | force : " + this.getForceatk() + " " + arme.toString()  + " " + bouclier.toString();

    }
}
