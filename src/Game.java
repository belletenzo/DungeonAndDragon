import pers.Personnage;
import menu.Menu;
import plateau.Plateau;

import java.util.Objects;

public class Game {
    Menu menu = new Menu();
     private Personnage perso = new Personnage();
     private final Plateau plateau = new Plateau(64);


    public void createPerso() {

        if (Objects.equals(menu.startMenu(), "1")) {
            registerType(menu.createPersoType());
            FinalChoiceCreatePerso(menu.choiceFinalMenu());
        } else if (Objects.equals(menu.startMenu(), "2")) {
            System.out.println("Bye");
        } else {
            System.out.println("Choisissez un choix valide !!!");
        }
    }

    private void registerType(String type) {

        switch (type) {
            case "guerrier", "magicien" -> {
                perso.setType(type);
                perso.setNom(menu.createPersoName());
            }
            case "3" -> {
                System.out.println("bye");
            }
            default -> {
                System.out.println("Choisissez un choix valide !!!");
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
                perso.updatePerso(perso);
                FinalChoiceCreatePerso(menu.choiceFinalMenu());
            }
            case "4" -> System.out.println("Bye");
            default -> menu.choiceFinalMenu();
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

