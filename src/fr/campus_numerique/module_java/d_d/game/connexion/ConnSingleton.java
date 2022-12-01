package fr.campus_numerique.module_java.d_d.game.connexion;

import fr.campus_numerique.module_java.d_d.pers.Personnage;

import java.sql.DriverManager;
import java.sql.*;

public final class ConnSingleton {
    private static ConnSingleton instance;
    static final String DB_URL = "jdbc:mysql://localhost/ddjava";
    static final String USER = "Enzo";
    static final String PASS = "Mugiwara2120";
    static  Statement stmt;
    static  Connection conn;

    private ConnSingleton() {
        try {
            conn= DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnSingleton getInstance() {
        if (instance == null) {
            instance = new ConnSingleton();
        }
        return instance;
    }

    public void getHeroes(){
        try {
            String QUERY = "SELECT * from hero";
            ResultSet rs = stmt.executeQuery(QUERY);
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("");
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Type: " + rs.getString("Type"));
                System.out.print(", Nom: " + rs.getString("Nom"));
                System.out.print(", NiveauVie: " + rs.getInt("NiveauVie"));
                System.out.print(", NiveauForce: " + rs.getInt("NiveauForce"));
                System.out.print(", Arme: " + rs.getString("Arme"));
                System.out.print(", Bouclier/Philtre: " + rs.getString("Bouclier"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectHero(int idCharacter){
        try {
            String QUERY = "SELECT * from hero where id =" + idCharacter;
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                // Retrieve by column name
                System.out.println("Votre personnage : ");
                System.out.print("ID: " + rs.getInt("ID"));
                System.out.print(", Type: " + rs.getString("Type"));
                System.out.print(", Nom: " + rs.getString("Nom"));
                System.out.print(", NiveauVie: " + rs.getInt("NiveauVie"));
                System.out.print(", NiveauForce: " + rs.getInt("NiveauForce"));
                System.out.print(", Arme: " + rs.getString("Arme"));
                System.out.print(", Bouclier/Philtre: " + rs.getString("Bouclier"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createHero(Personnage perso){
        String name = perso.getNom();
        String type = perso.getType();
        int pv = perso.getPv();
        int force = perso.getForceatk();
        try {
            PreparedStatement pstat = conn.prepareStatement("INSERT INTO `Hero` (Type,Nom,NiveauVie,NiveauForce,Arme,Bouclier) VALUES(?,?,?,?,'?','?')");
            pstat.setString(1,type);
            pstat.setString(2,name);
            pstat.setInt(3,pv);
            pstat.setInt(4,force);

            System.out.println(pstat.toString());
            pstat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

