import java.time.LocalDate;

public class BorrowTransaction {
    private Book book;
    private LibraryMember member;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowTransaction(Book book, LibraryMember member, LocalDate borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public LibraryMember getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void displayTransactionInfo() {
        System.out.println("Kitap: " + book.getTitle() +
                " | Üye: " + member.getFullName() +
                " | Ödünç Tarihi: " + borrowDate +
                " | İade Tarihi: " + (returnDate != null ? returnDate : "Henüz iade edilmedi"));
    }
}
