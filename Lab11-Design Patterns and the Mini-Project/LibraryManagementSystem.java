
package lab11library;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// Main class that runs the Library Management System.
public class LibraryManagementSystem {

    // Scanner reads input entered by the user.
    private static final Scanner input = new Scanner(System.in);

    // Storage handles saving and loading CSV files.
    private static final LibraryStorage storage = new LibraryStorage();

    // The library object manages items, members and loans.
    private static Library library;

    // Main method: execution starts here.
    public static void main(String[] args) {

        // Load previously saved data when the program starts.
        try {
            library = storage.load();
            System.out.println("Library data loaded successfully.");
        } catch (IOException ex) {
            System.out.println("Could not load library data: "
                    + ex.getMessage());
            System.out.println("Starting with an empty library.");

            library = new Library();
        }

        // Display the menu repeatedly until the user exits.
        boolean running = true;

        while (running) {
            displayMenu();

            int choice = readInt("Choose an option: ");

            try {
                switch (choice) {
                    case 1:
                        addItem();
                        break;

                    case 2:
                        registerMember();
                        break;

                    case 3:
                        borrowItem();
                        break;

                    case 4:
                        returnItem();
                        break;

                    case 5:
                        listOverdueItems();
                        break;

                    case 6:
                        searchByTitle();
                        break;

                    case 7:
                        listItems();
                        break;

                    case 8:
                        listMembers();
                        break;

                    case 0:
                        // Save all data before closing the program.
                        storage.save(library);
                        System.out.println(
                                "Data saved. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Try again.");
                }
            } catch (ItemNotAvailableException
                    | MemberLimitExceededException ex) {

                // Handle the custom borrowing exceptions.
                System.out.println("Borrowing error: "
                        + ex.getMessage());

            } catch (IllegalArgumentException ex) {

                // Handle invalid IDs, duplicate records and bad returns.
                System.out.println("Error: " + ex.getMessage());

            } catch (IOException ex) {

                // Report file-saving or file-access problems.
                System.out.println("File error: "
                        + ex.getMessage());
            }

            System.out.println();
        }

        input.close();
    }

    // Displays all available menu options.
    private static void displayMenu() {
        System.out.println("==================================");
        System.out.println("   LIBRARY MANAGEMENT SYSTEM");
        System.out.println("==================================");
        System.out.println("1. Add item (Book or DVD)");
        System.out.println("2. Register member");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List all items");
        System.out.println("8. List all members");
        System.out.println("0. Save and exit");
        System.out.println("==================================");
    }

    // Reads a whole number safely instead of crashing on text input.
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException ex) {
                System.out.println(
                        "Please enter a valid whole number.");
            }
        }
    }

    // Reads non-empty text from the user.
    private static String readRequiredText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = input.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    // Adds either a book or a DVD to the library.
    private static void addItem() {
        System.out.println("\nADD ITEM");
        System.out.println("1. Book");
        System.out.println("2. DVD");

        int type = readInt("Choose item type: ");

        if (type != 1 && type != 2) {
            System.out.println("Invalid item type.");
            return;
        }

        String id = readRequiredText("Enter item ID: ");
        String title = readRequiredText("Enter title: ");

        // Construct the correct subclass based on the chosen type.
        if (type == 1) {
            String author = readRequiredText("Enter author: ");

            library.addItem(new Book(id, title, author));
            System.out.println("Book added successfully.");

        } else {
            int duration = readInt(
                    "Enter DVD duration in minutes: ");

            library.addItem(new Dvd(id, title, duration));
            System.out.println("DVD added successfully.");
        }
    }

    // Registers a new library member.
    private static void registerMember() {
        System.out.println("\nREGISTER MEMBER");

        String id = readRequiredText("Enter member ID: ");
        String name = readRequiredText("Enter member name: ");

        library.registerMember(new Member(id, name));

        System.out.println("Member registered successfully.");
    }

    // Borrows an item for a registered member.
    private static void borrowItem()
            throws ItemNotAvailableException,
                   MemberLimitExceededException {

        System.out.println("\nBORROW ITEM");

        String memberId = readRequiredText("Enter member ID: ");
        String itemId = readRequiredText("Enter item ID: ");

        library.borrow(memberId, itemId);

        System.out.println(
                "Item borrowed successfully.");

        // Show the due date for the new loan.
        Member member = library.findMember(memberId);

        for (Loan loan : member.getLoans()) {
            if (loan.getItem().getId().equals(itemId)) {
                System.out.println(
                        "Return by: " + loan.getDueDate());
                break;
            }
        }
    }

    // Returns a borrowed item.
    private static void returnItem() {
        System.out.println("\nRETURN ITEM");

        String memberId = readRequiredText("Enter member ID: ");
        String itemId = readRequiredText("Enter item ID: ");

        library.giveBack(memberId, itemId);

        System.out.println("Item returned successfully.");
    }

    // Lists items whose active loans have passed their due dates.
    private static void listOverdueItems() {
        System.out.println("\nOVERDUE ITEMS");

        List<Loan> overdueLoans = library.getOverdueLoans();

        if (overdueLoans.isEmpty()) {
            System.out.println("There are no overdue items.");
            return;
        }

        // Display the item, borrower and number of overdue days.
        for (Loan loan : overdueLoans) {
            System.out.println(loan);
            System.out.println(
                    "Days overdue: " + loan.daysOverdue());
            System.out.println("----------------------------------");
        }
    }

    // Searches for titles using the stream-based library method.
    private static void searchByTitle() {
        System.out.println("\nSEARCH BY TITLE");

        String search = readRequiredText(
                "Enter a title or part of a title: ");

        List<LibraryItem> results =
                library.searchByTitle(search);

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
            return;
        }

        // Print all matching items.
        for (LibraryItem item : results) {
            System.out.println(item);
        }
    }

    // Lists all books and DVDs, showing their availability.
    private static void listItems() {
        System.out.println("\nALL LIBRARY ITEMS");

        List<LibraryItem> items = library.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No items registered yet.");
            return;
        }

        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    // Lists all registered members and their active loan counts.
    private static void listMembers() {
        System.out.println("\nREGISTERED MEMBERS");

        List<Member> members = library.getAllMembers();

        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
