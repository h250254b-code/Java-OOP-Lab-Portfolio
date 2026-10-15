package lab11library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

// Saves and loads library information using CSV files.
public class LibraryStorage {

    private final Path itemsFile = Paths.get("items.csv");
    private final Path membersFile = Paths.get("members.csv");
    private final Path loansFile = Paths.get("loans.csv");

    // Saves items, members and loan history.
    public void save(Library library) throws IOException {
        saveItems(library);
        saveMembers(library);
        saveLoans(library);
    }

    // Loads saved data and restores active loans.
    public Library load() throws IOException {
        Library library = new Library();

        loadItems(library);
        loadMembers(library);

        // Availability will be reconstructed from active loans.
        for (LibraryItem item : library.getAllItems()) {
            item.setAvailable(true);
        }

        loadLoans(library);
        return library;
    }

    // Saves books and DVDs.
    private void saveItems(Library library) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                itemsFile, StandardCharsets.UTF_8)) {

            for (LibraryItem item : library.getAllItems()) {
                String type;
                String extra;

                if (item instanceof Book) {
                    Book book = (Book) item;
                    type = "BOOK";
                    extra = encode(book.getAuthor());

                } else if (item instanceof Dvd) {
                    Dvd dvd = (Dvd) item;
                    type = "DVD";
                    extra = String.valueOf(dvd.getDurationMinutes());

                } else {
                    throw new IOException(
                            "Unsupported item type: "
                            + item.getClass().getSimpleName());
                }

                writer.write(type + ","
                        + encode(item.getId()) + ","
                        + encode(item.getTitle()) + ","
                        + extra + ","
                        + item.isAvailable());

                writer.newLine();
            }
        }
    }

    // Saves registered members.
    private void saveMembers(Library library) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                membersFile, StandardCharsets.UTF_8)) {

            for (Member member : library.getAllMembers()) {
                writer.write(encode(member.getId()) + ","
                        + encode(member.getName()));
                writer.newLine();
            }
        }
    }

    // Saves all loans, including returned loans.
    private void saveLoans(Library library) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                loansFile, StandardCharsets.UTF_8)) {

            for (Loan loan : library.getAllLoans()) {
                String returnDate = loan.getReturnDate() == null
                        ? ""
                        : loan.getReturnDate().toString();

                writer.write(
                        encode(loan.getMember().getId()) + ","
                        + encode(loan.getItem().getId()) + ","
                        + loan.getBorrowDate() + ","
                        + loan.getDueDate() + ","
                        + returnDate);

                writer.newLine();
            }
        }
    }

    // Loads saved items.
    private void loadItems(Library library) throws IOException {
        if (!Files.exists(itemsFile)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(
                itemsFile, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    throw new IOException("Invalid item record: " + line);
                }

                try {
                    String type = data[0];
                    String id = decode(data[1]);
                    String title = decode(data[2]);

                    LibraryItem item;

                    if ("BOOK".equals(type)) {
                        item = new Book(id, title, decode(data[3]));

                    } else if ("DVD".equals(type)) {
                        item = new Dvd(
                                id, title, Integer.parseInt(data[3]));

                    } else {
                        throw new IOException(
                                "Unknown item type: " + type);
                    }

                    library.addItem(item);

                } catch (IllegalArgumentException ex) {
                    throw new IOException(
                            "Could not load item: " + line, ex);
                }
            }
        }
    }

    // Loads registered members.
    private void loadMembers(Library library) throws IOException {
        if (!Files.exists(membersFile)) {
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(
                membersFile, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 2) {
                    throw new IOException(
                            "Invalid member record: " + line);
                }

                try {
                    Member member = new Member(
                            decode(data[0]), decode(data[1]));

                    library.registerMember(member);

                } catch (IllegalArgumentException ex) {
                    throw new IOException(
                            "Could not load member: " + line, ex);
                }
            }
        }
    }

    // Loads loans and prevents duplicate active loans for an item.
    private void loadLoans(Library library) throws IOException {
        if (!Files.exists(loansFile)) {
            return;
        }

        Set<String> activeItemIds = new HashSet<>();

        try (BufferedReader reader = Files.newBufferedReader(
                loansFile, StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",", -1);

                if (data.length != 5) {
                    throw new IOException(
                            "Invalid loan record: " + line);
                }

                try {
                    String memberId = decode(data[0]);
                    String itemId = decode(data[1]);

                    Member member = library.findMember(memberId);
                    LibraryItem item = library.findItem(itemId);

                    if (member == null || item == null) {
                        throw new IOException(
                                "Loan refers to a missing member or item: "
                                + line);
                    }

                    LocalDate borrowDate = LocalDate.parse(data[2]);
                    LocalDate dueDate = LocalDate.parse(data[3]);

                    LocalDate returnDate = data[4].isEmpty()
                            ? null
                            : LocalDate.parse(data[4]);

                    if (returnDate == null
                            && !activeItemIds.add(itemId)) {
                        throw new IOException(
                                "Item has multiple active loans: " + itemId);
                    }

                    Loan loan = new Loan(
                            item, member, borrowDate, dueDate, returnDate);

                    library.restoreLoan(loan);

                } catch (IllegalArgumentException ex) {
                    throw new IOException(
                            "Could not load loan: " + line, ex);
                }
            }
        }
    }

    // Encodes special characters before writing CSV values.
    private String encode(String value) {
        return value.replace("%", "%25")
                .replace(",", "%2C")
                .replace("\n", "%0A")
                .replace("\r", "%0D");
    }

    // Decodes special characters after reading CSV values.
    private String decode(String value) {
        return value.replace("%0D", "\r")
                .replace("%0A", "\n")
                .replace("%2C", ",")
                .replace("%25", "%");
    }
}