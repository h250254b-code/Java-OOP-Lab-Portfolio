
package lab03encapsulation;

// final prevents other classes from extending this class
public final class ImmutablePerson {

    // private prevents direct access; final prevents reassignment
    private final String name;
    private final int age;

    // Constructor sets the values when the object is created
    public ImmutablePerson(String name, int age) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty.");
        }

        if (age < 0) {
            throw new IllegalArgumentException(
                    "Age cannot be negative.");
        }

        this.name = name;
        this.age = age;
    }

    // Getters allow read-only access to the fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
