public class Book {
    private String title;
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        if (pageCount == 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPageCount(int pageCount) {
        if (pageCount == 0) {
            throw new IllegalArgumentException();
        }
        this.pageCount = pageCount;
    }

    public void displayInfo() {
        System.out.println("BOOK_TITLE: " + title.toUpperCase());
        System.out.println("BOOK_AUTHOR: " + author);
        System.out.println("BOOK_PUBLISHER: " + publisher.toLowerCase());
    }
}
