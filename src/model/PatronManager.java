package model;

import java.util.ArrayList;
import java.util.List;

public class PatronManager {
    private List<Patron> patrons;

    public PatronManager() {
        this.patrons = new ArrayList<>();
    }

    public void registerPatron(String name, int id, String contact) {
        patrons.add(new Patron(name, id, contact));
        System.out.println("Patron registered");
        System.out.println("-------------------------");
    }

    public boolean editPatron(int patronId, String newContact) {
        for (Patron patron : patrons) {
            if (patron.getId() == patronId) {
                patron.setContact(newContact);
                System.out.println("Patron contact updated");
                return true;
            }
        }
        System.out.println("Patron not found");
        return false;
    }

    public void displayPatrons() {
        System.out.println("==== Registered Patrons ====");
        if (patrons.isEmpty()) {
            System.out.println("No patrons registered.");
            return;
        }
        for (Patron patron : patrons) {
            System.out.println("Name   : " + patron.getName());
            System.out.println("ID     : " + patron.getId());
            System.out.println("Contact: " + patron.getContact());
            System.out.println("-----------------------------");
        }
    }

    public Patron searchPatron(int patronId) {
        for (Patron patron : patrons){
            if (patron.getId() == patronId) {
                return patron;
            }
        }
        System.out.println("Patron not found.");
        return null;
    }
}

