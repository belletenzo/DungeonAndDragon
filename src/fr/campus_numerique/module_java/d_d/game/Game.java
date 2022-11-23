package fr.campus_numerique.module_java.d_d.game;


import fr.campus_numerique.module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique.module_java.d_d.pers.types.Magiciens;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.menu.Menu;
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

        if (Objects.equals(menu.startMenu(), "1")) {
            registerType(menu.choosePersoType());
            FinalChoiceCreatePerso(menu.choiceFinalMenu());
        } else if (Objects.equals(menu.startMenu(), "2")) {
            System.out.println("Bye");
        } else {
            System.out.println("Choisissez un choix valide !!!");
            menu.startMenu();
            createPerso();
        }
    }

    /**
     * Permet d'instancier un personnage en fonction du choix du joueur
     *
     * @param type Prend en parametre le type du personnage qui sera choisit avec la fonction choosePersoType()
     */
    private void registerType(String type) {

        switch (type) {
            case "guerrier" -> this.perso = new Guerriers(menu.createPersoName(), type);
            case "magicien" -> this.perso = new Magiciens(menu.createPersoName(), type);
            case "3" -> System.out.println("bye");
            default -> {
                System.out.println("Choisissez un choix valide !!!");
                registerType(menu.choosePersoType());
            }
        }
    }

    /**
     * @param choice
     */
    public void FinalChoiceCreatePerso(String choice) {
        switch (choice) {
            case "1" -> {
                plateau.toString(perso);
                play();
            }
            case "2" -> {
                System.out.println(perso.toString());
                FinalChoiceCreatePerso(menu.choiceFinalMenu());
            }
            case "3" -> {
                updatePerso(perso);
                FinalChoiceCreatePerso(menu.choiceFinalMenu());
            }
            case "4" -> System.out.println("Bye");
            default -> menu.choiceFinalMenu();
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

    private void forwardPerso() throws PersonnageHorsPlateauException {
            switch (menu.choiceRollDice()) {
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
                default -> menu.choiceRollDice();
        }
    }


    private void play() {
        while (perso.getPosPlayer() < plateau.getPlateau().size()) {
            try {
                forwardPerso();
            } catch (PersonnageHorsPlateauException e) {
                System.out.println(e.toString());
                break;
            }
        }
        createPerso();
    }
}