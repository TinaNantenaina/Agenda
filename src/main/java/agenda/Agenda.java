package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private ArrayList<Event> listEvent;
    public Agenda(){
       this.listEvent = new ArrayList<>(); 
    }
    
    public void addEvent(Event e) {
        this.listEvent.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day){
        // méthode implémentée
        ArrayList<Event> liste = new ArrayList();
        for (Event e: listEvent ){
            if(e.isInDay(day))
               liste.add(e);
        }
          return liste;
        
    }
}
        
