package menu;

import pers.Personnage;

import java.util.Scanner;
import java.util.Objects;


public class Menu {
    public static Scanner myObj =  new Scanner(System.in);
    public Scanner nom = new Scanner(System.in);
    public void start() {
        String choice;

        System.out.println("Nouveau personnage ou quitter.");
        choice = myObj.nextLine().toLowerCase();

        if (Objects.equals(choice, "nouveau personnage")) {
            createPerso();
        } else if (Objects.equals(choice, "quitter")) {
            System.out.println("Bye");
        } else {
            System.out.println("error");;
        }
    }

    public void createPerso() {
        String choice;

        System.out.println("Quel personnage voulez-vous créer ? Guerrier | Magicien | Quitter");
        choice = myObj.nextLine().toLowerCase();
        switch (choice) {
            case "guerrier", "magicien" -> {
                System.out.println("Saisissez votre nom : ");
                Personnage Perso = new Personnage(nom.nextLine(), choice);
                System.out.println(Perso.toString());
                break;
            }
            case "quitter" -> {
                System.out.println("bye");
                break;
            }
            default -> System.out.println("error");
        }
    }

        public String toString () {

            return "";
        }
    }