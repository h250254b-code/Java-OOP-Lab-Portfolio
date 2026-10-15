
package lab10filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Learner(String name, int marks) {
    String gradeBand() {
        if (marks >= 80) {
            return "A";
        } else if (marks >= 60) {
            return "B";
        } else {
            return "C";
        }
    }
}

public class Main {

    public static void main(String[] args) {

        List<Learner> learners = new ArrayList<>();

        // Read learners from the CSV file
        try (BufferedReader reader =
                new BufferedReader(new FileReader("learners.csv"))) {

            String line;
            reader.readLine(); // Skip the CSV header

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0].trim();
                int marks = Integer.parseInt(data[1].trim());

                learners.add(new Learner(name, marks));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading learners.csv: "
                    + e.getMessage());
            return;
        }

        // Group learners by grade band
        Map<String, List<Learner>> groupedLearners =
                learners.stream().collect(
                        Collectors.groupingBy(Learner::gradeBand));

        // Create one report file for each grade band
        String[] gradeBands = {"A", "B", "C"};

        for (String grade : gradeBands) {
            String fileName = "report_" + grade + ".txt";

            try (BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName))) {

                writer.write("GRADE " + grade + " REPORT");
                writer.newLine();
                writer.write("================");
                writer.newLine();

                List<Learner> group = groupedLearners.getOrDefault(
                        grade, new ArrayList<>());

                for (Learner learner : group) {
                    writer.write(learner.name() + " - "
                            + learner.marks());
                    writer.newLine();
                }

                System.out.println(fileName
                        + " created successfully.");

            } catch (IOException e) {
                System.out.println("Error writing " + fileName
                        + ": " + e.getMessage());
            }
        }
    }
}
