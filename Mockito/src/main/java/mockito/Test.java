package mockito;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) throws IOException {
        firstTest();
        secondTest();
        thirdTest();
        fourTest();
        fiveTest();
        sixTest();
    }




    public static void firstTest() {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");
        //выполняем
        String result = i.next()+" "+i.next();
        //сравниваем
        System.out.println("Hello World");
        System.out.println(result);
    }

    public static void secondTest() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(1);
        //сравниваем
        System.out.println(1);
        System.out.println(c.compareTo("Test"));
    }

    public static void thirdTest() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo(anyInt())).thenReturn(-1);
        //сравниваем
        System.out.println(-1);
        System.out.println(c.compareTo(5));
    }

    public static void fourTest() {
        try {
            OutputStream mock = mock(OutputStream.class);
            OutputStreamWriter osw = new OutputStreamWriter(mock);
            doThrow(new IOException()).when(mock).close();
            osw.close();
        } catch (Exception e) {
            System.out.println("mock object throw exception");
        }
    }

    public static void fiveTest() {
        try {
            OutputStream mock = mock(OutputStream.class);
            OutputStreamWriter osw = new OutputStreamWriter(mock);
            osw.close();
            verify(mock).close();  //если метод не будет вызван, вылетит Exception
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sixTest() throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.write('a');
        osw.flush();
        // не можем делать так, потому что мы не знаем,
        // насколько длинным может быть массив
        // verify(mock).write(new byte[]{'a'}, 0, 1);

        BaseMatcher<byte[]> arrayStartingWithA = new BaseMatcher<byte[]>() {
            @Override
            public void describeTo(Description description) {
                // пустота
            }
            // Проверяем, что первый символ - это A
            @Override
            public boolean matches(Object item) {
                byte[] actual = (byte[]) item;
                return actual[0] == 'a';
            }
        };
        // проверяем, что первый символ массива - это A, и что другие два аргумента равны 0 и 1.
        verify(mock).write(argThat(arrayStartingWithA), eq(0), eq(1));
    }
}
