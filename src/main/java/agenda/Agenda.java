package agenda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
     public HashSet<Event> Events = new HashSet<Event>();
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    
    public void addEvent(Event e) {
        this.Events.add(e);

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        // méthode implémentée
        List eventsInDay = new LinkedList<>();
        for (Event event : agenda){
            if(event.isInDay(day))
                eventsInDay.add(event);
        }
          return eventsInDay;
        
    }
}
