package core.string;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Collator_ {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AA");
        list.add("aa");
        list.add("bb");
        list.add("BB");
        list.add("Ab");
        list.add("bA");
        list.add("Ba");
        list.add("aB");

        Collator collator = Collator.getInstance();
        Collections.sort(list, collator);

        list.forEach(System.out::println);
    }
}
