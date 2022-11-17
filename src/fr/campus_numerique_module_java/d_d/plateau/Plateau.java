package fr.campus_numerique_module_java.d_d.plateau;

import fr.campus_numerique_module_java.d_d.pers.Personnage;

public class Plateau {
    private int nbCase;

    public void toString(Personnage personnage) {
        for (int i = 0; i < nbCase; i++) {
            if (personnage.getPosPlayer() == i) {
                System.out.print("**|");
            } else {
                System.out.print("..|");
            }
        }
        System.out.println(" ");
    }

    public Plateau(int sizePlateau) {
        this.nbCase = sizePlateau;
    }

    public int getNbCase() {
        return nbCase;
    }

    public void setNbCase(int nbCase) {
        this.nbCase = nbCase;
    }


}

