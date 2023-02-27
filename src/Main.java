import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.gettime();

        Task2 task2 = new Task2();
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(task2::addFizz);
        service.submit(task2::addBuzz);
        service.submit(task2::addFizzBuzz);
        service.submit(task2::addNumbers);
    }
}