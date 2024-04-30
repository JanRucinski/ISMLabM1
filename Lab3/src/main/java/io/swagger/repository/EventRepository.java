package io.swagger.repository;
import io.swagger.model.Event;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Set;

public interface EventRepository extends JpaRepository<Event, Long>{
    Event findByLocation(String location);
    Event findByDate(LocalDate date);
    Event findByTime(String time);
    Event findByApproved(Boolean approved);
    Event findByEventId(Integer eventId);
    Event findByRegisteredUsers(Set<User> registeredUsers);
}
