

//////////////  Directly assign name ////////////// 
// public class Example1{
//      public static void main(String[] args){
//           Thread t1 = new Thread("MyFirstThread");
//           t1.start();
//           System.out.println("Thread Name : " + t1.getName());
//      }
// }


////////////// using setName ////////////// 

// public class Example2{
//      public static void main(String[] args){
//           Thread t2 = new Thread();
//           t2.setName("worker Thread-1");
//           t2.start();
//           System.out.println("Thread Name : " + t2.getName());
//      }
// }


////////////// give name to thread using Runnable ////////////// 


// public class Example3{
//      public static void main(String[] args){
//           Runnable task = () -> System.out.println("Running in :" +
//           Thread.currentThread().getName());
//           Thread t3 = new Thread(task , "RunnableThread");
//           t3.start();

//      }      


// }


//////////////  Thread Priority //////////////


// public class Example1 {
//      public static void main(String[] args){
//           Thread t1 = new Thread (() -> System.out.println("Thread 1 Priority :"+
//           Thread.currentThread().getPriority()));
//           Thread t2 = new Thread (() -> System.out.println("Thread 2 Priority :"+
//           Thread.currentThread().getPriority()));
         
//           t1.setPriority(Thread.MIN_PRIORITY);
//           t2.setPriority(Thread.MAX_PRIORITY);

//           t1.start();
//           t2.start();

//      }

// }




//////////////  Thread States //////////////


// public class ThreadStateDemo{
//      public static void main(String[] args) throws InterruptedException{
//           Thread t1 = new Thread(()->{
//                System.out.println("State inside run() :" +
//                Thread.currentThread().getState());
//           });

//           // state 1: NEW
//           System.out.println("Before start() "+t1.getState());
//           // state 1: Runnable
//           t1.start();
//           System.out.println("After start() "+t1.getState());
//           t1.join();

//           System.out.println("After completion() "+t1.getState());

//      }
// }



//////////////  Thread Group //////////////

// public class ThreadGroupExample{
//      public static void main(String[] args){
//           // create new threadgroup 
//           ThreadGroup group = new ThreadGroup("MyGroup");

//           // create thread inside group 
//           Thread t1 = new Thread(group ,()->{
//                System.out.println(Thread.currentThread().getName() + " in "+
//                Thread.currentThread().getThreadGroup().getName());
//           } ,"Thread-1");
//           Thread t2 = new Thread(group ,()->{
//                System.out.println(Thread.currentThread().getName() + " in "+
//                Thread.currentThread().getThreadGroup().getName());

//           },"Thread-2");

//           t1.start();
//           t2.start();
//      };
// }


//////////////  Thread Group //////////////


public class ListThreadInGroup{
     public static void mian(String[] args) throws  InterruptedException{
          ThreadGroup group = new ThreadGroup("Workers");

          Thread t1 = new Thread(group,() -> System.out.println("Running :" + 
          Thread.currentThread().getName()) , "worker-1");
          Thread t2 = new Thread(group,() -> System.out.println("Running :" + 
          Thread.currentThread().getName()) , "worker-2");

          t1.start();
          t2.start();

          Thread.sleep(100); // wait for them to start

          System.out.println("Active Thread in Groups :" + group.activeCount());
          group.list();

          

     }
}



////////////// DAEMON VS USER THREAD //////////////


// public class UserThreadExample{
//      public static void main(String[] args){
//           Thread t = new Thread(()->{
//                System.out.println("inside user thread :" +
//                Thread.currentThread().getName());
//           },"UserThread-1");
//           t.start();
//           System.out.println("Main thread ens :" + Thread.currentThread().getName());
//      }
// }