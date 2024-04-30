package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.*;

/**
 * Item
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-06T17:20:40.188024470Z[GMT]")


@Entity
@Table(name = "items")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;

  @Column(nullable = false)
  private String name = null;

  @Column
  private String description = null;

  @Column(nullable = false)
  private Double price = null;

  @ManyToOne
  @JoinColumn(name = "eventId", nullable = false)
  private Event event;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User seller;

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public User getSeller() {
    return seller;
  }

  public void setSeller(User seller) {
    this.seller = seller;
  }

  public Item() {
    this.name = "";
    this.price = 0.0;
  }

  public Item(String name, Double price, Event event) {
    this.name = name;
    this.price = price;
    this.event = event;
  }
  /**
   * Get name
   * @return name
   **/
  @Schema(required = true, description = "")
      @NotNull



  public Item description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(description = "")


  public Item price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   **/
  @Schema(required = true, description = "")
      @NotNull


  public Item itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
   **/
  @Schema(description = "")
  
  public Long getItemId() {
    return itemId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.name, item.name) &&
        Objects.equals(this.description, item.description) &&
        Objects.equals(this.price, item.price) &&
        Objects.equals(this.itemId, item.itemId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, price, itemId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
