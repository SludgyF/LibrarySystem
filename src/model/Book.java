package model;

public class Book {
    private String name;
    private String author;
    private int isbn;
    private int quantity;

    public Book(String name, String author, int isbn, int quantity) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        quantity += amount;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public void removeQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            System.out.println("Not enough stock to borrow");
        }
    }
}
