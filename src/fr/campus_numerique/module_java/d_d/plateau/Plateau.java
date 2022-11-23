package fr.campus_numerique.module_java.d_d.plateau;

import fr.campus_numerique.module_java.d_d.ennemy.Dragons;
import fr.campus_numerique.module_java.d_d.ennemy.Gobelins;
import fr.campus_numerique.module_java.d_d.ennemy.Sorciers;
import fr.campus_numerique.module_java.d_d.game.PersonnageHorsPlateauException;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier.Epees;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_guerrier.Massues;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_magicien.BouleDeFeu;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_magicien.Eclairs;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_soins.GrandesPotions;
import fr.campus_numerique.module_java.d_d.pers.stuff.stuff_soins.PotionsStandards;

import java.util.ArrayList;

public class Plateau {
    public ArrayList<Case> getPlateau() {
        return plateau;
    }
    private final int nbCase;

    public void setPlateau(ArrayList<Case> plateau) {
        this.plateau = plateau;
    }

    private ArrayList<Case> plateau = new ArrayList<Case>();
    public Plateau(){
            this.nbCase = 64;
            for (int i = 0; i< nbCase; i++){
                switch (i) {
                    case 45, 52, 56, 62 -> plateau.add(new Dragons());
                    case 10, 20, 25, 35, 36, 37, 40, 44, 47 -> plateau.add(new Sorciers());
                    case 3, 6, 12, 15, 18, 21, 24, 27, 30 -> plateau.add(new Gobelins());
                    case 2, 11, 5, 22, 38 -> plateau.add(new Massues());
                    case 19, 26, 42, 53 -> plateau.add(new Epees());
                    case 1, 4, 8, 17, 23 -> plateau.add(new Eclairs());
                    case 48, 49 -> plateau.add(new BouleDeFeu());
                    case 7, 13, 31, 33, 39, 43 -> plateau.add(new PotionsStandards());
                    case 28, 41 -> plateau.add(new GrandesPotions());
                    default -> plateau.add(new CaseVide());
                }
            }

        //        plateau.add(new Eclairs());
//        plateau.add(new Massues());
//        plateau.add(new Gobelins());
//        plateau.add(new Eclairs());
//        plateau.add(new Massues());
//        plateau.add(new Gobelins());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new Eclairs());
//        plateau.add(new Gobelins());
//        plateau.add(new Sorciers());
//        plateau.add(new Massues());
//        plateau.add(new Gobelins());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Gobelins());
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Eclairs());
//        plateau.add(new Gobelins());
//        plateau.add(new Epees());
//        plateau.add(new Sorciers());
//        plateau.add(new Gobelins());
//        plateau.add(new Massues());
//        plateau.add(new Eclairs());
//        plateau.add(new Gobelins());
//        plateau.add(new Sorciers());
//        plateau.add(new Epees());
//        plateau.add(new Gobelins());
//        plateau.add(new GrandesPotions("grande potion",5));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Gobelins());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new Sorciers());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Sorciers());
//        plateau.add(new Sorciers());
//        plateau.add(new Sorciers());
//        plateau.add(new Massues());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new Sorciers());
//        plateau.add(new GrandesPotions("grande potion",5));
//        plateau.add(new Epees());
//        plateau.add(new PotionsStandards("potion standard",2));
//        plateau.add(new Sorciers());
//        plateau.add(new Dragons());
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Sorciers());
//        plateau.add(new BouleDeFeu("boule de feu",7));
//        plateau.add(new BouleDeFeu("boule de feu",7));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Dragons());
//        plateau.add(new Epees());
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Dragons());
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new CaseVide("Cette case est vide."));
//        plateau.add(new Dragons());
//        plateau.add(new CaseVide("Cette case est vide."));
    }

    public void movePerso(Personnage perso, int avancement) throws PersonnageHorsPlateauException {
        if(perso.getPosPlayer() + avancement >= plateau.size()){
            throw new PersonnageHorsPlateauException("Joueur en dehors");
        }
        perso.setPosPlayer(perso.getPosPlayer() + avancement);
    }
    public void toString(Personnage personnage) {
        for (int i = 0; i < plateau.size(); i++) {
            if (personnage.getPosPlayer() == i) {
                System.out.print("**|");
            } else {
                System.out.print(i +"|");
            }
        }
        System.out.println(" ");
    }
}

