package fr.campus_numerique.module_java.d.d.pers;
import fr.campus_numerique.module_java.d.d.pers.stuff.Philtre;
import fr.campus_numerique.module_java.d.d.pers.stuff.Sort;

public class Magiciens extends Personnage{
    Sort sort;
    Philtre philtre;
    public Magiciens(String name, String type){
        super(name, type);
        this.setPv(6);
        this.setForceatk(15);
        this.sort = new Sort("Foudre",10);
        this.philtre = new Philtre("Potion",6);
    }
    public String toString() {
        return "Perso = Nom : " + this.getNom() + " | type : " + getType() + " | pv : " + this.getPv() + " | force : " + this.getForceatk() + " " + sort.toString() + " " + philtre.toString();

    }
}
