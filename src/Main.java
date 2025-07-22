import java.util.Random;
import java.util.Scanner;

public class Main {

    public float LinearSearch(float[]arr, String s)
    {  if(s.equals("temperature")) {
        long startTime = System.nanoTime();
        float min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min >= arr[i])
                min = arr[i];
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");

        return min;
    }
    else if(s.equals("pressure"))
    {long startTime = System.nanoTime();
        float max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max <= arr[i])
                max = arr[i];
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");

        return max;

    }
        return 0;
    }



    public float NaivePairwise(float[]arr,String s)
    {   if(s.equals("temperature")) {
        long startTime1 = System.nanoTime();
        float min = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    flag = true;
            }
            if (!flag) {
                min = arr[i];
            }
            flag = false;
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime1;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");
        return min;
    }

    else if (s.equals("pressure"))
    {long startTime = System.nanoTime();
        float max=0;
        boolean flag=false;
        for(int i=0; i<arr.length; i++)
        { for(int j=0;j<arr.length;j++)
        { if(arr[i]<arr[j])
            flag=true;
        }
            if(!flag)
            {
                max=arr[i];
            }
            flag=false;
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution Time: " + executionTime + " nanoseconds");
        return max;

    }
        return 0;
    }



    public static void main(String[] args) {

        Main f1 = new Main();
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        Random random = new Random();
        float[] temp= new float[n];
        float[] press= new float[n];

        for(int i=0; i<n; i++) //initialize random number
        {
            temp[i]=random.nextFloat(-20,50);
            press[i]=random.nextFloat(950,1050);
        }

        System.out.println("Task A: \n for temprature:");


        System.out.println("minimum temprature: "+f1.LinearSearch(temp,"temperature"));
        System.out.println("       ");
        System.out.println("for pressure:");
        System.out.println("max pressure: "+ f1.LinearSearch(press,"pressure"));
        System.out.println("     \n  ");

        System.out.println("Task B \n for temprature:");
        System.out.println("minimum temprature: "+f1.NaivePairwise(temp,"temperature"));

        System.out.println("       ");
        System.out.println("for pressure:");
        System.out.println("max pressure: "+ f1.NaivePairwise(press,"pressure"));



    }
}
