package pers;

public class EquipementDefensif {
    private String Bouclier;
    private String Philtre;
    private int def;
    private String name;
    public String getBouclier() {
        return Bouclier;
    }

    public void setBouclier(String bouclier) {
        Bouclier = bouclier;
    }

    public String getPhiltre() {
        return Philtre;
    }

    public void setPhiltre(String philtre) {
        Philtre = philtre;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public EquipementDefensif(String name,int def){
        this.name = name;
        this.def = def;
    }
}
