package references.phantomReferences;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * https://javarush.ru/groups/posts/2291-osobennosti-phantomreference
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);

        ReferenceQueue<TestClass> queue = new ReferenceQueue<>();
        Reference ref = new MyPhantomReference<>(new TestClass(), queue);

        System.out.println("ref = " + ref);

        Thread.sleep(5000);

        System.out.println("Вызывается сборка мусора!");

        System.gc();
        Thread.sleep(300);

        System.out.println("ref = " + ref);

        Thread.sleep(5000);

        System.out.println("Вызывается сборка мусора!");

        System.gc();
    }
}
