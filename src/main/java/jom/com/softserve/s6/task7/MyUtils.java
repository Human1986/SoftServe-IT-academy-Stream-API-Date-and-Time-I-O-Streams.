package jom.com.softserve.s6.task7;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<Integer> duplicateElements(Stream<Integer> stream) {

     return  stream
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        number -> number, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .flatMap(entry -> Stream.generate(entry::getKey).limit(1))
                .sorted();

    }

}
