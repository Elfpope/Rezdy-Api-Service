package com.rezdy.api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * It encapsulates utility method for date-related calculation.
 * 
 * @author junfeng
 *
 */
public abstract class DateUtils {
  private static Logger LOG = LoggerFactory.getLogger(DateUtils.class);

  /**
   * Convert the given dateString to {@link LocalDate}
   * 
   * @param dateString to be converted
   * @return {@link LocalDate} value based on the given dateString
   */
  public static LocalDate toDate(String dateString) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN);

    LocalDate result = null;
    try {
      result = LocalDate.parse(dateString, formatter);
    } catch (DateTimeParseException e) {
      LOG.error("The input dateString {[]} cannot be parsed.", dateString);
    }

    return result;
  }
}
