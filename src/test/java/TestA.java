import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import uz.java.task.model.Combined;
import uz.java.task.reader.FileReader;
import uz.java.task.sorter.FileSorter;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestA {
    private FileSorter fileSorter;

    @BeforeTest
    void init() {
        FileReader fileReader = new FileReader(new File("myFile0.csv"));
        this.fileSorter = new FileSorter(fileReader.read());
    }
    @Test
    public void printA() {
        List<String> strings = fileSorter.sortByString();
        Reporter.log(strings.toString(), true);
        Reporter.log(String.valueOf(strings.size()), true);
    }

    @Test
    public void printB() {
        List<String> numbers = fileSorter.sortByNumber();
        Reporter.log(numbers.toString(), true);
        Reporter.log(String.valueOf(numbers.size()), true);
    }

    @Test
    public void printC() {
        List<Combined> combined = fileSorter.combine();
        Reporter.log(combined.toString(), true);
        Reporter.log(String.valueOf(combined.size()), true);
    }
}
