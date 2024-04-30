package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Report
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-06T17:20:40.188024470Z[GMT]")

@Entity
@Table(name = "reports")
public class Report   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long reportId;
  @Column(nullable = false)
  private Integer totalNumberOfEvents = null;

  @Column(nullable = false)
  private Integer approvedNumberOfEvents = null;

  @Column(nullable = false)
  private Integer rejectedNumberOfEvents = null;

  @Column(nullable = false)
  private BigDecimal averageNumberOfItemsPerEvent = null;

  public Report totalNumberOfEvents(Integer totalNumberOfEvents) {
    this.totalNumberOfEvents = totalNumberOfEvents;
    return this;
  }

  /**
   * Get totalNumberOfEvents
   * @return totalNumberOfEvents
   **/
  @Schema(description = "")
  
    public Integer getTotalNumberOfEvents() {
    return totalNumberOfEvents;
  }

  public void setTotalNumberOfEvents(Integer totalNumberOfEvents) {
    this.totalNumberOfEvents = totalNumberOfEvents;
  }

  public Report approvedNumberOfEvents(Integer approvedNumberOfEvents) {
    this.approvedNumberOfEvents = approvedNumberOfEvents;
    return this;
  }

  /**
   * Get approvedNumberOfEvents
   * @return approvedNumberOfEvents
   **/
  @Schema(description = "")
  
    public Integer getApprovedNumberOfEvents() {
    return approvedNumberOfEvents;
  }

  public void setApprovedNumberOfEvents(Integer approvedNumberOfEvents) {
    this.approvedNumberOfEvents = approvedNumberOfEvents;
  }

  public Report rejectedNumberOfEvents(Integer rejectedNumberOfEvents) {
    this.rejectedNumberOfEvents = rejectedNumberOfEvents;
    return this;
  }

  /**
   * Get rejectedNumberOfEvents
   * @return rejectedNumberOfEvents
   **/
  @Schema(description = "")
  
    public Integer getRejectedNumberOfEvents() {
    return rejectedNumberOfEvents;
  }

  public void setRejectedNumberOfEvents(Integer rejectedNumberOfEvents) {
    this.rejectedNumberOfEvents = rejectedNumberOfEvents;
  }

  public Report averageNumberOfItemsPerEvent(BigDecimal averageNumberOfItemsPerEvent) {
    this.averageNumberOfItemsPerEvent = averageNumberOfItemsPerEvent;
    return this;
  }

  /**
   * Get averageNumberOfItemsPerEvent
   * @return averageNumberOfItemsPerEvent
   **/
  @Schema(description = "")
  
    @Valid
    public BigDecimal getAverageNumberOfItemsPerEvent() {
    return averageNumberOfItemsPerEvent;
  }

  public void setAverageNumberOfItemsPerEvent(BigDecimal averageNumberOfItemsPerEvent) {
    this.averageNumberOfItemsPerEvent = averageNumberOfItemsPerEvent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Report report = (Report) o;
    return Objects.equals(this.totalNumberOfEvents, report.totalNumberOfEvents) &&
        Objects.equals(this.approvedNumberOfEvents, report.approvedNumberOfEvents) &&
        Objects.equals(this.rejectedNumberOfEvents, report.rejectedNumberOfEvents) &&
        Objects.equals(this.averageNumberOfItemsPerEvent, report.averageNumberOfItemsPerEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalNumberOfEvents, approvedNumberOfEvents, rejectedNumberOfEvents, averageNumberOfItemsPerEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Report {\n");
    
    sb.append("    totalNumberOfEvents: ").append(toIndentedString(totalNumberOfEvents)).append("\n");
    sb.append("    approvedNumberOfEvents: ").append(toIndentedString(approvedNumberOfEvents)).append("\n");
    sb.append("    rejectedNumberOfEvents: ").append(toIndentedString(rejectedNumberOfEvents)).append("\n");
    sb.append("    averageNumberOfItemsPerEvent: ").append(toIndentedString(averageNumberOfItemsPerEvent)).append("\n");
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
