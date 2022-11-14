package pers;

public class Personnage {
    private String nom;
    private String type;
    private int pv;
    private int forceatk;

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


    public Personnage() {

        this.nom = "";
        this.type = "";
        this.pv = 0;
        this.forceatk = 0;
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
        this.pv = 0;
        this.forceatk = 0;
    }


    public String toString() {
        return "Personnage : " + nom + " " + type  + " " + pv + " pv " + forceatk + " force";
    }
}
