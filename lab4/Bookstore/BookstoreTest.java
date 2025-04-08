import java.util.ArrayList;
import java.util.Scanner;

public class BookstoreTest {

    private static ArrayList<Book> books = new ArrayList<>();

    public static void createBook(Scanner scanner) {
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        String publisher = scanner.nextLine();
        int pageCount = Integer.parseInt(scanner.nextLine());

        while (pageCount == 0) {
            pageCount = Integer.parseInt(scanner.nextLine());
        }

        Book book = new Book(title, author, publisher, pageCount);
        books.add(book);
    }

    public static Book readBook(int index) {
        return books.get(index);
    }

    public static void updateBook(int index, Scanner scanner) {
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        String publisher = scanner.nextLine();
        int pageCount = Integer.parseInt(scanner.nextLine());

        Book book = books.get(index);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setPageCount(pageCount);
    }

    public static void deleteBook(int index) {
        books.remove(index);
    }
}
