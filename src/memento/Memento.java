package memento;
import java.util.*;
import java.util.concurrent.TimeUnit;

#original code from: https://www.geeksforgeeks.org/memento-design-pattern/
#modified by Nathan Nguyen for in class demo

//Originator
class Looper
{
    private String time;

    public void set(String time) 
    {
        System.out.println("Time travelling to the year " + time);
        this.time = time;
    }

    public Memento saveToMemento()
    {
        System.out.println("Saving time state to Memento\n");
        return new Memento(time);
    }

    public void restoreFromMemento(Memento memento)
    {
        time = memento.getSavedTime();
        System.out.println("Recalled from Memento year " + time);
    }

    //Momento
    public static class Memento 
    {
        private final String time;

        public Memento(String timeToSave) 
        {
            time = timeToSave;
        }

        public String getSavedTime() 
        {
            return time;
        }
    }
}

public class Memento
{
    public static void main(String[] args) throws InterruptedException 
    {
        //Caretaker: List
        List<Looper.Memento> savedTimes = new ArrayList<>();

        Looper Tracer = new Looper();

        //Loop in Time
        Tracer.set("1963");
        System.out.println("JFK is AFK");
        Thread.sleep(7000);
        savedTimes.add(Tracer.saveToMemento());
        Thread.sleep(5000);
        
        Tracer.set("1969");
        System.out.println("Apollo 11: One Giant Leap for Mankind");
        Thread.sleep(7000);
        savedTimes.add(Tracer.saveToMemento());
        Thread.sleep(5000);
        
        Tracer.set("2018");
        System.out.println("The Present");
        Thread.sleep(7000);
        savedTimes.add(Tracer.saveToMemento());
        Thread.sleep(5000);
        
        Tracer.set("2049");
        System.out.println("Are your memories real?");
        Thread.sleep(7000);
        System.out.println("\nRecalling to initial time state...");
        Thread.sleep(5000);
        Tracer.restoreFromMemento(savedTimes.get(0)); 
        Thread.sleep(3000);
        System.out.println("Ever get that feeling of Deja Vu?\n");
        Thread.sleep(2000);
    }
}