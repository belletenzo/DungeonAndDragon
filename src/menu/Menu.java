package menu;

import pers.Personnage;

import java.util.Scanner;
import java.util.Objects;

public class Menu {
    public static Scanner myObj = new Scanner(System.in);

    /**
     * Fonction qui permet de démarrer
     */
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

    /**
     * Menu de création du personnage
     */
    public void createPersoMenu() {

        System.out.println("Quel personnage voulez-vous créer ? Guerrier | Magicien | Quitter");
        String choice = myObj.nextLine().toLowerCase();
        System.out.println("Saisissez votre nom : ");
        String name = myObj.nextLine();

        switch (choice) {
            case "guerrier", "magicien" -> {

                Personnage perso = new Personnage(name, choice);
                choiceFinalMenu(perso);
            }
            case "quitter" -> {
                System.out.println("bye");
            }
            default -> {
                System.out.println("Choisissez un choix valide !!!");
                createPersoMenu();
            }
        }
    }


    /**
     * Menu qui permet de voir les infos du perso, de les modifier ou bien de commencer la partie
     * @param perso En prenant en parametre le personnage pour pouvoir voir, modifier ou jouer.
     */
    public void choiceFinalMenu(Personnage perso) {
        System.out.println("Démarrer la partie | Info Personnage | Modifier ou quitter.");
        String choice = myObj.nextLine().toLowerCase();

        switch (choice) {
            case "info personnage" -> {
                System.out.println(perso.toString());
                choiceFinalMenu(perso);
            }
            case "modifier" -> {
                perso.updatePerso(perso);
                choiceFinalMenu(perso);
            }
            case "quitter" -> System.out.println("Bye");
            default -> choiceFinalMenu(perso);
        }
    }
}


