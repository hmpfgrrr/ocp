//comment
package main.java.oca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTime {

    public static void main(String[] args) {
        LocalDateTime d = LocalDateTime.of(2015,5,10,11,22,33);
        Period p = Period.of(1,2,3);
        d.minus(p);

        LocalDate d2 = LocalDate.of(2015, 5, 5);
        //DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(f.format(d2));
    }
}
