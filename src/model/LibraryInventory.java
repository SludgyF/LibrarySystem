package model;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class LibraryInventory {
    private List<Book> books;
    private HashMap<Integer, List<String> > borrowwedBooks = new HashMap<>();

    public LibraryInventory() {
        books = new ArrayList<>();

        books.add(new Book("Don Quijote de la Mancha","Miguel de Cervantes", 1111, 5));
        books.add(new Book("La Celestina","Fernando de Rojas", 2222, 8));
        books.add(new Book("La invencion de Morel","Adolfo Bioy Casares", 3333, 3));
    }
    
    public void addBook(Book book) {
        books.add(book);
    }

    public void displayItems() {
        System.out.println("==== Library Books ====");
        for (Book book : books) {
            System.out.println("Title   : " + book.getName());
            System.out.println("Author  : " + book.getAuthor());
            System.out.println("ISBN    : " + book.getIsbn());
            System.out.println("Quantity: " + book.getQuantity());
            System.out.println("-------------------------");
        }
    }

    public void removeBook(String bookName, int quantity) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                book.removeQuantity(quantity);
                return;
            }
        }
        System.out.println("Book not found in inventory");
    }

    public boolean editBook(int isbn, int newQuantity) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                book.addQuantity(newQuantity - book.getQuantity());
                System.out.println("Book updated");
                return true;
            }
        }
        System.out.println("Book not found");
        return false;
    }

    public boolean borrowBook(int patronId, String tittle) {
        for (Book book : books) {
            if(book.getName().equalsIgnoreCase(tittle)) {
                if(book.getQuantity() > 0) {
                    book.removeQuantity(1);

                    // Se registra el prestamo con el hashmap
                    borrowwedBooks.putIfAbsent(patronId, new ArrayList<>());
                    borrowwedBooks.get(patronId).add(tittle);
                    System.out.println("Book borrowed");
                    return true;
                } else {
                    System.out.println("No copies available");
                    return false;
                }
            }
        }
        System.out.println("Book not found");
        return false;
    }

    public void displayBorrowed(int patronId) {
        if (!borrowwedBooks.containsKey(patronId)) {
            System.out.println("This patron has no borrowed books");
            return;
        }
        System.out.println(" ==== Borrowed books ====");
        for (String bookTitle : borrowwedBooks.get(patronId)) {
            System.out.println("- " + bookTitle);
        }
    }

    public boolean returnBook(int patronId, String tittle) {
        if (borrowwedBooks.containsKey(patronId) && borrowwedBooks.get(patronId).contains(tittle)) {
            borrowwedBooks.get(patronId).remove(tittle);
            if (borrowwedBooks.get(patronId).isEmpty()){
                borrowwedBooks.remove(patronId);
            }

            for (Book book : books) {
                if (book.getName().equalsIgnoreCase(tittle)){
                    book.addQuantity(1);
                    System.out.println("Book returned");
                    return true;
                }
            }
        }
        System.out.println("This book was not borrowed");
        return false;
    }

    public Book searchBook(String keyword) {
        for (Book book : books){
            if (book.getName().equalsIgnoreCase(keyword) ||
                book.getAuthor().equalsIgnoreCase(keyword) ||
                String.valueOf(book.getIsbn()).equals(keyword)) {
                    return book;
                }
        }
        System.out.println("Book not found.");
        return null;
    }
}
