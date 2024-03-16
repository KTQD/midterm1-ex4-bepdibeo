import java.lang.Thread;

public class Main {
    static int sum = 0;
    static int max = 1;
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        //int mid = numbers.length / 2;

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }

            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Phan tu lon nhat trong mang la: " + max);
        System.out.println("Tong cac phan tu trong mang la: " + sum);
    }
}
