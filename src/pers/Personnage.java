package pers;

import static menu.Menu.myObj;

public class Personnage {
    private String nom;
    private String type;
    private int pv;
    private int forceatk;
    private EquipementOffensif off;
    private EquipementDefensif def;

    public EquipementOffensif getOff() {
        return off;
    }

    public void setOff(EquipementOffensif off) {
        this.off = off;
    }

    public EquipementDefensif getDef() {
        return def;
    }

    public void setDef(EquipementDefensif def) {
        this.def = def;
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
        updateStrengthAndHealth();
        
    }

    /**
     * Update les pv et la force en fonction du type
     */
    private void updateStrengthAndHealth() {
        switch (type) {
            case "guerrier" -> {
                this.forceatk = 10;
                this.pv = 10;
                this.def = new EquipementDefensif("bouclier", 10);
                this.off = new EquipementOffensif("arme", 5);
            }
            case "magicien" -> {
                this.forceatk = 6;
                this.pv = 15;
                this.def = new EquipementDefensif("philtre", 5);
                this.off = new EquipementOffensif("sort", 7 );
            }
            default -> {
                System.out.println("error");
            }
        }
    }

    /**
     * Met à jour l'instance avec les valeurs du paramètre 'perso'
     * @param perso Personnage à partir duquel recopier les valeurs
     */
    public void updatePerso(Personnage perso) {
        System.out.println("Nom du personnage :");
        String name = myObj.nextLine();
        perso.setNom(name);
        System.out.println("Classe du personnage : Guerrier | Magicien");
        String choice = myObj.nextLine().toLowerCase();
        perso.setType(choice);
        updateStrengthAndHealth();
    }

    public String toString() {
        return "Personnage : " + nom + " " + type  + " " + pv + " pv " + forceatk + " force " + def + "" + off;
    }
}
