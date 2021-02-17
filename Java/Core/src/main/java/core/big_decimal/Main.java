package core.big_decimal;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.*;

/**
 * BigDecimal - Неизменяемый
 *
 * https://javarush.ru/groups/posts/2274-kak-ispoljhzovatjh-bigdecimal-v-java
 * https://javarush.ru/groups/posts/2709-biginteger-i-bigdecimal
 *
 * Методы {@link BigDecimal}:
 * max -
 * abs -
 * add -
 * byteValue -
 * byteValueExact -
 * compareTo -
 * divide -
 * divideAndRemainder -
 * doubleValue -
 * intValue -
 * intValueExact -
 * divideToIntegralValue -
 * movePointLeft -
 * movePointRight -
 * multiply -
 * negate -
 * pow -
 * plus -
 * toPlainString -
 * precision -
 * round -
 * scale -
 * ulp -
 * scaleByPowerOfTen -
 * setScale - заданная точность
 * remainder -
 * divideAndRemainder -
 * signum -
 * stripTrailingZeros -
 * subtract -
 * unscaledValue -
 * toEngineeringString -
 *
 */
public class Main {

    public static void main(String[] args) {
        BigInteger integer = new BigInteger("111111111111111111111111111111111111111111111111111111111111111111111");
        System.out.println(integer);

        BigInteger result = integer.add(BigInteger.valueOf(33333333));
        System.out.println(result);


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
