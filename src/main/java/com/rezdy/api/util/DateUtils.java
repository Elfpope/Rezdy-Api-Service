package com.rezdy.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DateUtils {
  private static Logger LOG = LoggerFactory.getLogger(DateUtils.class);

  public static LocalDate toDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);

    LocalDate result = null;
    try {
      result = LocalDate.parse(dateString, formatter);
    } catch (DateTimeParseException e) {
      LOG.error(String.format("The input dateString [%s] cannot be parsed.", dateString));
    }

    return result;
  }
}
