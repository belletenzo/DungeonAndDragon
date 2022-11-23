package fr.campus_numerique.module_java.d_d.menu;

import java.util.Scanner;

public class Menu {
    public static Scanner myObj = new Scanner(System.in);

    /**
     * @return String Fonction qui permet de démarrer
     */
    public String startMenu() {
        System.out.println("1.Nouveau personnage | 2.Quitter.");
        return myObj.nextLine().toLowerCase();
    }

    /**
     * @return String le choix du joueur pour le type du personnage
     */
    public String choosePersoType() {

        System.out.println("Quel personnage voulez-vous créer ? Guerrier | Magicien | 3.Quitter");
        return myObj.nextLine().toLowerCase();
    }

    /**
     * @return String le choix du joueur pour le nom du personnage
     */
    public String createPersoName(){
        System.out.println("Saisissez votre nom : ");
        return myObj.nextLine();
    }

    /**
     * @return String le choix du joueur pour le fr.campus_numerique.module_java.d_d.menu de fin de création du perso
     */
    public String choiceFinalMenu() {
        System.out.println("1.Démarrer la partie | 2.Info Personnage | 3.Modifier | 4.Quitter.");
        return myObj.nextLine().toLowerCase();
    }

    /**
     *
     * @return String Le choix du joueur pendant la partie, si il souhaite lancer le dé, voir les stats ou quitter
     */
    public String choiceRollDice(){
        System.out.println("1.Lancer un dé | 2.Info Personnage | 3.Quitter");
        return myObj.nextLine().toLowerCase();
    }
}


