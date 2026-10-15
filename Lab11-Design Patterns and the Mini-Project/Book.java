
package lab11library;

// Book is a type of LibraryItem.
// It inherits the common fields and methods from LibraryItem.
public class Book extends LibraryItem {

    // Stores the name of the book's author.
    private final String author;

    // Constructor initialises the book's details.
    public Book(String id, String title, String author) {

        // Call the parent constructor to initialise ID and title.
        super(id, title);

        // Validate the author before storing it.
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Author cannot be empty.");
        }

        this.author = author.trim();
    }

    // Returns the author's name.
    public String getAuthor() {
        return author;
    }

    // Books can be borrowed for 14 days.
    // This overrides the abstract method in LibraryItem.
    @Override
    public int loanPeriodDays() {
        return 14;
    }

    // Provides a readable description of the book.
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
