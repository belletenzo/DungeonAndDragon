package fr.campus_numerique_module_java.d_d.game;

import fr.campus_numerique_module_java.d_d.pers.types.Guerriers;
import fr.campus_numerique_module_java.d_d.pers.types.Magiciens;
import fr.campus_numerique_module_java.d_d.pers.Personnage;
import fr.campus_numerique_module_java.d_d.menu.Menu;
import fr.campus_numerique_module_java.d_d.plateau.Plateau;

import java.util.Objects;

import static fr.campus_numerique_module_java.d_d.menu.Menu.myObj;

public class Game {
    Menu menu = new Menu();
     private final Plateau plateau = new Plateau(64);
     public Personnage perso;


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

    private void registerType(String type) {

        switch (type) {
            case "guerrier" ->{
                this.perso = new Guerriers(menu.createPersoName(),type);
            }
            case "magicien" -> {
                this.perso = new Magiciens(menu.createPersoName(),type);
            }
            case "3" -> {
                System.out.println("bye");
            }
            default -> {
                System.out.println("Choisissez un choix valide !!!");
                registerType(menu.choosePersoType());
            }
        }
    }

    public void FinalChoiceCreatePerso(String choice){
        switch (choice) {
            case "1" -> {
                plateau.toString(perso);
                forwardPerso();
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

        if (Objects.equals(choice,"magicien")){
            this.perso = new Magiciens(name,choice);
        } else if (Objects.equals(choice,"guerrier")){
            this.perso = new Guerriers(name, choice);
        } else {
            System.out.println("error");
        }
    }

    private int rollDice(){
        return (int)(Math.random() *6 +1);
    }
    private void forwardPerso(){
        while (perso.getPosPlayer() < plateau.getNbCase()){
           perso.setPosPlayer(perso.getPosPlayer() + rollDice());
           plateau.toString(perso);
        }
    }
    private void mainGameplay() {

    }
}

