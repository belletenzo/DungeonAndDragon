package fr.campus_numerique.module_java.d_d.menu;

import java.util.Scanner;

public class Menu {
    public static Scanner myObj = new Scanner(System.in);

    /**
     * @return String Fonction qui permet de démarrer
     */
    public UserChoice startMenu() {
        UserChoice userChoice;
        String saisie;
        do{
            System.out.println("1.Nouveau personnage | 2.Quitter.");
             saisie = myObj.nextLine().toLowerCase();
            userChoice = saisie.equals("1")?UserChoice.START:UserChoice.QUIT;
        } while (!saisie.equals("1") && !saisie.equals("2"));
        return userChoice;
    }

    /**
     * @return String le choix du joueur pour le type du personnage
     */
    public static UserChoice choosePersoType() {
        UserChoice userChoice;
        String saisie;
        do{
            System.out.println("Quel personnage voulez vous créer ? 1.Guerrier | 2.Magicien | 3.Quitter.");
            saisie = myObj.nextLine().toLowerCase();
            switch (saisie) {
                case "1" -> userChoice = UserChoice.GUERRIER;
                case "2" -> userChoice = UserChoice.MAGICIEN;
                case "3" -> userChoice = UserChoice.QUIT;
                default -> throw new IllegalStateException("Unexpected value: " + saisie);
            }
        } while (!saisie.equals("1") && !saisie.equals("2") && !saisie.equals("3"));
        return userChoice;
    }

    /**
     * @return String le choix du joueur pour le nom du personnage
     */
    public static String createPersoName(){
        System.out.println("Saisissez votre nom : ");
        return myObj.nextLine();
    }

    /**
     * @return String le choix du joueur pour le fr.campus_numerique.module_java.d_d.menu de fin de création du perso
     */
    public static String choiceFinalToStartParty() {
        System.out.println("1.Démarrer la partie | 2.Info Personnage | 3.Modifier | 4.Quitter.");
        return myObj.nextLine().toLowerCase();
    }

    /**
     *
     * @return String Le choix du joueur pendant la partie, si il souhaite lancer le dé, voir les stats ou quitter
     */
    public static String choiceForTurn(){
        System.out.println("1.Lancer un dé | 2.Info Personnage | 3.Quitter");
        return myObj.nextLine().toLowerCase();
    }
    public static UserChoice choiceAttackOrRun(){
        UserChoice userChoice;
        String saisie;
        do{
            System.out.println("1.Attaquer | 2.Fuite");
            saisie = myObj.nextLine().toLowerCase();
            userChoice = saisie.equals("1")?UserChoice.ATTACK:UserChoice.RUN;
        } while (!saisie.equals("1") && !saisie.equals("2"));
        return userChoice;
    }

}

