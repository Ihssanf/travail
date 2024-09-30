package com.myproject.mysqljdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class DriverManager { // Nom de la classe conservé en "DriverManager"
    // Remplacez ces constantes par vos informations de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/basef"; // Assurez-vous que "basef" est correct
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Établit une connexion à la base de données MySQL.
     *
     * @return Une instance de Connection.
     * @throws SQLException Si une erreur de connexion se produit.
     */
    public Connection connect() throws SQLException {
        // Chargement explicite du driver (optionnel depuis JDBC 4.0)
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Mise à jour pour les versions récentes de MySQL JDBC
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL non trouvé. Assurez-vous que le driver est dans le classpath.");
            throw new SQLException(e);
        }

        // Établir la connexion en utilisant java.sql.DriverManager pour éviter la confusion avec cette classe
        return java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
