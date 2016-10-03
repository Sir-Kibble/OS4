package os4;
public class dbdemeritt {
    public static void main(String[] args) {
        ReaderWriter[] R = new ReaderWriter[5];
        Monitor M = new Monitor();
        for(int x = 0; x < R.length; x++){
            R[x] = new ReaderWriter(M,x);
            R[x].start();
        }//end for
        
        
        
        
    }//end main
}//end dbdemeritt