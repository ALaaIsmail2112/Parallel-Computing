package section5;


// Synchronized Method
public class Counter {
     private int count =0;
      int balance;
     public synchronized void increment(){
          count++;
     }
     public synchronized int getCount(){
          return count;
     }
     // Syncronized Block 

     public void deposit(double amount){
    
     synchronized(this){
          balance += amount;
     }
}
     // // Static Sysnchronization 
     // public static synchronized void log(String message){
     //      System.err.println(message);
     // }

     // synchronized(obj){
     //      while(true){ // conditionNotMet
     //           // obj.wait();
     //      }
     //      }
     // synchronized(obj){
     //           obj.notify();
          
     // }
     // synchronized(obj){
     //           obj.notifyAll();
          
     // }
}




