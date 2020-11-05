package patterns.structural;


/**
 * Оборачивает некоторый класс и предоставляет такой же интерфейс. Цель -- "притвориться" оригинальным классом
 * и скрыть от клиента детали.
 *
 * https://habr.com/ru/post/88722/
 */
public class Proxy {

    public static void main(String[] args) {

        Bank bank = new AuthProxy(new CityBank());
        bank.reduceMoney(new User(),100);
    }


    static class AuthProxy implements Bank {

        private Bank bank;

        public AuthProxy(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void addMoney(User user, int money) {
            System.out.println("Проверка логина и пароля");
            bank.addMoney(user, money);
        }

        @Override
        public void reduceMoney(User user, int money) {
            System.out.println("Проверка логина и пароля");
            bank.reduceMoney(user, money);
        }

    }



    interface Bank {
        public void addMoney(User user, int money);
        public void reduceMoney(User user, int money);
    }


    /**
     * Bank impl
     */
    static class CityBank implements Bank{
        @Override
        public void addMoney(User user, int money) {
            user.setAmountMoney(user.getAmountMoney() + money);
        }

        @Override
        public void reduceMoney(User user, int money) {
            user.setAmountMoney(user.getAmountMoney() - money);
        }

    }



    /**
     * User
     */
    static class User {

        private String name;
        private int amountMoney;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmountMoney() {
            return amountMoney;
        }

        public void setAmountMoney(int amountMoney) {
            this.amountMoney = amountMoney;
        }
    }
}
