public class racecondition {

     static int counter = 0;

     public static void main(String[] args){
          Thread t1 = new Thread(new MyTask() , "Thread 1");
          Thread t2 = new Thread(new MyTask() , "Thread 2");

          t1.start();
          t2.start();

     }

     static class MyTask implements Runnable{
          public void run(){
               for (int i=0 ; i < 5 ; i++){
                    synchronized(racecondition.class){
                         int current = counter;
                         try {
                                Thread.sleep(10);
                              
                         } catch (InterruptedException  e) {
                              // TODO: handle exception
                         }
                       
                           int updated = ++counter;
                            System.out.println(Thread.currentThread().getName()
               +" current " + current + " Updated "+ updated);

                    }
                    
                  
                   
               }
          }
     }
     
}
