package uz.java.task.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private final File file;

    public FileReader(File file) {
        this.file = file;
    }

    public List<String> read() {
        List<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String next = scanner.nextLine().trim();
                if (!next.isEmpty() && i > 0) {
                    list.add(next);
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
