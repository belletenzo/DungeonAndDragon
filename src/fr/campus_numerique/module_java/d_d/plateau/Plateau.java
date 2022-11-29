package fr.campus_numerique.module_java.d_d.plateau;

import fr.campus_numerique.module_java.d_d.enemy.Dragons;
import fr.campus_numerique.module_java.d_d.enemy.Gobelins;
import fr.campus_numerique.module_java.d_d.enemy.Sorciers;
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
        Plateau.plateau = plateau;
    }

    private static ArrayList<Case> plateau = new ArrayList<Case>();
    public Plateau(){
            this.nbCase = 64;
            createRandBoard();

    }

    public void movePerso(Personnage perso, int avancement) throws PersonnageHorsPlateauException {
        if(perso.getPosPlayer() + avancement >= plateau.size()){
            throw new PersonnageHorsPlateauException("Joueur en dehors");
        }
        perso.setPosPlayer(perso.getPosPlayer() + avancement);
    }

    private void createFixBoard(){
        for (int i = 0; i< nbCase+1; i++){
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
    }

    private void createRandBoard(){
        int dragons = 4;
        int gobelins = 10;
        int sorciers = 10;
        int massues = 5;
        int epees = 4;
        int eclairs = 5;
        int bouledefeu = 2;
        int potionsStandards = 6;
        int grandesPotions = 2;

        for (int i = 0; i< nbCase+1; i++){
            plateau.add(i, new CaseVide());
        }
        while(dragons > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Dragons());
                dragons--;
            }
        }
        while(gobelins > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Gobelins());
                gobelins--;
            }
        }
        while(sorciers > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Sorciers());
                sorciers--;
            }
        }
        while(massues > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Massues());
                massues--;
            }
        }
        while(epees > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Epees());
                epees--;
            }
        }
        while(eclairs > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new Eclairs());
                eclairs--;
            }
        }
        while(bouledefeu > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new BouleDeFeu());
                bouledefeu--;
            }
        }
        while(potionsStandards > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new PotionsStandards());
                potionsStandards--;
            }
        }
        while(grandesPotions > 0){
            int rand = (int)(Math.random() * nbCase) +1;
            if(plateau.get(rand) instanceof CaseVide) {
                plateau.set(rand, new GrandesPotions());
                grandesPotions--;
            }
        }
    }

    public static void toString(Personnage personnage) {
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

