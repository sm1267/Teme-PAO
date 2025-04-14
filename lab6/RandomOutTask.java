import java.util.Random;

public class RandomOutTask implements Task {
    private final int randomNumber;

    public RandomOutTask() {
        Random rand = new Random();
        this.randomNumber = rand.nextInt(100);
    }

    @Override
    public void execute() {
        System.out.println(randomNumber);
    }
}
