package org.example;

import java.sql.SQLException;

public class ThreadsCRUD extends Thread {
    private String taskType;
    private Personne personne;
    private int id;

    public ThreadsCRUD(String taskType) {
        this.taskType = taskType;
    }

    public ThreadsCRUD(String taskType, Personne personne) {
        this.taskType = taskType;
        this.personne = personne;
    }

    public ThreadsCRUD(String taskType, int id) {
        this.taskType = taskType;
        this.id = id;
    }

    @Override
    public void run() {
        PersonneDAO personneDAO = new PersonneDAO();

        try {
            switch (taskType) {
                case "INSERT":
                    if (personne != null) {
                        personneDAO.ajouterPersonne(personne);
                        System.out.println("Personne insérée avec succès par " + Thread.currentThread().getName());
                    }
                    break;

                case "SELECT_ALL":
                    for (Personne p : personneDAO.afficherPersonnes()) {
                        System.out.println(p);
                    }
                    break;

                case "SELECT_BY_ID":
                    if (id > 0) {
                        Personne p = personneDAO.AfficherPersonneById(id);
                        if (p != null) {
                            System.out.println("Personne trouvée par " + Thread.currentThread().getName() + ": " + p);
                        } else {
                            System.out.println("Personne avec ID " + id + " non trouvée.");
                        }
                    }
                    break;

                default:
                    System.out.println("Type de tâche non supporté.");
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
