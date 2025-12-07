// package section5.section6;

// import java.util.concurrent.TimeUnit;

//  Traditional Synchronized Approach
// public class Synchronization{
//      private final Object monitor = new Object();
//      public void criticalSection(){
//           synchronized (monitor){
//                // Critical section code
//                System.out.println("Executing critical section");
//           }
//      }
// }



//  Modern ReentrantLock Approach 
// import java.util.concurrent.locks.ReentrantLock;
// public class ReentrantLockEample{
//      private final ReentrantLock lock = new ReentrantLock();
//      public void criticalSection(){
//           lock.lock();
//           try{
//                System.out.println("Execution Critical example ");
//           }
//           finally{
//                lock.unlock();
//           }
//      }

// }

// The lock Interface Archticture 
// public interface Lock {
//      void lock();
//      void unlock();
//      boolean trylock();
//      boolean trylock(long time , TimeUnit unit ) throws InterruptedException;

//      void lockInterruptibly() throws InterruptedException;
//      Condition newCondition();
      
// }


// REENTRANTLOCK FEATURES


// ReentrantLock lock = new REENTRANTLOCK();
// void method1(){
//      lock.lock();
//      try{
//           System.out.println("Method 1");
//           method2();

//      } finally{
//           lock.unlock();
//      }
// }

// void method2(){
//      lock.lock();
//      try{
//           System.out.println("Method 2");
//      }finally{
//           lock.unlock();
//      }
// }



// REENTRANTLOCK FEATURES

// if(lock.trylock()){
//      try{
//           System.out.println("Got the Lock ");
//      }finally{
//           lock.unlock();
//      }
//         }else{
//           System.out.println("Couldn't get the lock , will try again")
//         }



          // REENTRANTLOCK FEATURES

// try{
//      if(lock.tryLock(2,TimeUnit.SECONDS)){
//           try{
//                System.out.println(" Got the lock within 2 seconds ");

//           }finally{
//                lock.unlock();
//           }
    
//      }
//       else{
//                System.out.println("Time after 2 seconds");
//           }
// }catch(InterruptedException e ){
//      Thread.currentThread().interrupt();

// }