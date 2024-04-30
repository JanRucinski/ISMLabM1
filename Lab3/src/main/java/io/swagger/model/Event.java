package io.swagger.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.persistence.*;

/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-04-06T17:20:40.188024470Z[GMT]")

@Entity
@Table(name = "events")
public class Event   {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String location = null;

  @Column(nullable = false)
  private LocalDate date = null;

  @Column(nullable = false)
  private String time = null;

  @Column(nullable = false)
  private Boolean approved = false;

  @Column(nullable = false)
  private Integer eventId = null;

  @ManyToMany
  @JoinTable(
          name = "Event_Item",
          joinColumns = @JoinColumn(name = "event_id"),
          inverseJoinColumns = @JoinColumn(name = "item_id")
  )
    private Set<Item> items = new HashSet<>();

  @ManyToMany
  @JoinTable(
          name = "User_Event",
          joinColumns = @JoinColumn(name = "event_id"),
          inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private Set<User> registeredUsers = new HashSet<>();
  // ... rest of the code ...


/**
 * Event

  public Event location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Event date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Event time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Event approved(Boolean approved) {
    this.approved = approved;
    return this;
  }

  /**
   * Get approved
   * @return approved
   **/
  @Schema(description = "")
  
    public Boolean isApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  public Event eventId(Integer eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * Get eventId
   * @return eventId
   **/
  @Schema(description = "")
  
    public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.location, event.location) &&
        Objects.equals(this.date, event.date) &&
        Objects.equals(this.time, event.time) &&
        Objects.equals(this.approved, event.approved) &&
        Objects.equals(this.eventId, event.eventId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, date, time, approved, eventId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
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

  public Object getItems() {
    return null;
  }
}
