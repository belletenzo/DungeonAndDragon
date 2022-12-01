package fr.campus_numerique.module_java.d_d.game;


import fr.campus_numerique.module_java.d_d.game.connexion.ConnSingleton;
import fr.campus_numerique.module_java.d_d.menu.Menu;
import fr.campus_numerique.module_java.d_d.menu.UserChoice;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique.module_java.d_d.pers.types.Magiciens;
import fr.campus_numerique.module_java.d_d.plateau.CaseVide;
import fr.campus_numerique.module_java.d_d.plateau.Plateau;

public class Game {
    Menu menu = new Menu();
    Plateau plateau = new Plateau();
    public ConnSingleton conn = ConnSingleton.getInstance();

    public Personnage perso;
    /**
     * Fonction qui permet de créer le perso en fonctions des choix des fonction  et createPersoName()
     */
    public void createPerso() {
        UserChoice userChoice = menu.startMenu();
        switch (userChoice) {
            case START -> {
                registerType();
                FinalChoiceCreatePersoMenu(Menu.choiceFinalToStartParty());
            }
            case QUIT -> {
                System.out.println("Bye");
                System.exit(-1);
            }
            case UPLOAD -> {
                conn.getHeroes();
                int id = Menu.choiceImportCharacter();
                conn.selectHero(id);
                FinalChoiceCreatePersoMenu(Menu.choiceFinalToStartParty());
            }
        }
    }

    /**
     * Permet d'instancier un personnage en fonction du choix du joueur
     *
     */
    private void registerType() {
        UserChoice userChoice = Menu.choosePersoType();
        switch (userChoice) {
            case GUERRIER -> {
                this.perso = new Guerriers(Menu.createPersoName());
                conn.createHero(perso);
            }
            case MAGICIEN -> {
                this.perso = new Magiciens(Menu.createPersoName());
                conn.createHero(perso);
            }
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
        String name = Menu.createPersoName();
        perso.setNom(name);
        UserChoice choice = Menu.choosePersoType();
        switch (choice) {
            case MAGICIEN -> this.perso = new Magiciens(name);
            case GUERRIER -> this.perso = new Guerriers(name);
            default -> System.out.println("error");
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