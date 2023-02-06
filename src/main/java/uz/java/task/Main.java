package uz.java.task;

import uz.java.task.db.DbHelper;
import uz.java.task.reader.FileReader;
import uz.java.task.sorter.FileSorter;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        FileReader reader = new FileReader(new File("myFile0.csv"));
        List<String> read = reader.read();
        FileSorter fileSorter = new FileSorter(read);
        System.out.println(fileSorter.sortByString());
        System.out.println(fileSorter.sortByNumber());

        DbHelper dbHelper = new DbHelper("jdbc:postgresql://localhost:5432/postgres", "postgres", "4162");
        dbHelper.connect();
//        try {
//            dbHelper.initilize(fileSorter.combine());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        List<String> numbers = dbHelper.getNumbers();
        List<String> strings = dbHelper.getStrings();
        System.out.println(numbers);
        System.out.println(strings);
        dbHelper.close();
    }
}
