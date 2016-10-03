package os4pt2;
public class Monitor {
    /*
     Show that a semaphore with no busy waiting can be implemented using a monitor. (Hint: write a monitor
code to implement a semaphore with no busy waiting. That is, if there were no semaphore concept, still we
could use a monitor to behave exactly as a semaphore with no busy waiting.)
     */
    
    private int semaphore;
    
    public Monitor(){
        semaphore = 10;
    }//end constructor
    
    public void add(Process p){
        if(semaphore == 10)
            wait(0);
    }
    
    
}//end monitor
