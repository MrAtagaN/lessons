package core.bigDecimal;

import java.math.BigDecimal;

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
        BigDecimal x = new BigDecimal("1.5");
        BigDecimal y = new BigDecimal("1.50");
        System.out.println(x.equals(y)); // false
        System.out.println(x.compareTo(y)); //0

    }
}
