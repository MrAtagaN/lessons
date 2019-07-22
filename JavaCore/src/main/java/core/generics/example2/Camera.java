package core.generics.example2;


public class Camera extends Product implements Comparable<Camera> {

    protected int pixel;

    @Override
    public int compareTo(Camera o) {
        return 0;
    }
}
