package com.myproject.mysqljdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Test { // Renommé de MySQLJDBC à Test
    public static void main(String[] args) {
        DriverManager dbConnection = new DriverManager(); // Utilisation de DriverManager
        Connection connection = null;
        Scanner scanner = new Scanner(System.in); // Créer une seule instance de Scanner

        try {
            connection = dbConnection.connect();
            System.out.println("Connexion réussie à la base de données !");

            ExoJDBC exoJDBC = new ExoJDBC(connection); // Utilisation de ExoJDBC
            exoJDBC.createTable();
            exoJDBC.insertData();
            exoJDBC.displayMaxScripts();
            exoJDBC.displayTotalScripts();
            exoJDBC.calculateWeeklyScripts();
            exoJDBC.calculateScriptsByDeveloper(scanner); // Passer le Scanner
            exoJDBC.executeUserQuery(scanner); // Passer le Scanner

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } finally {
            // Assurez-vous que les ressources sont fermées même si des exceptions se produisent
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
                scanner.close(); // Fermer le Scanner ici
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
