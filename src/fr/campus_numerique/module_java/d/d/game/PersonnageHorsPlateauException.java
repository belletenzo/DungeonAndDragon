package fr.campus_numerique.module_java.d.d.game;

public class PersonnageHorsPlateauException extends Exception {
    public String message;
    public PersonnageHorsPlateauException(String message) {
        this.message = message;
    }
    public String toString(){
        return message;
    }
}
