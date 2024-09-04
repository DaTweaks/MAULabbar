import java.util.concurrent.CompletableFuture;

public class Tasking {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Task completed!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Main thread continues...");

        future.join(); // Block and wait for the async task to complete
    }
}
