package com.rezdy.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DateUtils {

  public static LocalDate toDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);

    return LocalDate.parse(dateString, formatter);
  }


}
