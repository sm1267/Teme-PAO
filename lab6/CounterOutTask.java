public class CounterOutTask implements Task {
    private static int counter = 0;

    public CounterOutTask() {}

    @Override
    public void execute() {
        counter++;
        System.out.println(counter);
    }
}
