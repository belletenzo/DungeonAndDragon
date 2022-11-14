package menu;

import pers.Personnage;

import java.util.Scanner;
import java.util.Objects;

public class Menu {
    public static Scanner myObj = new Scanner(System.in);
    private Personnage perso;

    public void startMenu() {
        System.out.println("Nouveau personnage ou quitter.");
        String choice = myObj.nextLine().toLowerCase();

        if (Objects.equals(choice, "nouveau personnage")) {
            createPersoMenu();
        } else if (Objects.equals(choice, "quitter")) {
            System.out.println("Bye");
        } else {
            System.out.println("Choisissez un choix valide !!!");
        }
    }

    public String createPersoMenu() {

        System.out.println("Quel personnage voulez-vous créer ? Guerrier | Magicien | Quitter");
        String choice = myObj.nextLine().toLowerCase();
        System.out.println("Votre personnage est un " + choice);
        System.out.println("Saisissez votre nom : ");
        String name = myObj.nextLine();

        switch (choice) {
            case "guerrier", "magicien" -> {

                Personnage perso = makePersonnage(name, choice);
                choiceFinalMenu(perso);
            }
            case "quitter" -> {
                System.out.println("bye");
            }
            default -> {
                System.out.println("Choisissez un choix valide !!!");
                return createPersoMenu();
            }
        }
        return choice;
    }

    private Personnage makePersonnage(String name, String type) {
        Personnage perso = new Personnage(name, type);
        switch (type) {
            case "guerrier" -> {
                updateStrengthAndHealth(perso, 10, 10);
                return perso;
            }
            case "magicien" -> {
                updateStrengthAndHealth(perso, 6, 15);
                return perso;
            }
            default -> {
                updateStrengthAndHealth(perso, 0, 0);
                return perso;
            }
        }
    }

    private void updateStrengthAndHealth(Personnage perso, int strength, int health) {
        perso.setForceatk(strength);
        perso.setPv(health);
    }

    public void choiceFinalMenu(Personnage perso) {
        System.out.println("Démarrer la partie | Info Personnage | Modifier ou quitter.");
        String choice = myObj.nextLine().toLowerCase();

        switch (choice) {
            case "info personnage" -> {
                System.out.println(perso.toString());
                choiceFinalMenu(perso);
            }
            case "modifier" -> {
                updatePerso(perso);
                choiceFinalMenu(perso);
            }
            case "quitter" -> System.out.println("Bye");
            default -> System.out.println("error");
        }
    }

    private void updatePerso(Personnage perso) {
        System.out.println("Nom du personnage :");
        String name = myObj.nextLine();
        perso.setNom(name);
        System.out.println("Classe du personnage : Guerrier | Magicien");
        String choice = myObj.nextLine().toLowerCase();
        perso.setType(choice);

        if (Objects.equals(choice, "guerrier")) {
            updateStrengthAndHealth(perso, 10, 10);
            return;
        } else if (Objects.equals(choice, "magicien")) {
            updateStrengthAndHealth(perso, 6, 15);
            return;
        }
        updateStrengthAndHealth(perso, 0, 0);
    }

}
