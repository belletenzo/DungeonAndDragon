package fr.campus_numerique.module_java.d_d;

import fr.campus_numerique.module_java.d_d.game.Game;
import fr.campus_numerique.module_java.d_d.game.PersonnageHorsPlateauException;



public class Main {
    public static void main(String[] args) throws PersonnageHorsPlateauException {
        Game game = new Game();
        game.createPerso();

    }
}