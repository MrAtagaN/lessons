package Spring.annotationBeans;

import org.springframework.stereotype.Component;

@Component() //cделать prototype
public class CatAnnotation {

    private static int count = 0;

    private int number;

    public CatAnnotation() {
        this.count++;
        this.number = count;
    }

    public void say() {
        System.out.println("CatAnnotation number " + number + " say \"Meaw\"!");
    }
}
