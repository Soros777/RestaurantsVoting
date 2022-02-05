package ua.dnipro.restaurantsvoting.util;

import java.time.LocalTime;

public class DateTimeUtil {

    public static boolean isBefore11am() {
        return LocalTime.now().isBefore(LocalTime.of(11, 0));
    }
}
