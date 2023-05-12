package com.qa.serenity.data;

/**
 * This class saves product fields for comparison after submitting quote or reservation.
 *
 * @author Sai.yarlagadda
 */

public class ProductFields {

  private String category = "";
  private String product = "";
  private String quantity = "";
  private String startDate = "";
  private String endDate = "";

  /**
   * Set product category.
   */
  public void setCategory(String category) {
    this.category = category;
  }

  /**
   * Get product category.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Set product.
   */
  public void setProduct(String product) {
    this.product = product;
  }

  /**
   * Get Product.
   */
  public String getProduct() {
    return product;
  }

  /**
   * Set Quantity of products added to cart.
   */
  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  /**
   * Get quantity of products in the cart.
   */
  public String getQuantity() {
    return quantity;
  }

  /**
   * Set start date.
   */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  /**
   * Get start date.
   */
  public String getStartDate() {
    return startDate;
  }

  /**
   * Set end date.
   */
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  /**
   * Get end date.
   */
  public String getEndDate() {
    return endDate;
  }

}

