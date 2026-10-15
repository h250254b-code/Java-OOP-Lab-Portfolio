
package lab11library;

// Dvd is another type of LibraryItem.
// It inherits common item details from the parent class.
public class Dvd extends LibraryItem {

    // Stores the duration of the DVD in minutes.
    private final int durationMinutes;

    // Constructor initialises the DVD's details.
    public Dvd(String id, String title, int durationMinutes) {

        // Initialise the inherited ID and title fields.
        super(id, title);

        // A DVD must have a positive duration.
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                    "DVD duration must be greater than zero.");
        }

        this.durationMinutes = durationMinutes;
    }

    // Returns the DVD's duration.
    public int getDurationMinutes() {
        return durationMinutes;
    }

    // DVDs can be borrowed for 7 days.
    // This overrides the same method from LibraryItem.
    @Override
    public int loanPeriodDays() {
        return 7;
    }

    // Provides a readable description of the DVD.
    @Override
    public String toString() {
        return super.toString()
                + ", Duration: " + durationMinutes + " minutes";
    }
}
