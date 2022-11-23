package fr.campus_numerique.module_java.d_d.pers;

public abstract class Personnage {
    protected String nom;
    private String type;
    protected int pv;
    protected int forceatk;
    private int posPlayer;

    public int getPosPlayer() {
        return posPlayer;
    }

    public void setPosPlayer(int posPlayer) {
        this.posPlayer = posPlayer;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getForceatk() {
        return forceatk;
    }

    public void setForceatk(int forceatk) {
        this.forceatk = forceatk;
    }


    public Personnage(String name, int pv, int atk) {
        this.nom = name;
        this.pv = pv;
        this.forceatk = atk;
    }

    public Personnage(String nom) {
        this.nom = nom;
        this.type = "";
        this.pv = 0;
        this.forceatk = 0;
    }

    public Personnage(String nom, String type) {
        this.nom = nom;
        this.type = type;
        this.posPlayer = 0;

    }


    public String toString() {
        return "";
    }
}
