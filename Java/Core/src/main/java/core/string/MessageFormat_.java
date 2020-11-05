package core.string;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Date;

/**
 * https://javarush.ru/groups/posts/590-klass-messageformat
 */
public class MessageFormat_ {

    public static void main(String[] args) {
        format();
        form();
        choice();
        classFormat();
    }

    /**
     * Статический метод
     */
    public static void format() {
        String string = MessageFormat.format("---{0}---{1}---", "a", "b");
        System.out.println(string);

        int planet = 7;
        String event = "a disturbance in the Force";
        String result = MessageFormat.format(
                "At {0, time, medium} on {0, date}, there was {1} on planet {2, number, integer}.",
                new Date(), event, planet);
        System.out.println(result);
    }

    /**
     * Шаблон в конструктор
     */
    public static void form() {
        int fileCount = 1273;
        String diskName = "MyDisk";
        Object[] testArgs = {fileCount, diskName};

        MessageFormat form = new MessageFormat("The disk \"{1}\" contains {0} file(s).");
        System.out.println(form.format(testArgs));
    }

    /**
     * Форматирование одного аргумента в MessageFormat
     */
    public static void choice() {
        MessageFormat form = new MessageFormat("Я могу {1} {0}.");
        int count = 2;
        String exercise = "подтянуться";
        Object[] testArgs = {count, exercise};

        double[] fileLimits = {0, 2, 5};
        String[] filePart = {"{0} раз", "{0} раза", "{0} раз"};
        ChoiceFormat choiceFormat = new ChoiceFormat(fileLimits, filePart);

        //Форматирование нулевого аргумента в form.format(testArgs)
        form.setFormatByArgumentIndex(0, choiceFormat);
        System.out.println(form.format(testArgs));
    }

    /**
     * Форматирование аргументов в MessageFormat
     */
    public static void classFormat() {
        MessageFormat pattForm = new MessageFormat("There {0} on {1}.\n{2} {2}");
        int count = 0;
        Date date = new Date();
        Object[] testArgs = {count, "ADisk", date, date};

        double[] fileLimits = {0, 1, 2};
        String[] filePart = {"are no files", "is one file", "are {0} files"};
        ChoiceFormat fileForm = new ChoiceFormat(fileLimits, filePart);

        Format[] testFormats = {fileForm, null, DateFormat.getDateInstance(DateFormat.SHORT), DateFormat.getTimeInstance(DateFormat.SHORT)};
        pattForm.setFormats(testFormats);

        System.out.println(pattForm.format(testArgs));
    }
}
