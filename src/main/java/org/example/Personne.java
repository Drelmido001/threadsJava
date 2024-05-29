package org.example;

public class Personne {
    private int id_perso;
    private String nom_perso;
    private String email;
    private int Age;
    public Personne( String nom_perso, String email, int Age) {
        this.nom_perso = nom_perso;
        this.email = email;
        this.Age = Age;
    } public Personne(int id_perso,String nom_perso, String email, int Age) {
        this.id_perso = id_perso;
        this.nom_perso = nom_perso;
        this.email = email;
        this.Age = Age;
    }
    public Personne() {}
    public int getId_perso() {
        return id_perso;
    }
    public void setId_perso(int id_perso) {
        this.id_perso = id_perso;
    }
    public String getNom_perso() {
        return nom_perso;
    }
    public void setNom_perso(String nom_perso) {
        this.nom_perso = nom_perso;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id_perso=" + id_perso +
                ", nom_perso='" + nom_perso + '\'' +
                ", email='" + email + '\'' +
                ", Age=" + Age +
                '}';
    }

    public void setAge(int Age) {
        this.Age = Age;
    }


}
