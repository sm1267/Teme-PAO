public class BookstoreCheck {

    public static boolean isDuplicate(Book b1, Book b2) {
        return b1.getTitle().equals(b2.getTitle()) &&
                b1.getAuthor().equals(b2.getAuthor()) &&
                b1.getPublisher().equals(b2.getPublisher()) &&
                b1.getPageCount() == b2.getPageCount();
    }

    public static Book thickerBook(Book b1, Book b2) {
        if (b1.getPageCount() > b2.getPageCount()) {
            return b1;
        } else {
            return b2;
        }
    }
}
