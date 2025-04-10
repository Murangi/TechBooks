import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventory {

    private List<Book> Books;
    private static final Logger logger = Logger.getLogger(Inventory.class.getName());

    public Inventory(){

        Books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void AddBook(Book NewBook) {

        Books.add(NewBook);

    }

    public Book FindBook(String BookTitle) throws BookNotFoundException {

        BookTitle = BookTitle.toUpperCase();
        boolean Found = false;
        for (Book book : Books) {

            if(book.getTitle().toUpperCase().equals(BookTitle))
            {
                return book;
            }
        }

        if(!Found) {
            logger.log(Level.WARNING,"Book not found : ", BookTitle);
            throw new BookNotFoundException("The book you are looking for was not found");
        }

        return null;
    }


}
