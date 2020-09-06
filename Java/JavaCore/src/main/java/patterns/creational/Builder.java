package patterns.creational;

public class Builder {


    /**
     * Паттерн билдер
     */
    public static void main(String[] args) {
        Builder builder = new Builder.Construct().setInfo("some text").setSomeInt(123).setSomeDouble(0.32323).build();
    }


    private String info;
    private int someInt;
    private double someDouble;

    private Builder(Construct construct) {
        this.info = construct.info;
        this.someInt = construct.someInt;
        this.someDouble = construct.someDouble;
    }


    public static class Construct {

        private String info;
        private int someInt;
        private double someDouble;

        public Construct setInfo(String info) {
            this.info = info;
            return this;
        }

        public Construct setSomeInt(int someInt) {
            this.someInt = someInt;
            return this;
        }

        public Construct setSomeDouble(double someDouble) {
            this.someDouble = someDouble;
            return this;
        }

        public Builder build() {
            return new Builder(this);
        }
    }

}

