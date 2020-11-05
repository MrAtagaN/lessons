package core.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class PatternAndMatcher {

    public static void main(String[] args) {
        String text = "2020-12-12T24:10:12";

        Pattern pattern = Pattern.compile("\\d{4}-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\d(.[\\d]{1,6})?(([+\\-]\\d\\d:\\d\\d)|Z)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }

//        Pattern.matches();
//        Pattern.quote();
//        Pattern.compile("");
//
//        pattern.asPredicate();
//        pattern.flags();
//        pattern.matcher();
//        pattern.pattern();
//        pattern.split();
//
//
//
//        Matcher.quoteReplacement();
//
//        matcher.appendReplacement();
//        matcher.appendTail();
//        matcher.start()
//        matcher.end();
//        matcher.find();
//        matcher.appendReplacement();
//        matcher.group();
//        matcher.hasAnchoringBounds();
//        matcher.hasTransparentBounds();
//        matcher.groupCount();
//        matcher.hitEnd();
//        matcher.lookingAt();
//        matcher.matches();
//        matcher.reset();

    }
}
