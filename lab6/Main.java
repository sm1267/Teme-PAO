public class Main {
    public static void main(String[] args) {
        Task outTask = new OutTask("salut");
        Task randomOutTask1 = new RandomOutTask();
        Task counterOutTask1 = new CounterOutTask();
        Task counterOutTask2 = new CounterOutTask();

        outTask.execute();
        randomOutTask1.execute();
        counterOutTask1.execute();
        counterOutTask2.execute();

    }
}
