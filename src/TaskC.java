
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public float LinearSearch(float[] arr) {
        long startTime = System.nanoTime();

        for (float temp : arr) {
            if (temp >= 30) {
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                System.out.println("execution time:"+executionTime);
                return temp;
            }
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("item not found. Execution time:"+executionTime);
        return 0;
    }

    public float BinarySearch(float[] arr) {
        int low = 0;
        int high = arr.length - 1;
        float result = -1;
        long startTime = System.nanoTime();


        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= 30.0f) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("execution time:" +executionTime);
        return result;
    }

    public static void main(String[] args) {
        TaskC C = new TaskC();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of temperatures: ");
        int n = sc.nextInt();

        Random random = new Random();
        float[] temp = new float[n];


        for (int i = 0; i < n; i++) {
            temp[i] = random.nextFloat(20,50);
        }

        Arrays.sort(temp);

        float linearResult = C.LinearSearch(temp);
        System.out.println("Linear Search result (≥30): " + linearResult);


        float binaryResult = C.BinarySearch(temp);
        System.out.println("Binary Search result (≥30): " + binaryResult);
    }
}
