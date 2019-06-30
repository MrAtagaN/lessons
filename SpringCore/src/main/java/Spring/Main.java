package Spring;

import Spring.annotationBeans.*;
import Spring.xmlBeans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("Spring.annotationBeans");
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");

        //обычный бин
        CatAnnotation catAnnotation =  annotationConfigApplicationContext.getBean("catAnnotation", CatAnnotation.class);
        catAnnotation.say();
        Cat cat = classPathXmlApplicationContext.getBean("cat", Cat.class);
        cat.say();

        //бин с другим id
        MouseAnnotation mouseAnnotation = annotationConfigApplicationContext.getBean("mouse", MouseAnnotation.class);
        mouseAnnotation.say();
        Mouse mouse = classPathXmlApplicationContext.getBean("mouse", Mouse.class);
        mouse.say();

        //бин созданный фабричным методом
        BirdAnnotation birdAnnotation = annotationConfigApplicationContext.getBean("birdAnnotation", BirdAnnotation.class);
        birdAnnotation.say();
        Bird bird = classPathXmlApplicationContext.getBean("bird", Bird.class);
        bird.say();

        //бин с параметром конструктора
        MonkeyAnnotation monkeyAnnotation = annotationConfigApplicationContext.getBean("monkeyAnnotation", MonkeyAnnotation.class);
        monkeyAnnotation.say();
        Monkey monkey = classPathXmlApplicationContext.getBean("monkey", Monkey.class);
        monkey.say();

        //бин с изменеными свойствами
        FishAnnotation fishAnnotation = annotationConfigApplicationContext.getBean("fishAnnotation", FishAnnotation.class);
        fishAnnotation.say();
        Fish fish = classPathXmlApplicationContext.getBean("fish", Fish.class);
        fish.say();

        //DogAnnotation dog = annotationConfigApplicationContext.getBean("dogAnnotation", DogAnnotation.class);
        TigerAnnotation tiger =  annotationConfigApplicationContext.getBean("tigerAnnotation", TigerAnnotation.class );
        tiger.say();



    }
}
