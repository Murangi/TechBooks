import java.util.*;
import java.util.logging.Logger;

public class Order {
    private List<Book> booksOrdered;
    private static final Logger logger = Logger.getLogger(Order.class.getName());

    public Order() {
        booksOrdered = new ArrayList<>();
    }

    public void CreateOrder(Customer newCustomer, Inventory library) throws BookNotFoundException, InvalidOrderException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of books you would like to purchase: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        double totalPrice = 0.0;

        for (int i = 0; i < numBooks; i++) {
            System.out.print("What book would you like to purchase: ");
            String bookTitle = scanner.nextLine();

            Book foundBook = library.FindBook(bookTitle);
            if (foundBook == null) {
                throw new BookNotFoundException("Book not found: " + bookTitle);
            }

            Book newBook = new Book(foundBook.getTitle(), foundBook.getAuthor(), foundBook.getPrice());
            booksOrdered.add(newBook);
            totalPrice += newBook.getPrice();
        }

        // Print formatted order
        System.out.println("\nProcessing Order for " + newCustomer.getName());
        System.out.println("Order [Customer=Customer [Name=" + newCustomer.getName() +
                ", Email=" + newCustomer.getEmail() + "],");
        System.out.print(" Books=[");

        for (int i = 0; i < booksOrdered.size(); i++) {
            Book book = booksOrdered.get(i);
            System.out.print("Book [Title=" + book.getTitle() +
                    ", Author=" + book.getAuthor() +
                    ", Price=" + book.getPrice() + "]");
            if (i < booksOrdered.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("],");
        System.out.println(" Total=" + totalPrice + "]\n");
    }
}



