import java.util.List;

public class MultiExecutor {
    private final List<Runnable> tasks;
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {
        // 1️⃣ نعمل لستة من الثريدات
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start(); 
        }
    }

    public static void main(String[] args) {
       
        Runnable task1 = () -> System.out.println("Task 1 running in " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task 2 running in " + Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println("Task 3 running in " + Thread.currentThread().getName());


        List<Runnable> taskList = List.of(task1, task2, task3);
        MultiExecutor executor = new MultiExecutor(taskList);
        executor.executeAll();
    }
}
