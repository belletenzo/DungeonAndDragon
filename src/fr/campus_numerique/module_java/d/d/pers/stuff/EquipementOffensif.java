package fr.campus_numerique.module_java.d.d.pers.stuff;

public abstract class EquipementOffensif {

    protected int atk;
    protected String name;


    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipementOffensif(String name, int atk){
        this.name = name;
        this.atk = atk;

    }


    public String toString(){

        return "| Equipement offensif : " + name + " atk : " + atk;
    }


}
