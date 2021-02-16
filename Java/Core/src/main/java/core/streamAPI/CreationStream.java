package core.streamAPI;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Создание стримов
 *
 * Методы {@link Stream}:
 *
 * empty - без элементов
 * of - из массива
 * generate - бесконечная последовательность, генерируемая функцией
 * builder - добавление элементов в стрим
 * concat - соединить два стрима
 * range - стрим чисел из диапазона
 * rangeClosed - стрим чисел из диапазона включительно
 */
public class CreationStream {

    public static void main(String[] args) throws IOException {

        //empty stream
        Stream<String> emptyStream = Stream.empty();


        //stream of collection
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();


        //stream of array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        Stream<String> streamOfArray = Stream.of(arr);
        Stream<String> streamOfArray2 = Stream.of("a", "b", "c");


        //stream builder
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();


        //stream generate
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);


        //stream iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);


        //stream of primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        IntStream intStream2 = "String".chars();
        IntStream intStream3 = "String".codePoints();


        //stream of string
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");


        //stream of file
        Path path = Paths.get("Java/Core/src/main/resources/testFile.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);
    }
}
