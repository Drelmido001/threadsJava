package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonneDAO {
    Connection con=null;
    public void ajouterPersonne(Personne personne) throws SQLException {
        try {
            String query="INSERT INTO personnes(id_perso, nom_perso, email,age) VALUES(?,?,?,?)";
            con=DataBaseConnection.getConnection();
            PreparedStatement preparedStatement=con.prepareStatement(query );
            preparedStatement.setInt(1, personne.getId_perso());
            preparedStatement.setString(2, personne.getNom_perso());
            preparedStatement.setString(3, personne.getEmail());
            preparedStatement.setInt(4, personne.getAge());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Erreur de SQL");
            e.printStackTrace();
        }
    }
    public List<Personne> afficherPersonnes() throws SQLException {
        List<Personne> personnes = new ArrayList<>();
        String query = "SELECT * FROM personnes";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int id_perso = rs.getInt("id_perso");
                String nom_perso = rs.getString("nom_perso");
                String email = rs.getString("email");
                int age = rs.getInt("age");
                Personne personne = new Personne(id_perso,nom_perso, email,age);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            System.out.println("Sélection échouée : " + e.getMessage());
            throw e;
        }
        return personnes;
    }
    public Personne AfficherPersonneById(int id) throws SQLException {
        Personne personne = null;
         String query = "SELECT * FROM personnes WHERE id_perso = ?";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int id_perso = rs.getInt("id_perso");
                    String nom_perso = rs.getString("nom_perso");
                    String email = rs.getString("email");
                    int age = rs.getInt("age");
                    personne = new Personne(id_perso,nom_perso, email,age);
                }
            }
        } catch (SQLException e) {
            System.out.println("Sélection échouée : " + e.getMessage());
            throw e;
        }
        return personne;
    }
}
