package os4;
import java.util.Random;
public class ReaderWriter extends Thread{
    private Monitor M;
    private Random R;
    private static int var;
    private int threadNum;
    public ReaderWriter(Monitor M, int t){
        this.M = M;
        this.R = new Random();
        this.threadNum = t;
    }//end constructor
    
    @Override
    public void run() {
        while(true){
            if(R.nextInt(5) < 1){
                M.tryWrite();
                var++;
                System.out.println("Writing from thread "+threadNum+" : "+var);
                M.endWrite();
            }//end if
            else{
                M.tryRead();
                System.out.println("Reading from thread "+threadNum+" : "+var);
                M.endRead();
            }//end else
        }//end while
        
        
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
}//end reader