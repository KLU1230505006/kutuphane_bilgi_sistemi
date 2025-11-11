public abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int year;

    public LibraryItem(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo();
}
