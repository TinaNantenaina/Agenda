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
    
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        // méthode implémenté
         List<Event> eventsInAgenda = new LinkedList<>();
        for (Event e : listEvent) {
            if (e.getTitle().equals(title)) {
                eventsInAgenda.add(e);
            }
        }
        return eventsInAgenda;
        
    }
    
    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        // méthode implémentée
         if (listEvent.isEmpty()) {
            return true;
        }
        for (Event event : listEvent) {
            if (!e.getStart().isBefore(event.getStart()) && !e.getStart().isAfter(event.getStart().plus(event.getDuration()))) {
                return false;
            }
        }
        return true;
    }
}
        
