import java.util.Scanner;

public class LibraryManagementSystemUI {
    private LibraryManagementSystem librarySystem;
    private Scanner scanner;

    public LibraryManagementSystemUI() {
        librarySystem = new LibraryManagementSystem();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input. Please try again!");
                    break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("Library system:");
        System.out.println("1. Show all books");
        System.out.println("2. Add new book");
        System.out.println("3. Remove one book");
        System.out.println("4. Exit");
    }

    private int getUserChoice() {
        System.out.print("Въведете номер на опцията: ");
        return scanner.nextInt();
    }

    private void displayAllBooks() {
        System.out.println("Всички книги:");
        for (Book book : librarySystem.getAllBooks()) {
            System.out.println(book);
        }
    }

    private void addBook() {
        scanner.nextLine(); // Изчистване на новия ред от предишното въвеждане
        System.out.print("Въведете заглавие на книгата: ");
        String title = scanner.nextLine();
        System.out.print("Въведете автор на книгата: ");
        String author = scanner.nextLine();
        System.out.print("Въведете година на издаване на книгата: ");
        int year = scanner.nextInt();

        Book newBook = new Book(title, author, year);
        librarySystem.addBook(newBook);
        System.out.println("Книгата е добавена успешно.");
    }

    private void removeBook() {
        scanner.nextLine(); // Изчистване на новия ред от предишното въвеждане
        System.out.print("Въведете заглавие на книгата, която искате да премахнете: ");
        String title = scanner.nextLine();

        Book bookToRemove = librarySystem.findBookByTitle(title);
        if (bookToRemove != null) {
            librarySystem.removeBook(bookToRemove);
            System.out.println("Книгата е премахната успешно.");
        } else {
            System.out.println("Книга с такова заглавие не е намерена.");
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystemUI libraryUI = new LibraryManagementSystemUI();
        libraryUI.run();
    }
}