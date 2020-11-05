package patterns.structural;

import java.util.HashMap;
import java.util.Map;


public class Flyweight {

    public static void main(String[] args) {
        Garage garage = new Garage();
        Mercedes mercedes = garage.getMercedes("green");
        Mercedes mercedes2 = garage.getMercedes("green");
        System.out.println(mercedes == mercedes2);
    }


    static class Mercedes{

        private String color;

        public Mercedes(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    /**
     * FlyWeigth
     */
    static class Garage {

        private Map<String, Mercedes> map = new HashMap<>();

        public Mercedes getMercedes(String color) {
            Mercedes mercedes = map.get(color);
            if(mercedes == null) {
                mercedes = new Mercedes(color);
                map.put(color, mercedes);
            }
            return mercedes;
        }
    }
}
