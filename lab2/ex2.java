import java.util.Arrays;

public class ex2 {
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 7, 4, 3, 9, 1};
        int[] array2 = {6, 4, 2, 8};

        System.out.println("Array1 initial: " + Arrays.toString(array1));
        System.out.println("Array2 initial: " + Arrays.toString(array2));

        selectionSort(array1);
        selectionSort(array2);

        System.out.println("Array1 sortat crescator: " + Arrays.toString(array1));
        System.out.println("Array2 sortat crescator: " + Arrays.toString(array2));

        int[] mergedArray = mergeSortedArrays(array1, array2);

        System.out.println("Output: " + Arrays.toString(mergedArray));
    }
}

