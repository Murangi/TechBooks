//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        System.out.println("Welcome to the Bookstore System!");
        System.out.println();

        // Create books
        Book FirstBook = new Book("Fire", "John Boyne", 320.0);
        Book SecondBook = new Book("Sky Guide 2025", "Astronomical Society of Southern Africa", 180.0);
        Book ThirdBook = new Book("The Spy Coast", "Tess Gerritsen", 290.0);
        Book FourthBook = new Book("Odyssey", "Stephen Fry", 350.0);
        Book FifthBook = new Book("The House of Cross", "James Patterson", 310.0);
        Book SixthBook = new Book("In Too Deep", "Lee Child", 330.0);
        Book SeventhBook = new Book("We Who Wrestle With God: Perceptions of the Divine", "Jordan B. Peterson", 400.0);
        Book EighthBook = new Book("Witness to Power: A Political Memoir", "Mathews Phosa", 370.0);
        Book NinthBook = new Book("Lottie Brooks's Essential Guide to Life", "Katie Kirby", 250.0);
        Book TenthBook = new Book("Klein Jan", "Jan Hendrik van der Westhuizen", 450.0);

        // Add books to inventory
        Inventory InventoryManager = new Inventory();
        InventoryManager.AddBook(FirstBook);
        InventoryManager.AddBook(SecondBook);
        InventoryManager.AddBook(ThirdBook);
        InventoryManager.AddBook(FourthBook);
        InventoryManager.AddBook(FifthBook);
        InventoryManager.AddBook(SixthBook);
        InventoryManager.AddBook(SeventhBook);
        InventoryManager.AddBook(EighthBook);
        InventoryManager.AddBook(NinthBook);
        InventoryManager.AddBook(TenthBook);

        // Display available books
        System.out.println("Available books: ");
        for (Book book : InventoryManager.getBooks()) {
            System.out.println("Book [Title=" + book.getTitle() + ", Author=" + book.getAuthor() + ", Price=" + book.getPrice() + "]");
        }
        System.out.println();

        // Test FindBook function
        try {
            Book foundBook = InventoryManager.FindBook("Unknown Book");
            if (foundBook != null) {
                System.out.println("Title: " + foundBook.getTitle());
                System.out.println("Author: " + foundBook.getAuthor());
                System.out.println("Price: R" + foundBook.getPrice());
            }
        } catch (BookNotFoundException e) {
            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        }
        System.out.println();

        // Create customer
        Customer NewCustomer = new Customer("Charlie", "charlie@example.com");
        System.out.println("Processing Order for " + NewCustomer.getName());

        // Create an order
        Order FirstOrder = new Order();
        try {
            FirstOrder.CreateOrder(NewCustomer, InventoryManager);
        } catch (BookNotFoundException e) {

            logger.log(Level.SEVERE, "Error: " + e.getMessage());
        } catch (InvalidOrderException e) {

            logger.log(Level.SEVERE, "Error processing order: "+ e.getMessage());

        }
    }
}

