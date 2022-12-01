package fr.campus_numerique.module_java.d_d.pers.stuff;

public abstract class EquipementDefensif {
    protected int def;
    protected String name;

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


    public EquipementDefensif(String name, int def) {
        this.name = name;
        this.def = def;
    }

    public String toString() {
        return "| Equipement défensif : " + name + " def : " + def;
    }

}
