package com.rezdy.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ingredient {

  private String title;

  @JsonProperty("best-before")
  private String bestBefore;

  @JsonProperty("use-by")
  private String useBy;

  public Ingredient() {}

  public Ingredient(String title) {
    this.title = title;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the bestBefore
   */
  public String getBestBefore() {
    return bestBefore;
  }

  /**
   * @param bestBefore the bestBefore to set
   */
  public void setBestBefore(String bestBefore) {
    this.bestBefore = bestBefore;
  }

  /**
   * @return the useBy
   */
  public String getUseBy() {
    return useBy;
  }

  /**
   * @param useBy the useBy to set
   */
  public void setUseBy(String useBy) {
    this.useBy = useBy;
  }

  @Override
  public String toString() {
    return String.format("[title: %s, bestBefore: %s, useBy: %s]", title, bestBefore, useBy);
  }
}
