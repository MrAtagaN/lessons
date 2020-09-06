package core.big_decimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.*;

/**
 * https://javarush.ru/groups/posts/2274-kak-ispoljhzovatjh-bigdecimal-v-java
 * https://javarush.ru/groups/posts/2709-biginteger-i-bigdecimal
 *
 * Неизменяемый
 */
public class Main {

    public static void main(String[] args) {
        BigInteger integer = new BigInteger("111111111111111111111111111111111111111111111111111111111111111111111");
        System.out.println(integer);

        BigInteger result = integer.add(BigInteger.valueOf(33333333));
        System.out.println(result);

        //округление в большую сторону
        BigDecimal bigDecimal = new BigDecimal("111.5555555555").setScale(3, ROUND_CEILING);
        System.out.println(bigDecimal); //111.556

        //отбрасывание разряда
        BigDecimal bigDecimal2 = new BigDecimal("111.5555555555").setScale(3, ROUND_DOWN);
        System.out.println(bigDecimal2); //111.555

        //округление в меньшую сторону
        BigDecimal bigDecimal3 = new BigDecimal("111.5555555555").setScale(3, ROUND_FLOOR);
        System.out.println(bigDecimal3); //111.555

        //округление в большую сторону, если число после запятой >= .5
        BigDecimal bigDecimal4 = new BigDecimal("111.55").setScale(1, ROUND_HALF_UP);
        System.out.println(bigDecimal4); //111.6

        //округление в большую сторону, если число после запятой > .5
        BigDecimal bigDecimal5 = new BigDecimal("121.55").setScale(1, ROUND_HALF_DOWN);
        System.out.println(bigDecimal5); //121.5

        //округление будет зависеть от цифры слева от запятой. Если цифра слева будет четной, то округление будет
        //произведено вниз, в меньшую сторону. Если цифра слева от запятой нечетная, то округление будет произведено
        //вверх.
        BigDecimal bigDecimal6 = new BigDecimal("121.5").setScale(0, ROUND_HALF_EVEN);
        System.out.println(bigDecimal6); //122

        BigDecimal bigDecimal7 = new BigDecimal("122.5").setScale(0, ROUND_HALF_EVEN);
        System.out.println(bigDecimal7); //122


        //Сравнение чисел
        Double a = 1.5;
        Double b = 1.50;
        System.out.println(a.equals(b)); // true

        BigDecimal x = new BigDecimal("1.5");
        BigDecimal y = new BigDecimal("1.50");
        System.out.println(x.equals(y)); // false

        System.out.println(x.compareTo(y));

    }
}
