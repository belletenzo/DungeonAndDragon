package menu;

import pers.Personnage;
import plateau.Plateau;
import java.util.Scanner;

public class Menu {
    public static Scanner myObj = new Scanner(System.in);

    /**
     * Fonction qui permet de démarrer
     */
    public String startMenu() {
        System.out.println("1.Nouveau personnage | 2.Quitter.");
        return myObj.nextLine().toLowerCase();
    }
    /**
     * Retourne le choix du joueur pour le menu de création du personnage
     */
    public String createPersoType() {

        System.out.println("Quel personnage voulez-vous créer ? Guerrier | Magicien | 3.Quitter");
        return myObj.nextLine().toLowerCase();
    }

    public String createPersoName(){
        System.out.println("Saisissez votre nom : ");
        return myObj.nextLine();
    }

    /**
     * Retourne le choix du joueur pour le menu de fin de création du perso
     */
    public String choiceFinalMenu() {
        System.out.println("1.Démarrer la partie | 2.Info Personnage | 3.Modifier | 4.Quitter.");
        return myObj.nextLine().toLowerCase();
    }
}


