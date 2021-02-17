package core.big_decimal;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;
import static java.math.BigDecimal.ROUND_HALF_EVEN;

public class Scale {

    public static void main(String[] args) {

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
    }
}
