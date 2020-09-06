package core.references.phantomReferences;


public class TestClass {

    private StringBuffer data;

    public TestClass() {
        this.data = new StringBuffer();
        for (long i = 0; i < 50_000_000; i++) {
            this.data.append('x');
        }
    }

    @Override
    protected void finalize() {
        System.out.println("У объекта TestClass вызван метод finalize!!!");
    }
}
