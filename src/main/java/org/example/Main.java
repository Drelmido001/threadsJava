package org.example;

public class Main {
    public static void main(String[] args) {
        ThreadsCRUD insertTask = new ThreadsCRUD("INSERT", new Personne("Jean Dupont", "jean.dupont@example.com", 22));
        ThreadsCRUD selectAllTask = new ThreadsCRUD("SELECT_ALL");
        ThreadsCRUD selectByIdTask = new ThreadsCRUD("SELECT_BY_ID", 1);

        Thread insertThread = new Thread(insertTask, "ajouterPersonne");
        Thread selectAllThread = new Thread(selectAllTask, "afficherPersonnes");
        Thread selectByIdThread = new Thread(selectByIdTask, "afficherPersonneById");
        insertThread.start();
        try {
            insertThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectAllThread.start();
        try {
            selectAllThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        selectByIdThread.start();
        try {
            selectByIdThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
