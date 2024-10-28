package jom.com.softserve.s6.task5;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {

        return map.values().stream()
                .flatMap(stream -> stream)
                .filter(Objects::nonNull)
                .map(s -> s.replace(" ", ""))
                .filter(participant -> ! participant.isEmpty())
                .map(participant -> participant.substring(0, 1).toUpperCase() + participant.substring(1).toLowerCase())
                .distinct()
                .sorted();

    }

}
