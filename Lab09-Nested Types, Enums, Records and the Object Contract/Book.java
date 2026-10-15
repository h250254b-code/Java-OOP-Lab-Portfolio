
package lab09enumsrecords;

import java.util.Objects;

public class Book {

    private String title;
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    // Books are equal when their ISBNs are equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;
        return Objects.equals(this.isbn, other.isbn);
    }

    // Equal books must have the same hash code
    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}
