

class MyThread extends Thread{
     int result = 10/0; // avoid division by zero
     
}

class MyThread1 extends Thread {
     public void run() {
          int result = 10/0; // هنا هيتشاف من handler
          System.out.println(result);
     }
}



class New  {
     public static void main(String[] args){

          Thread.setDefaultUncaughtExceptionHandler((thread , e)->{
               System.out.println("Default Thread Will Catch any Thread " + e.getMessage());

          });

          // Thread t0 = new MyThread();

          MyThread1 t1 = new MyThread1();
          t1.setUncaughtExceptionHandler((thread , e)->{
               System.out.println("UncaughtExceptionHnadler Thread Will Catch any Thread" + e.getMessage());

          });
      
          // t0.start();
          t1.start();

     }
}