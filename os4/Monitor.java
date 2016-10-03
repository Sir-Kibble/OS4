package os4;
//import java.util.Random;
public class Monitor{
    private int numReaders;
    private boolean writer;
    
    private final Object LOCK;
    
    public Monitor(){
        numReaders = 0;
        writer = false;
        LOCK = new Object();
        
    }//end constructor
    
    public synchronized void tryRead(){
        //synchronized(LOCK){
            while(!writer){
                try{
                    /*LOCK.*/wait();
                }catch(InterruptedException e){
                    System.out.println("Error in read! ");
                }//end catch
            }//end while
            numReaders++;
        //}//end sync
    }//end tryRead
    
    public synchronized void endRead(){
        //synchronized(this){
            numReaders--;
            notifyAll();
        //}
    }//end endRead
    
    public synchronized void tryWrite(){
        //synchronized(LOCK){
            while(!(numReaders == 0 && !writer)){
                try{
                    /*LOCK.*/wait();
                }catch(InterruptedException e){
                    System.out.println("Error in write! ");
                }//end catch
            }//end while
            writer = true;
        //}//end sync
    }//end tryWrite
    
    public synchronized void endWrite(){
        //synchronized(this){
            writer = false;
            notifyAll();
        //}//end sync
    }//end endWrite
}//end monitor
/*private static int var = 0;
    private static int numReaders;
    private static boolean writing;
    private int threadNum;
    private Object LOCK = new Object();
    private Random R;
    public Monitor(int t){
        threadNum = t;
        R = new Random();
    }//end constructor
    
    public int read(){
        synchronized(LOCK){
            while(!writing){
                numReaders++;
                try{
                    this.wait();
                }catch(InterruptedException e){
                    System.out.println("Interrupted read! ");
                }//end catch
            }//end while
            numReaders--;
            if(numReaders == 0)
                notifyAll();
        }//end synchronized
        
        return var;
    }//end read
    
    public int write(){
        synchronized(LOCK){
            while(numReaders > 0){
                try{
                wait();
                }catch(InterruptedException e){
                    System.out.println("Interrupted write! ");
                }//end catch
            }//end whi;e
            
        }//end sync
        
        var++;
        return var;
    }//end write

    @Override
    public void run() {
        
           try{ if(R.nextBoolean())
                System.out.println("Reading on thread "+this.threadNum+" : "+this.read());
            else
                System.out.println("Writing on thread "+this.threadNum+" : "+this.write());
        }catch(Exception T){
            System.out.println("Error! ");
        }//end catch
        //end while//throw new UnsupportedOperationException("Not supported yet.");
    }//end reader*/



/*    public void run() {
        while(true)
        synchronized(this){try{
            this.wait(1000);
            if(R.nextBoolean())
                System.out.println("Reading on thread "+this.threadNum+" : "+this.read());
            else
                System.out.println("Writing on thread "+this.threadNum+" : "+this.write());
        }catch(InterruptedException T){
            System.out.println("Error! ");
        }//end catch
        }//end sync
        //throw new UnsupportedOperationException("Not supported yet.");
    }*/