package uz.java.task.sorter;

import uz.java.task.model.Combined;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileSorter {
    public static final String SPLITTER = ",";
    private final List<String> data;

    public FileSorter(List<String> data) {
        this.data = data;
    }

//    public List<String> sortByString() {
//        return data.stream()
//                .map(s -> {
//            String[] strings = s.split(SPLITTER);
//            return strings[1];
//        })
//                .sorted()
//                .collect(Collectors.toList());
//    }

    public List<String> sortByString() {
        return data.stream()
                .sorted(Comparator.comparing(o -> o.split(SPLITTER)[1]))
                .collect(Collectors.toList());
    }

//    public List<Integer> sortByNumber() {
//        return data.stream()
//                .map(s -> {
//            String[] strings = s.split(SPLITTER);
//            return strings[0];
//        })
//                .filter(s -> {
//            try {
//                Integer.parseInt(s);
//                return true;
//            } catch (NumberFormatException e) {
//                return false;
//            }
//        })
//                .mapToInt(Integer::parseInt)
//                .boxed()
//                .sorted()
//                .collect(Collectors.toList());
//    }

    public List<String> sortByNumber() {
        return data.stream()
                .sorted(Comparator.comparingInt(o -> Integer.parseInt(o.split(SPLITTER)[0])))
                .collect(Collectors.toList());
    }

    public List<Combined> combine() {
        return data.stream().map(s -> {
            String[] split = s.split(SPLITTER);
            return new Combined(Integer.parseInt(split[0]), split[1]);
        }).collect(Collectors.toList());
    }

}
