import java.util.Scanner;
import model.Book;
import model.Patron;
import model.LibraryInventory;
import model.PatronManager;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryInventory library = new LibraryInventory();
        PatronManager patronManager = new PatronManager();
        boolean running = true;

        while (running) {
            System.out.println("==== Library Management System ====");  
            System.out.println("1. Add book");  
            System.out.println("2. Remove book");
            System.out.println("3. Edit book");    
            System.out.println("4. Display book");
            System.out.println("5. Register Patron");
            System.out.println("6. Edit Patron");
            System.out.println("7. View Patrons");
            System.out.println("8. Borrow book");
            System.out.println("9. Display borrow books");
            System.out.println("10. Return book");
            System.out.println("11. Search book");
            System.out.println("12. Search patron");
            System.out.println("13. Exit");    
            System.out.print("Choose an option: ");  
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter authors name: ");
                    String bookAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN number: ");
                    int isbn = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    library.addBook(new Book(bookName, bookAuthor, isbn, quantity));
                    System.out.println("Book added");
                    break;

                case 2:
                    System.out.print("Enter book name to remove: ");
                    String removeBookName = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int removeQuantity = scanner.nextInt();
                    scanner.nextLine();

                    library.removeBook(removeBookName, removeQuantity);
                    break;

                case 3:
                    System.out.print("Enter ISB number: ");
                    int editIsbn = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();

                    library.editBook(editIsbn, newQuantity);
                    break;

                case 4:
                    library.displayItems();
                    break;

                case 5:
                    System.out.print("Enter patron name: ");
                    String patronName = scanner.nextLine();
                    System.out.print("Enter patron ID: ");
                    int patronId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patron contact: ");
                    String patronContact = scanner.nextLine();
                    patronManager.registerPatron(patronName, patronId, patronContact);
                    break;
                
                case 6:
                    System.out.print("Enter patron ID: ");
                    int editPatronId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();

                    patronManager.editPatron(editPatronId, newContact);
                    break;

                case 7:
                    patronManager.displayPatrons();
                    break;

                case 8:
                    System.out.print("Enter patron id: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter book name: ");
                    String borrowTitle = scanner.nextLine();
                    
                    library.borrowBook(borrowId, borrowTitle);
                    break;

                case 9:
                    System.out.print("Enter patron id: ");
                    int borrowPatronId = scanner.nextInt();
                    scanner.nextLine(); 

                    library.displayBorrowed(borrowPatronId);
                    break;

                case 10:
                    System.out.print("Enter patron id: ");
                    int returnPatronId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter book name");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnPatronId, returnTitle);
                    break;
                
                case 11:
                    System.out.print("Enter book name, author or ISBN number: ");
                    String searchKeyword = scanner.nextLine();
                    Book foundBook = library.searchBook(searchKeyword);
                    if (foundBook != null) {
                        System.out.println("==== Book found ====");
                        System.out.println("Title: " + foundBook.getName());
                        System.out.println("Author: " + foundBook.getAuthor());
                        System.out.println("ISBN: " + foundBook.getIsbn());
                        System.out.println("Quantity: " + foundBook.getQuantity());
                        System.out.println("-------------------------");
                    }
                    break;

                case 12:
                    System.out.println("Enter patron id: ");
                    int searchPatron = scanner.nextInt();
                    scanner.nextLine();
                    
                    Patron foundPatron = patronManager.searchPatron(searchPatron);

                    if (foundPatron != null) {
                        System.out.println("==== Patron Information ====");
                        System.out.println("Name   : " + foundPatron.getName());
                        System.out.println("ID     : " + foundPatron.getId());
                        System.out.println("Contact: " + foundPatron.getContact());
                        System.out.println("-----------------------------");
                
                        library.displayBorrowed(searchPatron);
                    } else {
                        System.out.println("Patron not found.");
                    }

                    break;

                case 13:
                    System.out.println("Exiting the program...");
                    running = false; 
                    break;

                    default:  
                    System.out.println("Invalid option. Please try again."); 
            }
        }
        scanner.close();
    }
}