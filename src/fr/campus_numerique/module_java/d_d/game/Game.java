package fr.campus_numerique.module_java.d_d.game;


import fr.campus_numerique.module_java.d_d.menu.Menu;
import fr.campus_numerique.module_java.d_d.menu.UserChoice;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique.module_java.d_d.pers.types.Magiciens;
import fr.campus_numerique.module_java.d_d.plateau.CaseVide;
import fr.campus_numerique.module_java.d_d.plateau.Plateau;

import java.util.Objects;

import static fr.campus_numerique.module_java.d_d.menu.Menu.myObj;

public class Game {
    Menu menu = new Menu();
    Plateau plateau = new Plateau();

    public Personnage perso;

    /**
     * Fonction qui permet de créer le perso en fonctions des choix des fonction  et createPersoName()
     */
    public void createPerso() {
        UserChoice userChoice = menu.startMenu();
        if (userChoice == UserChoice.START){
            registerType();
            FinalChoiceCreatePersoMenu(Menu.choiceFinalToStartParty());
        } else if (userChoice == UserChoice.QUIT) {
            System.out.println("Bye");
        }
    }

    /**
     * Permet d'instancier un personnage en fonction du choix du joueur
     *
     */
    private void registerType() {
        UserChoice userChoice = Menu.choosePersoType();
        switch (userChoice) {
            case GUERRIER -> this.perso = new Guerriers(Menu.createPersoName(), "Guerrier");
            case MAGICIEN -> this.perso = new Magiciens(Menu.createPersoName(), "Magicien");
            case QUIT -> System.out.println("bye");
            default -> {
                System.out.println("Choisissez un choix valide !!!");
                registerType();
            }
        }
    }

    /**
     * @param choice
     */
    public void FinalChoiceCreatePersoMenu(String choice) {
        switch (choice) {
            case "1" -> {
                Plateau.toString(perso);
                play();
            }
            case "2" -> {
                System.out.println(perso.toString());
                FinalChoiceCreatePersoMenu(Menu.choiceFinalToStartParty());
            }
            case "3" -> {
                updatePerso(perso);
                FinalChoiceCreatePersoMenu(Menu.choiceFinalToStartParty());
            }
            case "4" -> System.out.println("Bye");
            default -> Menu.choiceFinalToStartParty();
        }
    }

    public void updatePerso(Personnage perso) {
        System.out.println("Nom du personnage :");
        String name = myObj.nextLine();
        perso.setNom(name);
        System.out.println("Classe du personnage : Guerrier | Magicien");
        String choice = myObj.nextLine().toLowerCase();

        if (Objects.equals(choice, "magicien")) {
            this.perso = new Magiciens(name, choice);
        } else if (Objects.equals(choice, "guerrier")) {
            this.perso = new Guerriers(name, choice);
        } else {
            System.out.println("error");
        }
    }

    public static int rollDice() {
        return (int) (Math.floor(Math.random() * 6 + 1));
    }

    private void playATurn() throws PersonnageHorsPlateauException {
            switch (Menu.choiceForTurn()) {
                case "1" -> {
                    int rolldice = rollDice();
                    System.out.println("Votre dé est de : " + rolldice);
                    plateau.movePerso(perso,rolldice);
                    Plateau.toString(perso);
                    if (plateau.getPlateau().get(perso.getPosPlayer()).interact(perso)){
                        plateau.getPlateau().set(perso.getPosPlayer(), new CaseVide());
                    }
                }
                case "2" -> System.out.println(perso.toString());
                case "3" -> {
                    System.out.println("bye");
                    System.exit(-1);
                }
                default -> Menu.choiceForTurn();
        }
    }

    private void play() {
        while (perso.getPosPlayer() < plateau.getPlateau().size() || perso.getPv() > 0) {
            try {
                playATurn();
            } catch (PersonnageHorsPlateauException e) {
                System.out.println(e.toString());
                break;
            }
        }
        System.out.println("Vous avez gagné(e) !!!!!.");
        createPerso();
    }
}