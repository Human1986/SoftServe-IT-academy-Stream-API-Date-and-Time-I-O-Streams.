package jom.com.softserve.s6.task6;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry;

public class MyUtils {

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {

        Map<String, List<String>> groupedMap = list.stream()
                .flatMap(stream -> stream)
                .filter(Objects::nonNull)
                .filter(s -> ! s.isEmpty())
                .distinct()
                .map(phone -> phone.replaceAll("[\\s\\-()]+", ""))
                .filter(s -> ! s.isEmpty())
                .sorted()
                .collect(Collectors.groupingBy(number -> {
                    if (number.length() < 7) return "err";
                    if (number.length() == 7) return "loc";
                    return number.substring(0, 3);
                }));

        return groupedMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Entry::getKey, entry -> entry.getValue().stream()
                                .map(s -> {
                                    if (s.length() == 5 || s.length() == 7) return s;
                                    return s.substring(3);
                                })
                                .toList().stream()
                ));
    }
}
