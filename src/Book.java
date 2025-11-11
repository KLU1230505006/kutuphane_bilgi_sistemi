public class Book extends LibraryItem {
    private boolean isBorrowed;

    public Book(String title, String author, int year) {
        super(title, author, year);
        this.isBorrowed = false;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " ödünç alındı.");
        } else {
            System.out.println(title + " zaten ödünç alınmış.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " iade edildi.");
        } else {
            System.out.println(title + " zaten kütüphanede.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(title + " - " + author + " (" + year + ") " +
                (isBorrowed ? "[Ödünçte]" : "[Mevcut]"));
    }
}
