
package lab08collections;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Test using Integer objects
        Integer[] numbers = {45, 12, 78, 3, 29};

        System.out.println("Integers before sorting: "
                + Arrays.toString(numbers));

        BubbleSort.bubbleSort(numbers);

        System.out.println("Integers after sorting: "
                + Arrays.toString(numbers));

        // Test using String objects
        String[] names = {"Tendai", "Brian", "Angela", "Farai"};

        System.out.println("\nNames before sorting: "
                + Arrays.toString(names));

        BubbleSort.bubbleSort(names);

        System.out.println("Names after sorting: "
                + Arrays.toString(names));
    }
}
