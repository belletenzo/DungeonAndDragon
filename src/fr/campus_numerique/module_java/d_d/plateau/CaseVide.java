package fr.campus_numerique.module_java.d_d.plateau;

import fr.campus_numerique.module_java.d_d.pers.Personnage;

public class CaseVide implements Case {
public String message;

    public CaseVide() {
        this.message = "Cette case est vide.";
    }

    @Override
    public boolean interact(Personnage perso) {
        System.out.println(message);
        return true;
    }
}

