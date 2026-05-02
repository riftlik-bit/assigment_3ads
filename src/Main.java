import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //Task 1
    static void task1(Scanner sc) {
        String s1 = sc.next();
        String s2 = sc.next();

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.equals(a, b) ? "YES" : "NO");
    }

    //Task 2
    static void task2(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }

    //Task 3
    static void task3(Scanner sc) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);
        System.out.println(arr[n / 2]);
    }

    //Task 4
    static boolean canShip(int[] weights, int days, int cap) {
        int daysUsed = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > cap) {
                daysUsed++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysUsed <= days;
    }

    static void task4(Scanner sc) {
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) weights[i] = sc.nextInt();
        int days = sc.nextInt();

        int lo = Arrays.stream(weights).max().getAsInt();
        int hi = Arrays.stream(weights).sum();

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canShip(weights, days, mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        System.out.println(lo);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Select task (1-4): ");
        int task = sc.nextInt();

        switch (task) {
            case 1:
                System.out.println("Enter two strings:");
                task1(sc);
                break;
            case 2:
                System.out.println("Enter array size, elements, then k:");
                task2(sc);
                break;
            case 3:
                System.out.println("Enter array size, then elements:");
                task3(sc);
                break;
            case 4:
                System.out.println("Enter array size, elements, then number of days:");
                task4(sc);
                break;
            default:
                System.out.println("Invalid task number. Choose 1-4.");
        }

        sc.close();
    }
}