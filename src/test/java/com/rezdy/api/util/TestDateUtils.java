package com.rezdy.api.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test {@link DateUtils}
 * 
 * @author junfeng
 *
 */
public class TestDateUtils {

  /**
   * Test {@link DateUtils#toDate(String)}
   * 
   * Input parsable dateString
   */
  @Test
  public void testToDate() {
    String dateStr = "2016-12-30";
    LocalDate date = DateUtils.toDate(dateStr);

    Assert.assertThat(date.getYear(), is(equalTo(2016)));
    Assert.assertThat(date.getMonthValue(), is(equalTo(12)));
    Assert.assertThat(date.getDayOfMonth(), is(equalTo(30)));

    dateStr = "2018-06-21";
    date = DateUtils.toDate(dateStr);

    Assert.assertThat(date.getYear(), is(equalTo(2018)));
    Assert.assertThat(date.getMonthValue(), is(equalTo(06)));
    Assert.assertThat(date.getDayOfMonth(), is(equalTo(21)));
  }

  /**
   * Test {@link DateUtils#toDate(String)}
   * 
   * Input non-parsable dateString
   */
  @Test
  public void testToDate_whenInputNonparsableDateString() {
    String dateStr = "2016/12/30";
    LocalDate date = DateUtils.toDate(dateStr);
    Assert.assertThat(date, is(nullValue()));

    dateStr = "2016 Dec 30";
    date = DateUtils.toDate(dateStr);
    Assert.assertThat(date, is(nullValue()));

    dateStr = "30-12-2016";
    date = DateUtils.toDate(dateStr);
    Assert.assertThat(date, is(nullValue()));

    dateStr = "30-Dec-2016";
    date = DateUtils.toDate(dateStr);
    Assert.assertThat(date, is(nullValue()));

    dateStr = "30 Dec 2016";
    date = DateUtils.toDate(dateStr);
    Assert.assertThat(date, is(nullValue()));
  }

}
