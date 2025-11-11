import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem implements IManageable {
    private List<LibraryItem> items = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();
    private List<BorrowTransaction> transactions = new ArrayList<>();

    @Override
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println(item.getTitle() + " eklendi.");
    }

    @Override
    public void removeItem(String title) {
        items.removeIf(i -> i.getTitle().equalsIgnoreCase(title));
        System.out.println(title + " kütüphaneden silindi.");
    }

    @Override
    public void listItems() {
        System.out.println("\nKütüphane Envanteri:");
        for (LibraryItem i : items) {
            String durum = "Mevcut";
            for (BorrowTransaction t : transactions) {
                if (t.getBook() == i && t.getReturnDate() == null) {
                    durum = "Ödünç alındı";
                    break;
                }
            }
            System.out.println("Kitap: " + i.getTitle() + " | Durum: " + durum);
        }
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Üye eklendi: " + member.getFullName());
    }

    public void listMembers() {
        System.out.println("\nÜye Listesi:");
        for (LibraryMember m : members) {
            m.displayPersonInfo();
        }
    }

    public void borrowBook(String title, String memberId) {
        Book book = (Book) items.stream()
                .filter(i -> i.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
        LibraryMember member = members.stream()
                .filter(m -> m.getMemberId().equalsIgnoreCase(memberId))
                .findFirst().orElse(null);

        if (book != null && member != null) {
            book.borrowBook();
            transactions.add(new BorrowTransaction(book, member, LocalDate.now()));
            System.out.println(title + " kitabı " + member.getFullName() + " tarafından ödünç alındı.");
        }
    }

    public void returnBook(String title) {
        for (BorrowTransaction t : transactions) {
            if (t.getBook().getTitle().equalsIgnoreCase(title) && t.getReturnDate() == null) {
                t.getBook().returnBook();
                t.setReturnDate(LocalDate.now());
                System.out.println(title + " iade edildi.");
                return;
            }
        }
        System.out.println("İade edilecek kitap bulunamadı.");
    }

    public void listTransactions() {
        System.out.println("\nÖdünç İşlemleri:");
        for (BorrowTransaction t : transactions) {
            System.out.print("Ödünç: " + t.getMember().getFullName() + " | Kitap: " + t.getBook().getTitle());
            System.out.print(" | Alış Tarihi: " + t.getBorrowDate());
            if (t.getReturnDate() != null) {
                System.out.println(" | İade Tarihi: " + t.getReturnDate());
            } else {
                System.out.println(" | Henüz iade edilmedi");
            }
        }
    }
}
