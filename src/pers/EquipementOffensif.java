package pers;

public class EquipementOffensif {
    private String Arme;
    private String Sort;
    private int atk;
    private String name;

    public String getArme() {
        return Arme;
    }

    public void setArme(String arme) {
        Arme = arme;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

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

        return "| Equipement offensif : " + name + " atk " + atk;
    }
}
