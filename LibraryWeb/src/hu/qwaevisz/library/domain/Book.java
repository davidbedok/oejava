package hu.qwaevisz.library.domain;

public class Book {

    private String isbn;
    private String author;
    private String title;
    private BookCategory category;
    private double price;
    private int numberOfPages;

    public Book() {
        this(null, null, null, null, 0, 0);
    }

    public Book(String isbn, String author, String title, BookCategory category, double price, int numberOfPages) {
        super();
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.category = category;
        this.price = price;
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "BookStub [isbn=" + isbn + ", author=" + author + ", title=" + title + ", category=" + category + ", price=" + price + ", numberOfPages=" + numberOfPages + "]";
    }

}
