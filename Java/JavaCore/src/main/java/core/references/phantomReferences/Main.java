package core.references.phantomReferences;


import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * https://javarush.ru/groups/posts/2291-osobennosti-phantomreference
 *
 * {@link PhantomReference} самые слабые ссылки из всех
 * Метод reference.get() для фантомной ссылки всегда возвращает null
 *
 * Фантомной ссылка становится когда на объект не будет ни Strong, ни Soft, ни Weak ссылок (помещается в ReferenceQueue)
 * Объект не удаляется из памяти до тех пор, пока его фантомная ссылка находится в этой очереди.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ReferenceQueue<TestClass> queue = new ReferenceQueue<>();
        TestClass testClass = new TestClass();

        Reference ref = new MyPhantomReference<>(testClass, queue);

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
