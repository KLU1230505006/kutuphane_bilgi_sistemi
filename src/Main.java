import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();

        system.addItem(new Book("Yapay Zeka", "Stuart Russell", 2016));
        system.addItem(new Book("Derin Öğrenme", "Ian Goodfellow", 2017));
        system.addItem(new Book("Makine Öğrenmesi", "Tom Mitchell", 1997));

        system.addMember(new LibraryMember("Ayşe", "Yılmaz", "M001"));
        system.addMember(new LibraryMember("Ali", "Can", "M002"));

        System.out.println();
        system.listItems();


        System.out.println();
        system.listMembers();


        system.borrowBook("Yapay Zeka", "M001");
        system.borrowBook("Derin Öğrenme", "M002");


        System.out.println();
        system.listTransactions();


        system.returnBook("Yapay Zeka");

        System.out.println();
        system.listTransactions();


        System.out.println();
        system.listItems();
    }
}
