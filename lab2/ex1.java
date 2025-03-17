import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("introduceti un numar intre 0 si 5: ");
            while (!scanner.hasNextInt()) {
                System.out.println("numar invalid");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n < 0 || n > 5);

        int[] array = new int[n];
        System.out.println("introduceti " + n + " numere:");
        for (int i = 0; i < n; i++) {
            while (!scanner.hasNextInt()) {
                System.out.println("numar invalid");
                scanner.next();
            }
            array[i] = scanner.nextInt();
        }

        reverseAndPrintArray(array);

        scanner.close();
    }

    private static void reverseAndPrintArray(int[] array) {
        System.out.print("Output: [");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
