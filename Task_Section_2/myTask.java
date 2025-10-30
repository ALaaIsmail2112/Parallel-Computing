package Section.section2;



// =============== THREAD (EXTENDING THREAD)  ===============
// class MyThread extends Thread {
//      @Override 
//      public void run(){
//           System.out.println("Hello from MyThread");
//      }
     
// }


// public class Main{
//      public static void main(String[] args){
//           Thread t = new MyThread();
//           t.start();
//      }
// }



// =============== RUNNABLE (IMPLEMENTING RUNNABLE)  ===============

public class myTask implements Runnable{
     public void run(){
          System.out.println("Hello from MyTask");
     }
}


class Main{
     public static void main(String[] args){
          Runnable task= new myTask();
          Thread t = new Thread(task);
          t.start();
     }
}