package lab5_6SortingAlgorithms.saving;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveTableToTxt {
    public static void save(List<String> list, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/lab56SortingAlgorithms/files/"+filename + ".txt"));
            for (String row : list) {
                writer.write(row + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
