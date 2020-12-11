package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    public ChronoUnit frequency;
    public Duration duration;
    public ArrayList<LocalDate> exception;
    
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        // méthode implémentée
        this.frequency = frequency;
        this.duration = duration;
        this.exception = new ArrayList<>();
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        // méthode implémentée
        this.exception.add(date);
    }
    
    @Override
    public boolean isInDay(LocalDate theDay){
        if(exception.contains(theDay)){
            return false;
        }
        switch (this.frequency){
            case DAYS : 
                return this.getStart().toLocalDate().isBefore(theDay) || this.getStart().toLocalDate().equals(theDay);
            case WEEKS :
                for(int i =0;i<53;i++){
                    if(this.getStart().toLocalDate().plus(i, ChronoUnit.WEEKS).equals(theDay)){
                        return true;
                    }
                }
                return false;   
            case MONTHS:
                for(int i =0;i<12;i++){
                    if(this.getStart().toLocalDate().plus(i, ChronoUnit.MONTHS).equals(theDay)){
                        return true;
                    }
                }
                return false;
        }
        
        return this.getStart().toLocalDate().equals(theDay);
        }
    

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // méthode implémentée
        return this.frequency;   
    }
    
    @Override
    public String toString(){
        return this.getTitle()+" "+this.getStart()+" "+this.getDuration()+" "+this.getFrequency();
    }

}
