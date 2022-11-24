package fr.campus_numerique.module_java.d_d.game;


import fr.campus_numerique.module_java.d_d.menu.Menu;
import fr.campus_numerique.module_java.d_d.menu.UserChoice;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique.module_java.d_d.pers.types.Magiciens;
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
            FinalChoiceCreatePersoMenu(menu.choiceFinalToStartParty());
        } else if (userChoice == UserChoice.QUIT) {
            System.out.println("Bye");
        }
    }

    /**
     * Permet d'instancier un personnage en fonction du choix du joueur
     *
     */
    private void registerType() {
        UserChoice userChoice = menu.choosePersoType();
        switch (userChoice) {
            case GUERRIER -> this.perso = new Guerriers(menu.createPersoName(), "Guerrier");
            case MAGICIEN -> this.perso = new Magiciens(menu.createPersoName(), "Magicien");
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
                plateau.toString(perso);
                play();
            }
            case "2" -> {
                System.out.println(perso.toString());
                FinalChoiceCreatePersoMenu(menu.choiceFinalToStartParty());
            }
            case "3" -> {
                updatePerso(perso);
                FinalChoiceCreatePersoMenu(menu.choiceFinalToStartParty());
            }
            case "4" -> System.out.println("Bye");
            default -> menu.choiceFinalToStartParty();
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

    private int rollDice() {
        return (int) (Math.floor(Math.random() * 6 + 1));
    }

    private void PlayATurn() throws PersonnageHorsPlateauException {
            switch (menu.choiceForTurn()) {
                case "1" -> {
                    int rolldice = rollDice();
                    System.out.println("Votre dé est de : " + rolldice);
                    plateau.movePerso(perso,rolldice);
                    plateau.toString(perso);
                    plateau.getPlateau().get(perso.getPosPlayer()).interact(perso);
                }
                case "2" -> System.out.println(perso.toString());
                case "3" -> {
                    System.out.println("bye");
                    System.exit(-1);
                }
                default -> menu.choiceForTurn();
        }
    }

    private void play() {
        while (perso.getPosPlayer() < plateau.getPlateau().size()) {
            try {
                PlayATurn();
            } catch (PersonnageHorsPlateauException e) {
                System.out.println(e.toString());
                break;
            }
        }
        createPerso();
    }
}