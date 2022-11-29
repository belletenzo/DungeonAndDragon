package fr.campus_numerique.module_java.d_d.enemy;

import fr.campus_numerique.module_java.d_d.game.Game;
import fr.campus_numerique.module_java.d_d.menu.Menu;
import fr.campus_numerique.module_java.d_d.menu.UserChoice;
import fr.campus_numerique.module_java.d_d.pers.Personnage;
import fr.campus_numerique.module_java.d_d.plateau.Case;
import fr.campus_numerique.module_java.d_d.plateau.Plateau;

public abstract class Ennemi extends Personnage implements Case {
    public Ennemi(String name, int pv, int atk) {
        super(name);
        this.pv = pv;
        this.forceatk = atk;
    }

    @Override
    public boolean interact(Personnage perso) {
        System.out.println("Vous avez rencontré un " + nom);

        while (pv > 0 || perso.getPv() >= 0) {
            UserChoice userChoice = Menu.choiceAttackOrRun();
            switch (userChoice) {
                case ATTACK -> {
                    setPv(pv - perso.getForceatk());
                    perso.setPv(perso.getPv() - forceatk);
                    System.out.println("Vous avez infligé " + perso.getForceatk() + " points de dégats à l'ennemi." +
                            "\n" + "L'ennemi à désormais " + getPv() + " points de vie." + "\n" + "Vous avez pris -" + forceatk + " points de vie." +
                            "\n" + "Vos pv sont à : " + perso.getPv() + " points de vie.");
                    if (pv <= 0) {
                        System.out.println("L'ennemi est mort.");
                    }
                }
                case RUN -> {
                    int roll = Game.rollDice();
                    perso.setPosPlayer(perso.getPosPlayer() - roll);
                    System.out.println("Vous avez fui, vous reculez de : " + roll + " cases." +
                            "\n" + "Vous etes désormais sur la case " + perso.getPosPlayer() + ".");
                    Plateau.toString(perso);
                    if (perso.getPosPlayer() < 0){
                        perso.setPosPlayer(0);
                    }
                    return false;
                }
            }
            if (perso.getPv() <= 0) {
                System.out.println("Vous etes mort.");
                System.exit(-1);
            }
        }
        return true;
    }
}
